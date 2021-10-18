package com.shopkeeper.pagingwithroom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shopkeeper.pagingwithroom.databinding.ActivityMainBinding;
import com.shopkeeper.pagingwithroom.db.MyDatabase;
import com.shopkeeper.pagingwithroom.model.Movie;
import com.shopkeeper.pagingwithroom.paging.MoviePagedListAdapter;
import com.shopkeeper.pagingwithroom.paging.MovieViewModel;
import com.shopkeeper.pagingwithroom.volley.GsonRequestUtils;
import com.shopkeeper.pagingwithroom.volley.VolleySingleton;

import java.util.List;


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
        Log.i("shopkeeperTag", "onCreate: ");
        VolleySingleton.getInstance(this)
                .addToRequestQueue(GsonRequestUtils.getAllMovies(response -> {
                    insertMovies(response.getMovieList());
                    Log.i("shopkeeperTag", "response.getMovieList: " + response.getMovieList().size());
                }, error -> Log.e("shopkeeperTag", "onErrorResponse: ", error)));
    }

    //    把网络数据保存到数据库
    private void insertMovies(List<Movie> movieList) {
        Log.i("shopkeeperTag", "insertMovies: ");
        AsyncTask.execute(() -> {
            MyDatabase.getInstance(this)
                    .getMovieDao()
                    .insertMovies(movieList);
        });
    }

}