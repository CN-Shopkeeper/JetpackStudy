package com.shopkeeper.databinding3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.shopkeeper.databinding3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setNetworkImage("https://img1.baidu.com/it/u=2513494413,3578638799&fm=26&fmt=auto&gp=0.jpg");
        binding.setLocalImage(R.drawable.zerotwo);
    }
}