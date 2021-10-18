package com.shopkeeper.pagingwithroom.paging;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.shopkeeper.pagingwithroom.db.MovieDao;
import com.shopkeeper.pagingwithroom.db.MyDatabase;
import com.shopkeeper.pagingwithroom.model.Movie;

public class MovieViewModel extends AndroidViewModel {

    private final LiveData<PagedList<Movie>> moviePagedListLD;
    private final MovieDao movieDao;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieDao = MyDatabase.getInstance(application)
                .getMovieDao();
        moviePagedListLD = new LivePagedListBuilder<>(
                movieDao.getMovieList(),
                50)
                .build();
    }

    public void refresh() {
        AsyncTask.execute(movieDao::clear);
    }

    public LiveData<PagedList<Movie>> getMoviePagedListLD() {
        return moviePagedListLD;
    }
}
