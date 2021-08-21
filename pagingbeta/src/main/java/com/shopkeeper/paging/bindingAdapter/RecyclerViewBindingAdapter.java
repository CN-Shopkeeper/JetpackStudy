package com.shopkeeper.paging.bindingAdapter;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.RecyclerView;

import com.shopkeeper.paging.MainActivity;
import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.paging.MoviePagedListAdapter;

public class RecyclerViewBindingAdapter {

    @BindingAdapter(value = {"updateMovies", "activity"}, requireAll = true)
    public static void BindingRecyclerView(RecyclerView recyclerView, PagingData<Movie> list, MainActivity activity) {
        ((MoviePagedListAdapter) recyclerView.getAdapter()).submitData(activity.getLifecycle(), list);
        Log.i("shopkeeperTag", "BindingRecyclerView: ");
    }
}
