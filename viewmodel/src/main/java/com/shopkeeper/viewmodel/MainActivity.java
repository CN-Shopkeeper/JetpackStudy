package com.shopkeeper.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shopkeeper.viewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        binding.textview.setText(String.valueOf(viewModel.number));
    }

    public void plusNumber(View view) {
        viewModel.number++;
        binding.textview.setText(String.valueOf(viewModel.number));
        Log.d("shopkeeperTag", "plusNumber: "+viewModel.number);
    }
}