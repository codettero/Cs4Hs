package com.example.android.popularmoviesfull;

/**
 * Created by Codette on 13.04.2018.
 */

public class Movie {
    /* 
     * TODO 1
     * Defineste variabilele membru ale acestei clase (vezi linia 15).
     * Poti include toate elementele din activity_details.xml
     * Titlu, calea poster-ului, descrierea, rating si data aparitiei, toate informatiile fiind
     * de tip String.
     */
    private String mTitle;


    /*
     * TODO 2
     * Completeaza constructorul deja definit al acestei clase.
     * El primeste ca argumente variabile de care ai nevoie ca sa creezi obiectul tau.
     * Valorile parametrilor sunt preluate de variabilele membru (vezi linia 24).
     */
    public Movie(String title, String path, String synopsis, String rating, String releaseDate) {
        mTitle = title;

    }

    /*
     * TODO 3
     * Variabilele membru ale clasei sunt private.
     * Pentru a le putea accesa valoarea, faceti getteri pentru ele.(vezi linia 34)
     */
    public String getTitle() {
        return mTitle;
    }

}
