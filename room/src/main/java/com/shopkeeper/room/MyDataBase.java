package com.shopkeeper.room;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student.class, version = 1, exportSchema = false)
public abstract class MyDataBase  extends RoomDatabase {
    private static MyDataBase mInstance;
    private static final String dataBaseName="my_db.db";

    public static synchronized MyDataBase getInstance(Context context){
        if (mInstance==null){
            mInstance= Room.databaseBuilder(context,
                    MyDataBase.class,
                    dataBaseName).build();
        }
        return mInstance;
    }

    public abstract StudentDao getStudentDao();
}
