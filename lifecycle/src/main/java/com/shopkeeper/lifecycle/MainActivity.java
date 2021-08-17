package com.shopkeeper.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.SystemClock;

import com.shopkeeper.lifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        getLifecycle().addObserver(binding.chronometer);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        binding.chronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
//        binding.chronometer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        elapsedTime = SystemClock.elapsedRealtime()-binding.chronometer.getBase();
//        binding.chronometer.stop();
    }
}