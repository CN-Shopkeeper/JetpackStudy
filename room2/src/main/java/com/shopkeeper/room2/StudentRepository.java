package com.shopkeeper.room2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepository {

    private StudentDao dao;

    public StudentRepository(Context context){
        this.dao=MyDataBase.getInstance(context).getStudentDao();
    }

    public void insertStudents(Student... students){
        new InsertStudentTask(dao).execute(students);
    }

    public void updateStudents(Student... students){
        new UpdateStudentTask(dao).execute(students);
    }

    public  void deleteStudents(Student... students){
        new DeleteStudentTask(dao).execute(students);
    }

    public  void deleteAllStudents(){
        new DeleteAllStudentTask(dao).execute();
    }

    public LiveData<List<Student>> getAllStudentsLive(){
        return dao.getAllStudent();
    }


    class InsertStudentTask extends AsyncTask<Student,Void,Void> {

        private StudentDao dao;

        public InsertStudentTask(StudentDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            dao.insertStudent(students);
            return null;
        }
    }

    class UpdateStudentTask extends AsyncTask<Student,Void,Void>{

        private StudentDao dao;

        public UpdateStudentTask(StudentDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            dao.updateStudent(students);
            return null;
        }
    }

    class DeleteStudentTask extends AsyncTask<Student,Void,Void>{

        private StudentDao dao;

        public DeleteStudentTask(StudentDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            dao.deleteStudent(students);
            return null;
        }
    }

    class DeleteAllStudentTask extends AsyncTask<Void,Void,Void>{

        private StudentDao dao;

        public DeleteAllStudentTask(StudentDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllStudent();
            return null;
        }
    }
}
