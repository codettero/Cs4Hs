package com.example.android.popularmoviesfull;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/* Pentru a adauga toate datele in lista clasa RecyclerViewAdapter trebuie
 * sa extinda RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
 * Clasa aceasta creeaza in mod dinamic view-uri pentru obiectele folosite in lista.
 *      - incarca view-uri noi, sterge view-uri vechi */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    /* TO DO 4
     * TO DO 4.1 Declara atributul privat de tipul Context cu numele mContext
     * TO DO 4.2 Declara lista privata de tipul List<Movie> cu numele mMovieList*/
    private Context mContext;
    private List<Movie> mMovieList;
    /* TO DO 5
     * Implementeaza constructorul clasei
     * REMINDER: Si RecyclerViewAdapter reprezinta o clasa, o clasa cu atribute, metode si
     * constructor! La fel cum am completat constructorul in DetailsActivity ieri, trebuie ca
     * atributele private declarate mai sus sa primeasca valoarea parametrilor din constructor
     */
    public RecyclerViewAdapter(Context context, List<Movie> movies){
        mContext = context;
        mMovieList = movies;
    }
    
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        /* TO DO 6 Metoda onBindViewHolder() populeaza elementele din viewHolder-ul "holder" dat
         * ca parametru cu informatia din obiectul de la pozitia "position" din recyclerView
         * TO DO 6.1 Obtine filmul care se afla in lista de filme a Adapter-ului la pozitia
         * "position" pe care aceasta functie o primeste ca parametru.
         * HINT: Pentru a obtine un element dintr-o lista, se apeleaza metoda get() a listei
         * respective, metoda care ia ca parametru un numar intreg care corespunde pozitia
         * elementului din lista pe care vrem ca aceasta sa il returneze.
         */
        Movie movie = mMovieList.get(position);


        /* TO DO 6.2 Obtine calea la fisier prin apelarea getter-ului corespunzator al filmului
         * pe care tocmai l-ati luat din lista. Salvati calea intr-o variabila de tip String
         */
        String posterPath = movie.getPosterPath();


        /* TO DO 6.3 Vrem sa populam ImageView-ul din ViewHolder-ul pe care il editam momentan.
         * Acesta este exact obiectul holder primit ca parametru. Vrem sa populam Imaginea din
         * interiorul acestuia apeland metoda setPoster() pentru obiectul holder. Metodei setPoster()
         * ii dam ca parametru numele pozei pe care l-am obtinut mai sus.
         */
        holder.setPoster(posterPath);
    }
    
    /* returneaza lungimea listei */
    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    /* Afiseaza lista de filme cu RecyclerView */
    public class ViewHolder extends RecyclerView.ViewHolder{
        /* TO DO 1 Adauga variabila membru de tip ImageView numita poster.
         * Precum am discutat, putem spune ca fiecare ViewHolder are un mic layout
         * atasat. Aici trebuie declarate toate elementele din ViewHolder (noi avem)
         * un singur element, si anume un ImageView care ii corespunde posterului.
         * Daca nu iti mai amintesti cum se facea asta, poti intra in DetailsActivity unde
         * ieri ai declarat toate elementele din layout pe care voiai sa le modifici ulterior*/
        private ImageView poster;
        
        /* Constructorul clasei */
        public ViewHolder(View itemView) {
            super(itemView);
            /* TO DO 2 Intra in fisierul grid_item.xml si fa to do-ul :) si apoi revino aici
             * Mai jos identificam in layout ImageView-ul declarat anterior folosind findViewById,
             * dar momentan ImageView-ul din grid_item nu are setat nici un id dupa care poate fi
             * identificat aici. In asta consta to do-ul de acolo.
             */
            poster = itemView.findViewById(R.id.holder_poster_iv);
        }
        
        /* Seteaza posterul */
        public void setPoster(String posterPathParam) {
            int resID = mContext.getResources().getIdentifier(posterPathParam, "drawable", mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(resID);
            /* TO DO 3: seteaza imaginea poster-ului cu setImageDrawable(drawable)
             * Exact cum am facut in DetailsActivity cand ii setam posterului imaginea
             * corespunzatoare.
             *
             * Hint: setImageDrawable ;)*/
            poster.setImageDrawable(drawable);
        }
    }
}
