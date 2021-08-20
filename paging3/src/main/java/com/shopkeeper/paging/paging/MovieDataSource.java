package com.shopkeeper.paging.paging;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.volley.GsonRequestUtils;
import com.shopkeeper.paging.volley.VolleySingleton;

public class MovieDataSource extends ItemKeyedDataSource<Integer, Movie> {
    public static final int PER_PAGE_SIZE = 10;
    private final Context context;

    public MovieDataSource(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Movie movie) {
        return movie.getId();
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Movie> loadCallback) {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(loadParams.key, 10,
                        response -> {
                            if (response != null) {
//                                把数据传递给pagedList
                                loadCallback.onResult(response);
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Movie> loadCallback) {

    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> loadInitialParams, @NonNull LoadInitialCallback<Movie> loadInitialCallback) {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(0, 10,
                        response -> {
                            if (response != null) {
//                                把数据传递给pagedList
                                loadInitialCallback.onResult(response);
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }
}
