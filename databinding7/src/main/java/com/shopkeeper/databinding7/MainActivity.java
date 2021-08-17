package com.shopkeeper.databinding7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.shopkeeper.databinding7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyViewModel viewModel=new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        livedata.addObserver(getLifecycleowner,new Observable(){
            onChange(){

            }
        })
    }
}