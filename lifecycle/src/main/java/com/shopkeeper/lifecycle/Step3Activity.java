package com.shopkeeper.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shopkeeper.lifecycle.databinding.ActivityMainThreeBinding;

public class Step3Activity extends AppCompatActivity {

    ActivityMainThreeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main_three);
    }


//    修改地理位置信息的指令
//    adb -s emulator-5554 emu geo fix 121.49612 31.24010

    public void startGps(View view) {
        startService(new Intent(this, MyLocationService.class));
    }

    public void stopGps(View view) {
        stopService(new Intent(this,MyLocationService.class));
    }
}