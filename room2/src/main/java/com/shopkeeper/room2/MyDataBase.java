package com.shopkeeper.room2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities={Student.class}, version = 3, exportSchema = false)
public abstract class MyDataBase  extends RoomDatabase {
    private static MyDataBase mInstance;
    private static final String dataBaseName="my_db.db";

    public static synchronized MyDataBase getInstance(Context context){
        if (mInstance==null){
            mInstance= Room.databaseBuilder(context,
                    MyDataBase.class,
                    dataBaseName)
                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                    .build();
        }
        return mInstance;
    }

    static final Migration MIGRATION_1_2=new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 2");
        }
    };

    static final Migration MIGRATION_2_3=new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN bar INTEGER NOT NULL DEFAULT 3");
        }
    };

    public abstract StudentDao getStudentDao();
}
