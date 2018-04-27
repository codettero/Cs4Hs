package com.example.android.popularmoviesfull;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    /*
     * TO DO 1
     * Defineste variabilele membru ale acestei clase (vezi linia 18).
     * Poti include toate view-urile din activity_details.xml.
     * De data asta, vrem sa avem view-urile:
     * ImageView: Poster.
     * TextView: titlu, rating, data aparitiei, descrierea.
     */
    public ImageView mDetailsPoster;
    public TextView mDetailsTitle;
    public TextView mDetailsRating;
    public TextView mDetailsReleaseDate;
    public TextView mDetailsSynopsis;

    /*
     * TO DO 2
     * Metoda onCreate se apeleaza automat la lansarea in executie a activitatii.
     * In aceasta metoda trebuie sa identifici view-urile si sa le setezi la niste
     * valori date de tine.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* se seteaza content-ul actual */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /*
         * TO DO 2.1
         * Trebuie sa identifici view-urile dupa id-ul dat in XML.
         * i) Apeleaza metoda findViewById(R.id.<id_view>)
         *    - inlocuieste <id_view> cu ID-ul view-ului tau din XML
         * ii) Pune rezultatele in variabilele membru corespunzatoare. (vezi linia 43)
         */
        mDetailsPoster = findViewById(R.id.details_poster_iv);
        mDetailsTitle = findViewById(R.id.details_title_tv);
        mDetailsRating = findViewById(R.id.details_rating_tv);
        mDetailsReleaseDate = findViewById(R.id.details_date_tv);
        mDetailsSynopsis = findViewById(R.id.details_synopsis_tv);

        /* TO DO 2.2
         * Creeaza inca doua obiecte de tip Movie folosind constructorii completati de voi in clasa Movie.
         * Da ca parametru string-urile corespunzatoare fiecarui membru
         * intern al clasei Movie (vezi liniile 56-57).
         * In res/drawable aveti inca doua fisiere JPG pe care le puteti da ca parametru
         * constructorilor pentru celalalte 2 filme.
         */
        Movie film1 = new Movie("Harry Potter", "image_film_one",
                "qwertyuiopqwertyuiop", "9.5", "10/03/2018");

        Movie film2 = new Movie("Avatar", "image_film_two",
                "asdfghjklasdfghjkl", "7.5", "01/05/2017");

        Movie film3 = new Movie("Black Mirror", "image_film_three",
                "zxcvbnmzxcvbnm", "5.3", "10/11/2016");

        /* TO DO 2.3
         * Dupa ce ai creeat obiectele de tip Movie, poti
         * incerca sa creezi orice alt film si sa il testezi, fara
         * sa il stergi pe cel dinainte si fara sa faci prea multe modificari.
         *
         * Hint: Salveaza ce film vrei sa folosesti dintre cele instantiate mai
         * sus intr-o noua variabila de tip Movie si foloseste-o pe aceea in to do-urile urmatoare.
         */
        Movie movie = film2;


        /* Liniile 79-80 sunt folosite pentru a
         * obtine obiectul Drawable necesar pentru poster
         */
        int resID = getResources().getIdentifier(movie.getPosterPath(), "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(resID);

        /*
         * TO DO 2.4
         * Seteaza imageView-ul(pentru poster)
         * Apeleaza metoda setImageDrawable(drawable) pentru obiectul
         * tau de tip ImageView
         */
        mDetailsPoster.setImageDrawable(drawable);

        /*
         * TO DO 2.5
         * Seteaza textView-urile
         * Apeleaza metoda setDrawable pentru obiectele tale de tip TextView
         * Ca parametru, foloseste atributele din obiectele de tip Movie.
         */
        mDetailsTitle.setText(movie.getTitle());
        mDetailsReleaseDate.setText(movie.getReleaseDate());
        mDetailsRating.setText(movie.getRating());
        mDetailsSynopsis.setText(movie.getSynopsis());

    }


}
