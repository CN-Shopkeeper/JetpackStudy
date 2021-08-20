package com.shopkeeper.paging.paging;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.volley.GsonRequestUtils;
import com.shopkeeper.paging.volley.VolleySingleton;

public class MovieDataSource extends PageKeyedDataSource<Integer, Movie> {
    public static final int PER_PAGE_SIZE = 10;
    private final Context context;

    public MovieDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, Movie> loadCallback) {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(loadParams.key,
                        response -> {
                            if (response != null) {
//                                把数据传递给pagedList
                                Integer nextKey = response.isHasMore() ? loadParams.key + 1 : null;
                                loadCallback.onResult(response.getMovieList(), nextKey);
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> loadParams, @NonNull LoadCallback<Integer, Movie> loadCallback) {

    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> loadInitialParams, @NonNull LoadInitialCallback<Integer, Movie> loadInitialCallback) {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(0,
                        response -> {
                            if (response != null) {
//                                把数据传递给pagedList
                                loadInitialCallback.onResult(response.getMovieList(), null, 1);
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }
}
