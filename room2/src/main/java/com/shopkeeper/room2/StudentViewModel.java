package com.shopkeeper.room2;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository repository;
    private LiveData<List<Student>> studentsLD;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        this.repository=new StudentRepository(application);
        studentsLD=repository.getAllStudentsLive();
    }

    public void insert(){
        Student s1=new Student("jack",18,3);
        Student s2=new Student("rose",17);
        insertStudents(s1,s2);
    }

    public void update(){
        Student s1=new Student(3,"jason",20);
        updateStudents(s1);
    }

    public void clear(){
        deleteAllStudents();
    }

    public void delete(){
        Student s1=new Student(2,"rose",17);
        deleteStudents(s1);
    }


    private void insertStudents(Student... students){
        repository.insertStudents(students);
    }

    private void updateStudents(Student... students){
        repository.updateStudents(students);
    }

    private void deleteStudents(Student... students){
        repository.deleteStudents(students);
    }

    private void deleteAllStudents(){
        repository.deleteAllStudents();
    }

//  错误！！！
//    public LiveData<List<Student>> getAllStudentLive(){
//        return repository.getAllStudentsLive();
//    }
//   正确
    public LiveData<List<Student>> getStudentsLD() {
        return studentsLD;
    }
}
