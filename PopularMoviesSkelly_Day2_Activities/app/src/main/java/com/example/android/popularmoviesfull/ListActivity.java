package com.example.android.popularmoviesfull;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements RecyclerViewAdapter.ListItemClickListener{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<Movie> dummyMovies = makeDummyMovies();

        recyclerView = findViewById(R.id.movie_list_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, calculateNoOfColumns(this)));
        recyclerViewAdapter = new RecyclerViewAdapter(ListActivity.this, dummyMovies, this);
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


    // TODO 2: Implementam metoda onListItemClick care ia ca parametru indexul elementului
    // selectat in urma click-ului.
    @Override
    public void onListItemClick(int clickedItemIndex) {
        // TODO 2.1: Apelam getItem(index-ul elementului selectat) pentru a obtine filmul
        // de la acel index


        // TODO 2.2: Cream un intent care face legatura dintre activitatea curenta si
        // DetailsActivity.class

        // TODO 2.3: Folosind metoda putExtra(), transmitem filmul selectat de utilizator
        // prin intent la activitatea Details

    }
}
