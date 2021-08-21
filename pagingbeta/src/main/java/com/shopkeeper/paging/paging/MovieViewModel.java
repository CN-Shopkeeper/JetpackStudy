package com.shopkeeper.paging.paging;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import com.shopkeeper.paging.model.Movie;

import kotlinx.coroutines.CoroutineScope;

public class MovieViewModel extends AndroidViewModel {

    private final LiveData<PagingData<Movie>> moviePagedListLD;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        PagingConfig pagingConfig = new PagingConfig(10, 10, false, 10);//初始化配置,可以定义最大加载的数据量
        Pager<Integer, Movie> pager = new Pager<Integer, Movie>(pagingConfig, () -> new MovieDataSource(application));
        moviePagedListLD = PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);

    }

    public LiveData<PagingData<Movie>> getMoviePagedListLD() {
        return moviePagedListLD;
    }
}
