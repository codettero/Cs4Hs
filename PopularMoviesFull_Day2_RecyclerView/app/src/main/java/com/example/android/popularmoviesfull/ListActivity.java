package com.example.android.popularmoviesfull;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

/* Aceasta este clasa noastra pentru lista de activitati
 * Ea se va ocupa cu crearea Recycler View-ului si
 * cu adaugarea mai multor filme intr-o lista ce va fi afisata
 */
public class ListActivity extends AppCompatActivity {
    /* TODO 1
     * i) Creeaza un membru intern(atribut) privat de tipul
     * RecyclerView. Da-i numele recyclerView
     * ii) Creeaza un membru intern(atribut) privat de tipul
     * RecyclerViewAdapter. Da-i numele recyclerViewAdapter
     */
     
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    
    /*
     * Reminder: Metoda onCreate este apelata automat la lansarea activitatii.
     * OVERVIEW ON CREATE
     * i) Obtine RecyclerView cu findViewById
     * ii) Fa o lista de filme
     * iii) Afiseaz-o cu recycler view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Se ia content-ul activity_list, unde ne aflam */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        
        /* TODO 2.1 Creeaza o lista de filme
         * i) Creeaza o lista folosind List<Movie>
         * ii) Initializeaza aceasta lista cu valoarea
         * returnata de metoda makeDummyMovies()
         */
        List<Movie> dummyMovies = makeDummyMovies();
        
        /* TODO 2.2 Obtinem recyclerView-ul in functie de id-ul lui
         * cu ajutorul functiei findViewById */
        recyclerView = findViewById(R.id.movie_list_rv);
        /* Seteaza layout manager-ul pentru recyclerView */
        recyclerView.setLayoutManager(new GridLayoutManager(this, calculateNoOfColumns(this)));
        /* TODO 2.3 Instantiem un nou obiect de tipul RecyclerViewAdapter
         * i) Numele variabilelei va fi recyclerViewAdapter
         */
        recyclerViewAdapter = new RecyclerViewAdapter(this, dummyMovies);
        /* TODO 2.4 Seteaza adapt-erul pentru recyclerViewAdapter */
        recyclerView.setAdapter(recyclerViewAdapter);
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
        /* Declaram o lista de filme cu numele movies */
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
}
