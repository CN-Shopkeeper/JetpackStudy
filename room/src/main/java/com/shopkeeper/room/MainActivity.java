package com.shopkeeper.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shopkeeper.room.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private StudentAdapter adapter;
    private StudentDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        List<Student> students=new ArrayList<>();
        adapter = new StudentAdapter(students);
        binding.recycleView.setAdapter(adapter);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        MyDataBase dataBase=MyDataBase.getInstance(this);
        dao = dataBase.getStudentDao();
    }

    public void insert(View view) {
        Student student1=new Student("jack",18);
        Student student2=new Student("rose",17);
        new InsertStudentTask(dao).execute(student1,student2);
    }

    public void delete(View view) {
        Student student=new Student(2);
        new DeleteStudentTask(dao).execute(student);
    }

    public void update(View view) {
        Student student1=new Student(3,"json",21);
        new UpdateStudentTask(dao).execute(student1);
    }

    public void query(View view) {
        new GetAllStudentTask(dao).execute();
    }

    class InsertStudentTask extends AsyncTask<Student,Void,Void>{

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

    class GetAllStudentTask extends AsyncTask<Void,Void,Void>{

        private StudentDao dao;
        private List<Student> students;

        public GetAllStudentTask(StudentDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            students = dao.getAllStudent();
            Log.i("shopkeeperTag", "doInBackground: size: "+ students.size());

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.setStudents(students);
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

}