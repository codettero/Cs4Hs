package com.example.android.popularmoviesfull;

/**
 * Created by Codette on 13.04.2018.
 */

public class Movie {
    /* 
     * TODO 1
     * Definesteste variabilele membru ale acestei clase.
     * Poti include toate detaliile din activity_details.xml
     * Nume, calea poster-ului, descrierea, rating, data aparitiei.
     */
    private String mTitle;


    /*
     * TODO 2
     * Defineste constructorul acestei clase.
     * El primeste ca argumente variabile de care ai nevoie ca sa creezi obiectul tau.
     * Valorile variabilelor sunt preluate de variabilele membru.
     */
    public Movie(String title, String path, String synopsis, String rating, String releaseDate) {
        mTitle = title;

    }

    /*
     * TODO 3
     * Variabilele membru ale clasei sunt private.
     * Pentru a le putea accesa valoarea, fa getteri pentru ele.
     */
    public String getTitle() {
        return mTitle;
    }

}
