package com.shopkeeper.paging.paging;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.shopkeeper.paging.model.Movie;

public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie> {
    private final Context context;

    public MovieDataSourceFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DataSource<Integer, Movie> create() {
        return new MovieDataSource(context);
    }
}
