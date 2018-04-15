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

    
    /*
     * Reminder: Metoda onCreate este apelata automat la lansarea activitatii.
     * TODO 2 Urmareste TODO-urile din interiorul metodei
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

        
        /* TODO 2.2 Obtinem recyclerView-ul in functie de id-ul lui
         * cu ajutorul functiei findViewById */

        /* Seteaza layout manager-ul pentru recyclerView */
        recyclerView.setLayoutManager(new GridLayoutManager(this, calculateNoOfColumns(this)));
        /* TODO 2.3 Instantiem un nou obiect de tipul RecyclerViewAdapter
         * i) Numele variabilelei va fi recyclerViewAdapter
         */

        /* TODO 2.4 Seteaza adapt-erul pentru recyclerViewAdapter */

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

    /* TODO 2.2 Creeaza o lista de filme simple
     * Adauga elementele
     */
    public List<Movie> makeDummyMovies(){
        /* Declaram o lista de filme cu numele movies */
        List<Movie> movies = new ArrayList<Movie>();

        /* TODO 2.2.1 Dorim sa cream instante pentru trei filme,
         * pe care sa le adaugam ulterior in lista
         * la apelarea construtorului, se dau ca parametrii
         * stringurilor corespunzatoare */
        Movie film1 = new Movie("Harry Potter", "image_film_one",
                "qwertyuiopqwertyuiop", "9.5", "10/03/2018");

        Movie film2 = new Movie("Avatar", "image_film_two",
                "asdfghjklasdfghjkl", "7.5", "01/05/2017");

        Movie film3 = new Movie("Black Mirror", "image_film_three",
                "zxcvbnmzxcvbnm", "5.3", "10/11/2016");

        /* TODO 2.2.2
         * Adauga, pe rand, toate cele trei filme in lista */
        movies.add(film1);
        movies.add(film2);
        movies.add(film3);

        return movies;
    }
}
