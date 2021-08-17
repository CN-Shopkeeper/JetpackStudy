package com.shopkeeper.lifecycle;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationObserver implements LifecycleObserver {
    private Context context;
    private MyLocationListener listener;
    private LocationManager locationManager;
    private static String TAG="shopkeepertag";

    public MyLocationObserver(Context context) {
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startGetLocation() {
        Log.d(TAG, "startGetLocation: ");
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        listener = new MyLocationListener();
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1, listener);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopGetLocation(){
        Log.d(TAG, "stopGetLocation: ");
        locationManager.removeUpdates(listener);
    }

    static class MyLocationListener implements LocationListener{

        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.d(TAG, "onLocationChanged: "+location.toString());
        }
    }
}