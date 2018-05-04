package com.example.android.popularmoviesfull;

/**
 * Created by Codette on 13.04.2018.
 */

public class Movie {

    private String mTitle;
    private String mPosterPath;
    private String mSynopsis;
    private String mRating;
    private String mReleaseDate;

    public Movie(String title, String path, String synopsis, String rating, String releaseDate) {
        mTitle = title;
        mPosterPath = path;
        mSynopsis = synopsis;
        mRating = rating;
        mReleaseDate = releaseDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getRawPosterPath()  {
	return mPosterPath;
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
