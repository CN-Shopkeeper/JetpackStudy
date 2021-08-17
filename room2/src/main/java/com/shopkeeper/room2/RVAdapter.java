package com.shopkeeper.room2;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter {

    @BindingAdapter("studentBinder")
    public static void studentsBindAdapter(RecyclerView recyclerView, List<Student> students){
        StudentAdapter adapter = (StudentAdapter) recyclerView.getAdapter();
        assert adapter != null;
        adapter.setStudents(students);
    }
}
