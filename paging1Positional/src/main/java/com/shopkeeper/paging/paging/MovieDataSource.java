package com.shopkeeper.paging.paging;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.android.volley.Response;
import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.model.Movies;
import com.shopkeeper.paging.volley.GsonRequestUtils;
import com.shopkeeper.paging.volley.VolleySingleton;

public class MovieDataSource extends PositionalDataSource<Movie> {

    public static final int PER_PAGE_SIZE = 10;
    private final Context context;

    public MovieDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams loadInitialParams, @NonNull LoadInitialCallback<Movie> loadInitialCallback) {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(0,
                        PER_PAGE_SIZE,
                        (Response.Listener<Movies>) response -> {
                            if (response != null) {
//                                把数据传递给pagedList
                                loadInitialCallback.onResult(response.getMovieList(), response.getStart(), response.getTotal());
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams loadRangeParams, @NonNull LoadRangeCallback<Movie> loadRangeCallback) {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(loadRangeParams.startPosition,
                        PER_PAGE_SIZE,
                        (Response.Listener<Movies>) response -> {
                            if (response != null) {
//                                把数据传递给pagedList
                                loadRangeCallback.onResult(response.getMovieList());
                                Log.i("shopkeeperTag", "loadRange: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }
}
