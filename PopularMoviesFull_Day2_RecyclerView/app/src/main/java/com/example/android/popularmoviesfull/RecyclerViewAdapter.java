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
    /* TODO 1
     * i) Creeaza atributul privat de tipul Context cu numele mContext
     * ii) Creeaza lista privata de tipul private List<Movie> cu numele mMovieList*/
    private Context mContext;
    private List<Movie> mMovieList;
    /* TODO 2
     * Implementeaza constructorul clasei
     * Seteaza valoarea variabilelor interne la valoarea parametrilor.
     */
    public RecyclerViewAdapter(Context context, List<Movie> movies){
        mContext = context;
        mMovieList = movies;
    }
    
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /* TODO 3
         * Creeaza noi view-uri cu metoda onCreateViewHolder
         * i) Du-te in directorul res si adauga un nou xml numit grid_item
         */
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) 
        /* TODO 4 Ia referintele view-urilor si seteaza-le la ce doresti.
         * i) Obtine un film din lista mMovieList.
         *
         * ii) Obtine calea la fisier prin apelarea metodei getPosterPath din clasa movie,
         * pentru obiectele Movie. 
         */
        Movie movie = mMovieList.get(position);
        String posterPath = movie.getPosterPath();
        
        /* Seteaza calea posterului ca fiind cea obtinuta mai sus.
            Ne putem referi la ea prin numele variabilei anterioare.
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
        /* TODO 5 Adauga membrul intern de tip ImageView si numele poster. */
        private ImageView poster;
        
        /* Constructorul clasei */
        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.holder_poster_iv);
        }
        
        /* Seteaza posterul */
        public void setPoster(String posterPathParam) {
            int resID = mContext.getResources().getIdentifier(posterPathParam, "drawable", mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(resID);
            /* TODO 6: seteaza imaginea poster-ului cu setImageDrawable(drawable) */
            poster.setImageDrawable(drawable);
        }
    }
}
