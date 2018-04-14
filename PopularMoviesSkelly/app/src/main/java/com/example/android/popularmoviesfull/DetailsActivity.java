package com.example.android.popularmoviesfull;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    /*
     * TODO 1
     * Definesteste variabilele membru ale acestei clase.
     * Poti include toate detaliile din activity_details.xml.
     * De data asta, vrem sa avem view-urile.
     * Image: Poster.
     * Text: titlu, rating, data aparitiei, descrierea.
     */
    public ImageView mDetailsPoster;
    public TextView mDetailsTitle;
    public TextView mDetailsRating;
    public TextView mDetailsReleaseDate;
    public TextView mDetailsSynopsis;
    
    /*
     * TODO 2
     * Metoda onCreate se apeleaza automat la lansarea in executie a activitatii.
     * In aceasta metoda trebuie sa iei view-urile si sa le setezi la niste
     * valori date de tine.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* se seteaza content-ul actual */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        
        /*
         * TODO 2.1
         * Trebuie sa obtii view-urile, ca apoi sa le setezi cu ce valori vrei tu.
         * i) Apeleaza metoda findViewById(R.id.<nume_view>_iv) pentru ImageView sau
         *    findViewById(R.id.<nume_view>_tv pentru TextView.
         *    - inlocuieste <nume_view> cu numele view-ului tau
         * ii) Pune rezultatele in variabilele membru corespunzatoare.
         */
        mDetailsPoster = findViewById(R.id.details_poster_iv);
        mDetailsTitle = findViewById(R.id.details_title_tv);
        mDetailsRating = findViewById(R.id.details_rating_tv);
        mDetailsReleaseDate = findViewById(R.id.details_date_tv);
        mDetailsSynopsis = findViewById(R.id.details_synopsis_tv);
        
        /* TODO 2.2
         * Creeaza niste obiecte de tip Movie.
         * Da ca parametru string-urile corespunzatoare fiecarui membru
         * intern al clasei Movie.
         */
        Movie film1 = new Movie("Harry Potter", "image_film_one",
                "qwertyuiopqwertyuiop", "9.5", "10/03/2018");

        Movie film2 = new Movie("Avatar", "image_film_two",
                "asdfghjklasdfghjkl", "7.5", "01/05/2017");

        Movie film3 = new Movie("Black Mirror", "image_film_three",
                "zxcvbnmzxcvbnm", "5.3", "10/11/2016");
        /* TODO 2.5
         * Dupa ce ai facut ca totul sa mearga pentru un film, poti
         * incerca sa creezi orice alt film si sa il testezi, fara
         * sa il stergi pe cel dinainte si fara sa faci prea multe modificari.
         *
         * Hint: Salveaza ce film vrei sa folosesti dintre cele instantiate mai
         * sus intr-o noua variabila si foloseste-o pe aceea in toate setarile. 
         */
        Movie movie = film2;
        /*
         * obtine obiectul Drawable necesar pentru poster
         */
        int resID = getResources().getIdentifier(movie.getPosterPath() , "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(resID );

        /*
         * TODO 2.3
         * Seteaza image view-ul(pentru poster)
         * Apeleaza metoda setImageDrawable(drawable) pentru obiectul
         * tau de tip ImageView
         */
        mDetailsPoster.setImageDrawable(drawable );
        
        /*
         * TODO 2.4
         * Seteaza text view-urile
         * Apeleaza metoda setDrawable pentru obiectele tale de tip TextView
         * Ca parametru, foloseste atributele din obiectele de tip Movie.
         */
        mDetailsTitle.setText(movie.getTitle());
        mDetailsReleaseDate.setText(movie.getReleaseDate());
        mDetailsRating.setText(movie.getRating());
        mDetailsSynopsis.setText(movie.getSynopsis());

    }


}
