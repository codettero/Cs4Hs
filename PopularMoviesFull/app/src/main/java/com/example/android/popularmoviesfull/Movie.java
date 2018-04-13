package com.example.android.popularmovies;

/**
 * Created by Codette on 13.04.2018.
 */

public class Movie {
    /* 
     * TODO 1
     * Definesteste variabilele membru ale acestei clase.
     * Poti include toate detaliile din activity_details.xml
     * Nume, id, calea poster-ului, rating, data aparitiei.
     */
    private int mId;
    private String mPosterPath;
    private String mSynopsis;
    private String mRating;
    private String mReleaseDate;

    /*
     * TODO 2
     * Defineste constructorul acestei clase.
     * El primeste ca argumente variabile de care ai nevoie ca sa creezi obiectul tau.
     * Valorile variabilelor sunt preluate de variabilele membru.
     */
    public Movie(String title, int id, String path, String synopis, String rating, String releaseDate) {
        mTitle = title;
        mId = id;
        mPosterPath = path;
        mSynopsis = synopis;
        mRating = rating;
        mReleaseDate = releaseDate;
    }

    /*
     * TODO 3
     * Variabilele membru ale clasei sunt private.
     * Pentru a le putea accesa valoarea, fa getteri pentru ele.
     */
    public String getTitle() {
        return mTitle;
    }

    public int getId() {
	return mId;
    }

    public String getRawPosterPath()  {
	return mPosterPath;
    }

    public String getPosterPath() {
        return IMAGE_URL_BASE + IMAGE_URL_SIZE + mPosterPath;
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
