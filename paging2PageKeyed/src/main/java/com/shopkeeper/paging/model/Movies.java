package com.shopkeeper.paging.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("subjects")
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "hasMore=" + hasMore +
                ", movieList=" + movieList +
                '}';
    }
}
