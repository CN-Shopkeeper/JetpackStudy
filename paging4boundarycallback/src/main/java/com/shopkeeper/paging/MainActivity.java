package com.shopkeeper.paging;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shopkeeper.paging.databinding.ActivityMainBinding;
import com.shopkeeper.paging.paging.MoviePagedListAdapter;
import com.shopkeeper.paging.paging.MovieViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new MoviePagedListAdapter());
        binding.setLifecycleOwner(this);
        MovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MovieViewModel.class);
        binding.setViewModel(viewModel);
        binding.swipe.setOnRefreshListener(() -> {
            viewModel.refresh();
            binding.swipe.setRefreshing(false);
        });
    }
}