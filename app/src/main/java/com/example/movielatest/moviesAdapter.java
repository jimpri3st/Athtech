package com.example.movielatest;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class moviesAdapter extends RecyclerView.Adapter<moviesAdapter.moviesViewHolder> implements Filterable {
    private static ArrayList<movies> mMoviesList;
    private static ArrayList<movies> mMoviesListFull;
    private static Context mContext;



    public moviesAdapter(ArrayList<movies> mMovieslist, Context mContext) {
        this.mMoviesList = mMovieslist;
        this.mContext = mContext;
    }

    public static class moviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mImageView;
        public TextView mTextView;
        public RatingBar mRatingBar;
        public TextView mDescription;
        public moviesViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView = itemView.findViewById(R.id.textview);
            mRatingBar = itemView.findViewById(R.id.RatingBar);
        }


        public void onClick(View v) {
            movies currentMovie = mMoviesList.get(getAdapterPosition());
            Intent MovieDetails = new Intent(mContext, MovieDetails.class);

            MovieDetails.putExtra("title", currentMovie.getTitle());
            MovieDetails.putExtra("poster", currentMovie.getImageResourse());
            MovieDetails.putExtra("RatingBar", currentMovie.getRatingBar());
            MovieDetails.putExtra("description", currentMovie.getDescription());
            MovieDetails.putExtra("releaseDate", currentMovie.getDate());
            MovieDetails.putExtra("favourite", currentMovie.getFavorite());


            //start the new movies details activity
            mContext.startActivity(MovieDetails);
        }
    }
    @NonNull
    @Override
    public moviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies, parent, false);
        moviesViewHolder mvh = new moviesViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull moviesViewHolder holder, int position) {
        movies movie = mMoviesList.get(position);
        holder.mImageView.setImageResource(movie.getImageResourse());
        holder.mTextView.setText(movie.getTitle());
        holder.mRatingBar.setNumStars(movie.getRatingBar());
    }
    @Override
    public int getItemCount() {

        return mMoviesList.size();
    }


    @Override
    public  Filter getFilter() {
        return movieFilter;
    }

    private Filter movieFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<movies> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mMoviesListFull);
            } else  {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (movies item : mMoviesListFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                mMoviesList.clear();
                mMoviesList.addAll((List) results.values);
                notifyDataSetChanged();

        }
    };

    public void filterList(ArrayList<movies> filteredList){
        mMoviesList = filteredList;
        notifyDataSetChanged();
    }
}
