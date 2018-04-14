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
        Movie movie = mMovieList.get(position);
        String posterPath = movie.getPosterPath();

        holder.setPoster(posterPath);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.holder_poster_iv);
        }

        public void setPoster(String posterPathParam) {
            int resID = mContext.getResources().getIdentifier(posterPathParam, "drawable", mContext.getPackageName());
            Drawable drawable = mContext.getResources().getDrawable(resID);

            poster.setImageDrawable(drawable);
        }
    }
}
