package com.example.movielatest;

import java.util.ArrayList;

public class movies {
    private int imageResourse;
    private String title;
    private int ratingBar;
    private String Description;
    private String date;
    private Boolean favorite;

    public movies() {
    }

    public movies(int imageResourse, String title, int ratingBar) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.ratingBar = ratingBar;
    }

    public movies(int imageResourse, String title, int ratingBar, String description, String date, Boolean favorite) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.ratingBar = ratingBar;
        Description = description;
        this.date = date;
        this.favorite = favorite;
    }
    public ArrayList<movies> fillMoviesList(){
        ArrayList<movies> moviesList = new ArrayList<>();
        moviesList.add(new movies(R.drawable.avengers,"Avengers:Infinity War",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.alladin,"Alladin",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.baby_driver,"Baby Driver",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.avengers,"Avengers:Infinity War",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.alladin,"Alladin",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.baby_driver,"Baby Driver",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.avengers,"Avengers:Infinity War",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.alladin,"Alladin",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.baby_driver,"Baby Driver",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.avengers,"Avengers:Infinity War",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.alladin,"Alladin",5,"Avengers Endgame","25/05/2021",true));
        moviesList.add(new movies(R.drawable.baby_driver,"Baby Driver",5,"Avengers Endgame","25/05/2021",true));
        return moviesList;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(int ratingBar) {
        this.ratingBar = ratingBar;
    }
}