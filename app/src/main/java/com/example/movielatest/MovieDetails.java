package com.example.movielatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        TextView moviesTitle = (TextView)findViewById(R.id.title);
        RatingBar moviesRating = (RatingBar) findViewById(R.id.RatingBar);
        TextView moviesDescription = (TextView)findViewById(R.id.Description);
     //   TextView moviesReleaseDate = (TextView)findViewById(R.id.);
//        TextView moviesFavourite = (TextView)findViewById(R.id.favouriteDetail);



        ImageView moviesCover = (ImageView)findViewById(R.id.poster);
       // ImageView moviesFavouriteIcon = (ImageView)findViewById(R.id.moviesFavouriteIconDetail);
        moviesCover.setImageResource(getIntent().getIntExtra("poster",0));
        moviesTitle.setText(getIntent().getStringExtra("title"));
        moviesRating.setNumStars(getIntent().getIntExtra("ratingBar",0));
        moviesDescription.setText(getIntent().getStringExtra("description"));
     //   moviesReleaseDate.setText(getIntent().getStringExtra("releaseDate"));
//        moviesFavourite.setText(getIntent().getStringExtra("favourite"));
//        moviesFavouriteIcon.setImageResource();

    }
}