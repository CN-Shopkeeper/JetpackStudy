package com.shopkeeper.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.shopkeeper.livedata.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        binding.textview.setText(String.valueOf(viewModel.getCurrentSecondLd().getValue()));
        viewModel.getCurrentSecondLd().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textview.setText(String.valueOf(integer));
            }
        });
        startTimer();
    }

    private void startTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                viewModel.getCurrentSecondLd().postValue(viewModel.getCurrentSecondLd().getValue()+1);
            }
        },1000,1000);
    }
}