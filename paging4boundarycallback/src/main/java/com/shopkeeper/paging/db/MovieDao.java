package com.shopkeeper.paging.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.shopkeeper.paging.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insertMovies(List<Movie> movieList);

    @Query("delete from movie")
    void clear();

    @Query("select * from movie")
    DataSource.Factory<Integer, Movie> getMovieList();
}
