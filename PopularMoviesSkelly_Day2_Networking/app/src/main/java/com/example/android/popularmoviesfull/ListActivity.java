package com.example.android.popularmoviesfull;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements RecyclerViewAdapter.ListItemClickListener{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // TODO 3: Se elimina linia de cod pentru dummy movies. Nu mai avem nevoide de date
        // hardcodate daca folosim filmele primite de la server. De asemenea, stergeti si toata
        // functia makeDummyMovies() implementata mai jos.
        List<Movie> dummyMovies = makeDummyMovies();

        recyclerView = findViewById(R.id.movie_list_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, calculateNoOfColumns(this)));

        // Vor fi mutate in AsyncTask
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), dummyMovies, ListActivity.this);
        recyclerView.setAdapter(recyclerViewAdapter);

        // TODO 6: Se executa o noua instanta a AsyncTask-ului tocmai creat. Decomenteaza linia de mai jos
        // new RequestMoviesTask().execute(NetworkUtils.REQUEST_URL);
    }

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int scalingFactor = 150;
        int noOfColumns = (int) (dpWidth / scalingFactor);
        if(noOfColumns < 2)
            noOfColumns = 2;
        return noOfColumns;
    }

    public List<Movie> makeDummyMovies(){
        List<Movie> movies = new ArrayList<Movie>();


        Movie film1 = new Movie("Harry Potter", "image_film_one",
                "qwertyuiopqwertyuiop", "9.5", "10/03/2018");

        Movie film2 = new Movie("Avatar", "image_film_two",
                "asdfghjklasdfghjkl", "7.5", "01/05/2017");

        Movie film3 = new Movie("Black Mirror", "image_film_three",
                "zxcvbnmzxcvbnm", "5.3", "10/11/2016");

        movies.add(film1);
        movies.add(film2);
        movies.add(film3);

        return movies;
    }

    // TODO 4: Se completeaza clasa RequestMoviesTask. Aceasta primeste un string ca parametru
    // si dupa ce rularea pe background thread s-a terminat, ne returneaza o lista de Movies
    private class RequestMoviesTask extends AsyncTask<String, Void, List<Movie>> {


        // Aceasta functie defineste comportamentul aplicatiei in thread-ul secundar. Tot codul
        // scris in aceasta functie va fi executat in background
        @Override
        protected List<Movie> doInBackground(String... strings) {

            // lista de filme care va fi returnata la final
            List<Movie> movieList = new ArrayList<Movie>();
            try{
                // TODO 4.1: Se apeleaza functia getResponseFromHTTPUrl(strings[0]) iar output-ul
                // se salveaza intr-un string. Acesta va fi string-ul ce contine JSON-ul cu date
                // de la server. ATENTIE: functia se gaseste in NetworkUtils. Acolo ati implementat-o!

                // TODO 4.2: Se apeleaza functia parseMoviesJSON() careia ii dam ca parametru
                // string-ul cu informatiile in format JSON. Output-ul il salvam intr-o lista de
                // Movies (movieList). ATENTIE: functia se gaseste in NetworkUtils. Acolo ati implementat-o!

            } catch (IOException e){
                Log.e(ListActivity.class.getName(), e.getMessage());
            } catch (JSONException e){
                Log.e(ListActivity.class.getName(), e.getMessage());
            }
            // TODO 4.3: Se returneaza lista de filme

        }

        // Aceasta functie defineste comportamentul aplicatiei imediat dupa ce background
        // thread-ul a fost incheiat. Tot codul scris in cadrul acestei functii va fi rulat
        // imediat dupa ce background thread-ul a returnat lista cu filme.
        @Override
        protected void onPostExecute(List<Movie> movies) {
            super.onPostExecute(movies);

            // TODO 5: Vrem ca Adapterul sa fie initializat cu lista de filme ce rezulta din
            // background thread. Astfel, cele doua linii de cod in care se facea initializarea
            // adapter-ului si asocierea lui cu recyclerview-ul vor trebui mutate aici.

        }
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Movie selectedMovie = recyclerViewAdapter.getItem(clickedItemIndex);

        Intent startDetailsActivity = new Intent(this, DetailsActivity.class);
        startDetailsActivity.putExtra("selectedMovie", selectedMovie);
        startActivity(startDetailsActivity);
    }
}
