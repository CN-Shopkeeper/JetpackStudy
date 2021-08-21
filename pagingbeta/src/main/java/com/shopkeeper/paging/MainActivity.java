package com.shopkeeper.paging;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shopkeeper.paging.databinding.ActivityMainBinding;
import com.shopkeeper.paging.model.Movie;
import com.shopkeeper.paging.paging.MoviePagedListAdapter;
import com.shopkeeper.paging.paging.MovieViewModel;

// 参考文档：https://www.cnblogs.com/eswd/p/13886733.html
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MoviePagedListAdapter adapter = new MoviePagedListAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.setLifecycleOwner(this);
        binding.setActivity(this);
        MovieViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MovieViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMoviePagedListLD().observe(this, new Observer<PagingData<Movie>>() {
            @Override
            public void onChanged(PagingData<Movie> moviePagingData) {
                adapter.submitData(getLifecycle(), moviePagingData);
                Log.i("shopkeeperTag", "onChanged: " + moviePagingData);
            }
        });

    }
}