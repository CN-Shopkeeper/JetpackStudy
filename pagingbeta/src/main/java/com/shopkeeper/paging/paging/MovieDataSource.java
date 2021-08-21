package com.shopkeeper.paging.paging;

import static com.shopkeeper.paging.volley.GsonRequestUtils.getRequestFeature;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.ListenableFuturePagingSource;
import androidx.paging.PagingState;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.shopkeeper.paging.model.Movie;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class MovieDataSource extends ListenableFuturePagingSource<Integer, Movie> {
    public static final int PER_PAGE_SIZE = 10;
    private final Context context;

    private final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public MovieDataSource(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, Movie> pagingState) {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        Integer anchorPosition = pagingState.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }

        LoadResult.Page<Integer, Movie> anchorPage = pagingState.closestPageToPosition(anchorPosition);
        if (anchorPage == null) {
            return null;
        }

        Integer prevKey = anchorPage.getPrevKey();
        if (prevKey != null) {
            return prevKey + 1;
        }

        Integer nextKey = anchorPage.getNextKey();
        if (nextKey != null) {
            return nextKey - 1;
        }

        return null;
    }

    @NonNull
    @Override
    public ListenableFuture<LoadResult<Integer, Movie>> loadFuture(@NonNull LoadParams<Integer> loadParams) {
        Integer nextPageNumber = loadParams.getKey();
        if (nextPageNumber == null) {
            nextPageNumber = 0;//从第0页开始加载
        }
        Integer finalNextPageNumber = nextPageNumber;
        ListenableFuture<LoadResult<Integer, Movie>> pageFuture = Futures
                .transform(executorService.submit(new Callable<List<Movie>>() {
                    @Override
                    public List<Movie> call() throws Exception {
                        //这里处理耗时操作,比如网络请求数据,数据库数据加载
                        //这里用Roterfit请求网络数据,使用页数和构造函数传过来的参数作为请求参数来请求数据
                        return getRequestFeature(finalNextPageNumber, context).get().getMovieList();//得到数据后返回
                    }
                }), new Function<List<Movie>, LoadResult.Page<Integer, Movie>>() {
                    @NotNull
                    @Override
                    public LoadResult.Page<Integer, Movie> apply(@Nullable List<Movie> input) {
//				这里传入的三个参数中,刚才请求的数据,第二个参数为请求的上一页的页数,当为null时不再加载上一页,第三个参数则是下一页,后两个参数不介绍,自行了解
                        return new LoadResult.Page<>(input, finalNextPageNumber == 0 ? null : finalNextPageNumber - 1, input.isEmpty() ? null : finalNextPageNumber + 1);
                    }
                }, executorService);

        ListenableFuture<LoadResult<Integer, Movie>> partialLoadResultFuture = Futures.catching(
                pageFuture, Exception.class,
                LoadResult.Error::new, executorService);

        return Futures.catching(partialLoadResultFuture,
                Exception.class, LoadResult.Error::new, executorService);
    }
}
