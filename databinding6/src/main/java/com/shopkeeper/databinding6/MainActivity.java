package com.shopkeeper.databinding6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.shopkeeper.databinding6.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        List<Idol> idols=new ArrayList<>();
        for (int i=0;i<10;i++){
            idols.add(new Idol("cnName: "+i,"enName: "+i,"https://img1.baidu.com/it/u=1458183626,1701831989&fm=26&fmt=auto&gp=0.jpg"));
        }
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(idols);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}