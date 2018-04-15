package com.example.android.popularmoviesfull;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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

    public Movie getItem(int id){ return mMovieList.get(id);}

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.holder_poster_iv);
            itemView.setOnClickListener(this);
        }

        public void setPoster(String posterPathParam) {
            String IMAGE_URL_BASE = "http://image.tmdb.org/t/p/";
            String IMAGE_URL_SIZE = "w185/";

            // TODO 3: Se adauga picasso in app.gradle adaugand la dependencies
            // implementation 'com.squareup.picasso:picasso:2.5.2'
            Picasso.with(mContext)
                    .load(IMAGE_URL_BASE + IMAGE_URL_SIZE + posterPathParam)
                    .into(poster);
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
