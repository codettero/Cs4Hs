package com.example.android.popularmoviesfull;

import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Codette on 13.04.2018.
 */

public class Movie implements Parcelable{

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

    protected Movie(Parcel in) {
        mTitle = in.readString();
        mPosterPath = in.readString();
        mSynopsis = in.readString();
        mRating = in.readString();
        mReleaseDate = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mPosterPath);
        parcel.writeString(mSynopsis);
        parcel.writeString(mRating);
        parcel.writeString(mReleaseDate);
    }
}
