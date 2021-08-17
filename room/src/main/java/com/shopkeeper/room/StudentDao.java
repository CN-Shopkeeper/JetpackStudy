package com.shopkeeper.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student ... students);

    @Delete
    void deleteStudent(Student... students);

    @Update
    void updateStudent(Student... students);

    @Query("select * from student")
    List<Student> getAllStudent();

    @Query("select * from student where id=:id")
    List<Student> getStudentById(int id);
}
