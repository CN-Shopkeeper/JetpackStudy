package com.shopkeeper.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CWorker extends Worker {
    public CWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.i("shopkeeperTag", "doWork: " + this.getClass().getSimpleName());
        return Result.success();
    }
}