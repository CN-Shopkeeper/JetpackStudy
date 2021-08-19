package com.shopkeeper.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {
    public static final String inputDataTag = "input_data";
    public static final String outputDataTag = "output_data";

    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String stringData = getInputData().getString(inputDataTag);
        Log.i("shopkeeperTag", "doWork: get input data: " + stringData);

        Data outputData = new Data.Builder()
                .putString(outputDataTag, "执行成功")
                .build();
        return Result.success(outputData);
    }
}
