package com.shopkeeper.room2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student... students);

    @Delete
    void deleteStudent(Student... students);

    @Query("DELETE from student")
    void deleteAllStudent();

    @Update
    void updateStudent(Student... students);

    @Query("select * from student")
    LiveData<List<Student>> getAllStudent();

    @Query("select * from student")
    List<Student> getAllStudentTest();

    @Query("select * from student where id=:id")
    LiveData<List<Student>> getStudentById(int id);
}
