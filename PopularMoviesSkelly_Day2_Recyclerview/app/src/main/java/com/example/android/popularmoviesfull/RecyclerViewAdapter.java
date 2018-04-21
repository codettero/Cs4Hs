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
    /* TODO 4
     * i) Creeaza atributul privat de tipul Context cu numele mContext
     * ii) Creeaza lista privata de tipul List<Movie> cu numele mMovieList*/

    /* TODO 5
     * Implementeaza constructorul clasei
     * Seteaza valoarea variabilelor interne la valoarea parametrilor.
     */
    public RecyclerViewAdapter(Context context, List<Movie> movies){

    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        /* TODO 6 Ia referintele view-urilor si seteaza-le la ce doresti.
         * i) Obtine un film din lista mMovieList folosindu-te de metoda get(), care ia
         * ca parametru pozitia elementului dorit din lista.
         *
         * ii) Obtine calea la fisier prin apelarea metodei getPosterPath din clasa movie,
         * pentru obiectele Movie.
         * 
         */







        /* TODO 7 Vrem sa populam ImageView-ul din ViewHolder-ul pe care il editam momentan.
        Acesta este exact obiectul holder primit ca parametru. Vrem sa populam Imaginea din
        interiorul acestuia apeland metoda setPoster() pentru obiectul holder. Metodei setPoster()
        ii dam ca parametru numele pozei pe care l-am obtinut mai sus.
         */

    }

    /* returneaza lungimea listei */
    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    /* Afiseaza lista de filme cu RecyclerView */
    public class ViewHolder extends RecyclerView.ViewHolder{
        /* TODO 1 Adauga variabila membru de tip ImageView si nume poster. */


        /* Constructorul clasei */
        public ViewHolder(View itemView) {
            super(itemView);
            /* TODO 2
             * i) Intra in fisierul grid_item.xml si fa todo-urile :) si apoi revino aici
             */
            poster = itemView.findViewById(R.id.holder_poster_iv);
        }

        /* Functie care primeste ca parametru numele imaginii din drawable pe care o incarcam
         * in viewholder si seteaza ImageView-ului din ViewHolder imaginea cu numele respectiv */
        public void setPoster(String posterPathParam) {
            int resID = mContext.getResources().getIdentifier(posterPathParam, "drawable", mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(resID);
            /* TODO 3: seteaza imaginea poster-ului cu setImageDrawable(drawable) */

        }
    }
}
