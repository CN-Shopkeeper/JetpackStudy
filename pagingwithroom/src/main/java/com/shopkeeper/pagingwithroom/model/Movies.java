package com.shopkeeper.pagingwithroom.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

    @SerializedName("count")
    private int count;

    @SerializedName("movies")
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
