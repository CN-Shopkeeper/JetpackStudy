package com.shopkeeper.lifecycle;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

public class MyLocationService extends LifecycleService {
    public MyLocationService() {
        Log.d("sk", "MyLocationService: ");
        MyLocationObserver observer=new MyLocationObserver(this);
        getLifecycle().addObserver(observer);
    }
}
