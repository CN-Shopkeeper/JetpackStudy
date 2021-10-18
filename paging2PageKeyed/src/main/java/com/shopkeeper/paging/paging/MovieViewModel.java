package com.shopkeeper.paging.paging;

import static com.shopkeeper.paging.paging.MovieDataSource.PER_PAGE_SIZE;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.shopkeeper.paging.model.Movie;

public class MovieViewModel extends AndroidViewModel {

    private final LiveData<PagedList<Movie>> moviePagedListLD;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        PagedList.Config config = new PagedList.Config.Builder()
//                设置控件占位
                .setEnablePlaceholders(false)
//                设置一页大小
                .setPageSize(PER_PAGE_SIZE)
//                当距离底部还有多少条数据时再次加载
                .setPrefetchDistance(2)
//                首次加载数量
                .setInitialLoadSizeHint(PER_PAGE_SIZE * 2)
//                默认 Int.MAX_VALUE
//                .setMaxSize()
                .build();
        moviePagedListLD = new LivePagedListBuilder<>(
                new MovieDataSourceFactory(application),
                config).build();
    }

    public LiveData<PagedList<Movie>> getMoviePagedListLD() {
        return moviePagedListLD;
    }
}
