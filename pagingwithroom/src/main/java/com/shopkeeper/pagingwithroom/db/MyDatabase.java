package com.shopkeeper.pagingwithroom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.shopkeeper.pagingwithroom.model.Movie;

@Database(entities = Movie.class, version = 1, exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db.db";

    private static MyDatabase mInstance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME).build();
        }
        return mInstance;
    }

    public abstract MovieDao getMovieDao();
}
