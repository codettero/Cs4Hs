package com.example.android.popularmoviesfull;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public ImageView mDetailsPoster;
    public TextView mDetailsTitle;
    public TextView mDetailsRating;
    public TextView mDetailsReleaseDate;
    public TextView mDetailsSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mDetailsPoster = findViewById(R.id.details_poster_iv);
        mDetailsTitle = findViewById(R.id.details_title_tv);
        mDetailsRating = findViewById(R.id.details_rating_tv);
        mDetailsReleaseDate = findViewById(R.id.details_date_tv);
        mDetailsSynopsis = findViewById(R.id.details_synopsis_tv);

        Movie film1 = new Movie("Harry Potter", "image_film_one",
                "qwertyuiopqwertyuiop", "9.5", "10/03/2018");

        Movie film2 = new Movie("Avatar", "image_film_two",
                "asdfghjklasdfghjkl", "7.5", "01/05/2017");

        Movie film3 = new Movie("Black Mirror", "image_film_three",
                "zxcvbnmzxcvbnm", "5.3", "10/11/2016");

        // TODO 3.1: Captam intent-ul trimis de ListActivity care contine filmul ce trebuie afisat

        // TODO 3.2: Extragem filmul din intent folosind getParcelableExtra()
        

        int resID = getResources().getIdentifier(movie.getPosterPath(), "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(resID);

        mDetailsPoster.setImageDrawable(drawable);

        mDetailsTitle.setText(movie.getTitle());
        mDetailsReleaseDate.setText(movie.getReleaseDate());
        mDetailsRating.setText(movie.getRating());
        mDetailsSynopsis.setText(movie.getSynopsis());

    }


}
