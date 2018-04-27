package com.example.android.popularmoviesfull;

/**
 * Created by Codette on 13.04.2018.
 */

public class Movie {
    /*
     * TO DO 1
     * Definesteste variabilele membru ale acestei clase (vezi linia 15).
     * Poti include toate elementele din activity_details.xml
     * Titlu, calea poster-ului, descrierea, rating si data aparitiei, toate informatiile fiind
     * de tip String.
     */
    private String mTitle;
    private String mPosterPath;
    private String mSynopsis;
    private String mRating;
    private String mReleaseDate;

    /*
     * TO DO 2
     * Completeaza constructorul deja definit al acestei clase.
     * El primeste ca argumente variabile de care ai nevoie ca sa creezi obiectul tau.
     * Valorile parametrilor sunt preluate de variabilele membru (vezi linia 28).
     */
    public Movie(String title, String path, String synopsis, String rating, String releaseDate) {
        mTitle = title;
        mPosterPath = path;
        mSynopsis = synopsis;
        mRating = rating;
        mReleaseDate = releaseDate;
    }


    /*
     * TO DO 3
     * Variabilele membru ale clasei sunt private.
     * Pentru a le putea accesa valoarea, faceti getteri pentru ele.(vezi linia 41)
     */
    public String getTitle() {
        return mTitle;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getRating() {
        return mRating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }
}
