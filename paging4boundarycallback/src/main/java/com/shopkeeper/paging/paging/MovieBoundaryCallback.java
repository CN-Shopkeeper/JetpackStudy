package com.shopkeeper.paging.paging;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

import com.shopkeeper.paging.db.MyDatabase;
import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.volley.GsonRequestUtils;
import com.shopkeeper.paging.volley.VolleySingleton;

import java.util.List;

public class MovieBoundaryCallback extends PagedList.BoundaryCallback<Movie> {

    public static final int PER_PAGE_SIZE = 10;
    private final Context context;
    private int currentPage = 0;

    public MovieBoundaryCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        currentPage = 0;
//        加载第一页数据
        getTopData();
    }

    private void getTopData() {
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(currentPage,
                        response -> {
                            if (response != null) {
//                                这里有所不同
                                insertMovies(response.getMovieList());
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }

    //    把网络数据保存到数据库
    private void insertMovies(List<Movie> movieList) {
        AsyncTask.execute(() -> {
            MyDatabase.getInstance(context)
                    .getMovieDao()
                    .insertMovies(movieList);
        });
    }


    @Override
    public void onItemAtEndLoaded(@NonNull Movie itemAtEnd) {
        super.onItemAtEndLoaded(itemAtEnd);
//        加载第二页数据
        getTopAfterData(itemAtEnd);
    }

    private void getTopAfterData(Movie movie) {
        currentPage++;
        VolleySingleton.getInstance(context)
                .addToRequestQueue(GsonRequestUtils.getPdsRequest(currentPage,
                        response -> {
                            if (response != null) {
                                insertMovies(response.getMovieList());
                                Log.i("shopkeeperTag", "loadInitial: " + response.toString());
                            }
                        },
                        error -> {
                            Log.i("shopkeeperTag", "loadRange: " + error.toString());
                        }));
    }


}
