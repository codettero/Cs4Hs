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
    /* TODO 7
     * TODO 7.1 Declara o variabila membru privata de tipul RecyclerView cu numele mRecyclerView
     * TODO 7.2 Declara o variabila membru privata de tipul RecyclerViewAdapter cu numele mRecyclerViewAdapter*/

    
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
        
        /* TODO 8.1 Creeaza o lista de filme
         * Vrem sa creem o lista de filme (tipul acesteia este List<Movie>) care sa se numeasca
         * dummyMovies. O initializam cu valoarea returnata de functia makeDummyMovies().
         * Daca explorati codul putin mai jos, veti gasi o functie numita makeDummyMovies care
         * creeaza o lista noua de filme, apeleaza constructorul de cateva ori pentru a initializa
         * niste filme, le adauga la lista si apoi returneaza lista
         */

        
        /* TODO 8.2 Obtinem recyclerView-ul in functie de id-ul lui
         * cu ajutorul functiei findViewById */



        /* Seteaza layout manager-ul pentru recyclerView */
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, calculateNoOfColumns(this)));


        /* TODO 8.3 La TODO-ul 7.2 am declarat un RecyclerViewAdapter cu numele mRecyclerViewAdapter,
         * dar acesta nu este initializat, deci momentan nu este nimic in el si nu functioneaza cum
         * vrem noi. Acestui RecyclerViewAdapter vrem sa ii dam contextul curent si lista de filme
         * cu care va popula recyclerview-ul. Facem acest lucru apeland constructorul, in aceeasi
         * maniera in care apelam constructorul in DetailsActivity pentru a instantia noi filme
         */

        /* TODO 8.4 Seteaza adapterul pentru recyclerViewAdapter
         * Acum avem un RecyclerView si un RecyclerViewAdapter, insa acestea nu comunica inca
         * intre ele. Trebuie sa ii spunem RecyclerView-ului nostru faptul ca adaptorul lui este
         * acel mRecyclerViewAdapter creeat de noi. Va mai amintiti cum se facea asta?
         * */

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
