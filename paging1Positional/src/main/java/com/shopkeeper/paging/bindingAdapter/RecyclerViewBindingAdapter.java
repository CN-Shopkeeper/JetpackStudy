package com.shopkeeper.paging.bindingAdapter;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.paging.MoviePagedListAdapter;

public class RecyclerViewBindingAdapter {

    @BindingAdapter("updateMovies")
    public static void BindingRecyclerView(RecyclerView recyclerView, PagedList<Movie> list) {
        ((MoviePagedListAdapter) recyclerView.getAdapter()).submitList(list);
        Log.i("shopkeeperTag", "BindingRecyclerView: ");
    }
}
