package com.shopkeeper.pagingwithroom.paging;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shopkeeper.pagingwithroom.R;
import com.shopkeeper.pagingwithroom.databinding.ItemBinding;
import com.shopkeeper.pagingwithroom.model.Movie;


public class MoviePagedListAdapter extends PagedListAdapter<Movie, MoviePagedListAdapter.MovieViewHolder> {

    private static final DiffUtil.ItemCallback<Movie> diffCallback = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };

    public MoviePagedListAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.binding.setMovie(getItem(position));
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public MovieViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
