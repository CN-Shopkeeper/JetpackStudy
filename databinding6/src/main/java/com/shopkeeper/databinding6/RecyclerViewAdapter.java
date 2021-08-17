package com.shopkeeper.databinding6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shopkeeper.databinding6.databinding.ItemBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Idol> idols;

    public RecyclerViewAdapter(List<Idol> idols) {
        this.idols = idols;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
            ,R.layout.item,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Idol idol=idols.get(position);
        holder.binding.setIdol(idol);
    }

    @Override
    public int getItemCount() {
        return idols.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private ItemBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public MyViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
