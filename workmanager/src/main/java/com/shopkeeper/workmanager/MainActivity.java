package com.shopkeeper.workmanager;

import static com.shopkeeper.workmanager.MyWork.inputDataTag;
import static com.shopkeeper.workmanager.MyWork.outputDataTag;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addWork(View view) {
//        设置触发条件
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
//                .setRequiresBatteryNotLow() //电量充足
//                .setRequiresCharging() //充电时
//                .setRequiresDeviceIdle() //设备空闲时
//                .setRequiresStorageNotLow() //内存充足
//  NOT_REQUIRED, A network is not required for this work.
//  CONNECTED, Any working network connection is required for this work.
//  UNMETERED, An unmetered network connection is required for this work.
//  NOT_ROAMING, A non-roaming network connection is required for this work.
                .build();


        Data inputData = new Data.Builder()
                .putString(inputDataTag, "sk")
                .build();

//        配置任务
//        一次性执行的任务
        OneTimeWorkRequest request1 = new OneTimeWorkRequest.Builder(MyWork.class)
//                设置触发条件
                .setConstraints(constraints)
//                设置延迟执行
                .setInitialDelay(5, TimeUnit.SECONDS)
//                退避策略，当worker返回retry时自动执行推迟策略
                .setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofSeconds(2))
//                设置Tag标签
                .addTag("workRequest1")
                .setInputData(inputData)
                .build();

//        周期任务
//        周期不能小于15分钟
        PeriodicWorkRequest request2 = new PeriodicWorkRequest.Builder(MyWork.class, Duration.ofMinutes(15)).build();
//        任务提交给WorkManager
        WorkManager manager = WorkManager.getInstance(this);
        manager.enqueue(request1);

//        观察任务状态
        manager.getWorkInfoByIdLiveData(request1.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Log.i("shopkeeperTag", "WorkInfo onChanged: state = " + workInfo.getState() + ", data = " + workInfo.getOutputData().getString(outputDataTag));
            }
        });

//        取消任务
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                manager.cancelWorkById(request1.getId());
//            }
//        },2000);
    }
}