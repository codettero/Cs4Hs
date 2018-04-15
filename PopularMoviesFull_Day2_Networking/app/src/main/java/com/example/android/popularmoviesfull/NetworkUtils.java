package com.example.android.popularmoviesfull;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NetworkUtils {

    public static final String REQUEST_URL = "https://api.themoviedb.org/3/movie/popular?api_key=1a07e1d3e909a7a4d9a87cffb1b0726b";

    // TODO 1: Se implementeaza getResponseFromHTTPUrl care va face conexiunea la server si
    // va returna intr-un string raspunsul server-ului la request
    public static String getResponseFromHTTPUrl(String stringUrl) throws IOException {
        URL url = new URL(stringUrl);

        // TODO 1.1: Se initializeaza un String gol in care vom salva raspunsul la final
        String jsonResponse = "";
        // TODO 1.2: Se initializeaza un obiect HTTPUrlConnection null
        HttpURLConnection urlConnection = null;
        // TODO 1.3: Se initializeaza un obiect InputStream null
        InputStream inputStream = null;
        try{
            // TODO 1.4: Se deschide conexiunea catre server apeland openConnection() pe obiectul
            // URL de mai sus
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(15000);
            urlConnection.setReadTimeout(10000);
            // TODO 1.5: Se efectueaza conexiunea propriu-zisa
            urlConnection.connect();
            //Log.e(NetworkUtils.class.getName(),urlConnection.getResponseMessage());

            // TODO 1.6: Se extrage input stream-ul din conexiunea http
            inputStream = urlConnection.getInputStream();
            // TODO 1.7: Se apeleaza functia readFromStream() care primeste ca parametru inputStream-ul
            // din care sa citeasca. Se salveaza String-ul returnat de aceasta functie
            // in variabila definita ca sirul vid mai sus.
            jsonResponse = readFromStream(inputStream);
        } catch (IOException e){
            Log.e(NetworkUtils.class.getName(), e.getMessage());
        }
        finally {
            if(urlConnection != null){
                urlConnection.disconnect();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }

        // TODO 1.8: Se returneaza string-ul cu raspunsul JSON
        return jsonResponse;
    }

    // TODO 2: Se implementeaza functia parseMoviesJson() care ia ca parametru un String
    // ce contine informatia JSON obtinuta de la server, String din care extrage o lista
    // de filme si o returneaza
    public static List<Movie> parseMoviesJSON(String string) throws JSONException {
        List<Movie> finalMovieList = new ArrayList<Movie>();

        // TODO 2.1: Se extrage JSONObject-ul root din JSON-ul string primit ca parametru.
        JSONObject result = new JSONObject(string);

        // Se verifica faptul ca JSONObjectul nostru root contine in interiorul lui cheia "results"
        if(result.has("results")){
            // TODO 2.2: Se extrage JSONArray-ul care contine informatiile despre filme. Acest
            // jsonArray are "results" ca si key
            JSONArray movieList = result.getJSONArray("results");

            if(movieList.length() != 0){
                // Se parcurge tot jsonArray-ul ca sa luam informatii despre toate filmele
                for(int i = 0; i < movieList.length(); i++){
                    // TODO 2.3: Se extrage obiectul JSON ce contine informatii despre filmul
                    // de pe pozitia i din jsonArray
                    JSONObject movieJsonObject = movieList.getJSONObject(i);

                    // TODO 2.4: Se initializeaza un string pentru titlul filmului cu sirul vid
                    // sau "Unknown"
                    String movieTitle = "Unknown";
                    // TODO 2.5: Se verifica faptul ca JSONObjectul nostru contine
                    // in interiorul lui cheia "title" careia ii corespunde titlului filmului
                    if(movieJsonObject.has("title")){
                        // TODO 2.6: Daca da, se extrage valoarea string-ului de la cheia title
                        // Acesta va fi titlul filmului din lista.
                        movieTitle = movieJsonObject.getString("title");
                    }

                    // TODO 2.7: Se repeta pasii 2.4-2.6 pentru fiecare pereche key - value care ne
                    // intereseaza:
                    /*
                        link-ul pentru poster - key = "poster_path" - valoare de tip String
                        text pentru synopsis - key = "overview" - valoare de tip String
                        nota - key = "vote_average" - valoare de tip String
                        data aparitiei filmului - key = "release_date" - valoare de tip String
                     */
                    String moviePosterPath = "N/A";
                    if(movieJsonObject.has("poster_path")){
                        if(!movieJsonObject.getString("poster_path").equals("")){
                            moviePosterPath = movieJsonObject.getString("poster_path");
                        }
                    }

                    String movieSynopsis = "None";
                    if(movieJsonObject.has("overview")){
                        if(!movieJsonObject.getString("overview").equals("")){
                            movieSynopsis = movieJsonObject.getString("overview");
                        }
                    }

                    String movieRating = "No rating yet";
                    if(movieJsonObject.has("vote_average")){
                        if(!movieJsonObject.getString("vote_average").equals("")){
                            movieRating = movieJsonObject.getString("vote_average");
                        }
                    }

                    String movieReleaseDate = "Not released yet";
                    if(movieJsonObject.has("release_date")){
                        if(!movieJsonObject.getString("release_date").equals("")){
                            movieReleaseDate = movieJsonObject.getString("release_date");
                        }
                    }

                    // TODO 2.8: La lista creata mai sus, se adauga un nou obiect de tip Movie,
                    // obiect care are ca titly, synopsys, rating, etc, valorile obtinute prin
                    // parsarea JSON-ului pe care tocmai ce am terminat-o
                    finalMovieList.add(new Movie(movieTitle,
                            moviePosterPath,
                            movieSynopsis,
                            movieRating,
                            movieReleaseDate));
                }
            }
        }

        // TODO 2.9: Se returneaza lista finala de filme.
        return finalMovieList;
    }


    private static String readFromStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
