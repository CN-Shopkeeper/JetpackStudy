package com.shopkeeper.room2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shopkeeper.room2.databinding.ItemBinding;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item,parent,false);
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.binding.setStudent(students.get(position));
        Log.i("shopkeeperTAG", "onBindViewHolder: "+students.get(position));
    }

    @Override
    public int getItemCount() {
        return students==null?0:students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder{
        ItemBinding binding;
        public StudentViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }
}
