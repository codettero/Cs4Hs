package com.example.android.popularmoviesfull;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Movie> mMovieList;
    final private ListItemClickListener mListItemClickListener;

    public RecyclerViewAdapter(Context context, List<Movie> movies, ListItemClickListener listItemClickListener){
        mContext = context;
        mMovieList = movies;
        mListItemClickListener = listItemClickListener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        String posterPath = movie.getPosterPath();

        holder.setPoster(posterPath);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    // TODO 1: Cream o metoda getItem care ia ca parametru un numar intreg si returneaza
    // obiectul Movie de pe pozitia specificata in parametrii din lista de filme
    public Movie getItem(int id){ return mMovieList.get(id);}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.holder_poster_iv);
            itemView.setOnClickListener(this);
        }

        public void setPoster(String posterPathParam) {
            int resID = mContext.getResources().getIdentifier(posterPathParam, "drawable", mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(resID);

            poster.setImageDrawable(drawable);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mListItemClickListener.onListItemClick(clickedPosition);
        }
    }

    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }
}
