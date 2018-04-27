package com.example.android.popularmoviesfull;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    /*
     * TODO 1
     * Definesteste variabilele membru ale acestei clase (vezi linia 18).
     * Poti include toate view-urile din activity_details.xml.
     * De data asta, vrem sa avem view-urile:
     * ImageView: Poster.
     * TextView: titlu, rating, data aparitiei, descrierea.
     */
    public ImageView mDetailsPoster;

    
    /*
     * TODO 2
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
         * TODO 2.1
         * Trebuie sa identifici view-urile dupa id-ul dat in XML.
         * i) Apeleaza metoda findViewById(R.id.<id_view>)
         *    - inlocuieste <id_view> cu ID-ul view-ului tau din XML
         * ii) Pune rezultatele in variabilele membru corespunzatoare. (vezi linia 40)
         */
        mDetailsPoster = findViewById(R.id.details_poster_iv);

        
        /* TODO 2.2
         * Creeaza inca doua obiecte de tip Movie folosind constructorii completati de voi in clasa Movie.
         * Da ca parametru string-urile corespunzatoare fiecarui membru
         * intern al clasei Movie (vezi liniile 48-49).
         * In res/drawable aveti inca doua fisiere JPG pe care le puteti da ca parametru
         * constructorilor pentru celalalte 2 filme.
         */
        Movie film1 = new Movie("Harry Potter", "image_film_one",
                "qwertyuiopqwertyuiop", "9.5", "10/03/2018");


        /* TODO 2.3
         * Dupa ce ai creeat obiectele de tip Movie, poti
         * incerca sa creezi orice alt film si sa il testezi, fara
         * sa il stergi pe cel dinainte si fara sa faci prea multe modificari.
         *
         * Hint: Salveaza ce film vrei sa folosesti dintre cele instantiate mai
         * sus intr-o noua variabila de tip Movie si foloseste-o pe aceea in to do-urile urmatoare.
         */




        /* Liniile 67-68 sunt folosite pentru a
         * obtine obiectul Drawable necesar pentru poster
         */
        int resID = getResources().getIdentifier(movie.getPosterPath() , "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(resID );

        /*
         * TODO 2.4
         * Seteaza imageView-ul(pentru poster)
         * Apeleaza metoda setImageDrawable(drawable) pentru obiectul
         * tau de tip ImageView
         */

        
        /*
         * TODO 2.5
         * Seteaza textView-urile
         * Apeleaza metoda setDrawable pentru obiectele tale de tip TextView
         * Ca parametru, foloseste atributele din obiectele de tip Movie.
         */
        mDetailsTitle.setText(movie.getTitle());


    }


}
