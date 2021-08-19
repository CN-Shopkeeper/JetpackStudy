package com.shopkeeper.workmanager;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

//    public void addWork(View view){
//        OneTimeWorkRequest workA=new OneTimeWorkRequest
//                .Builder(AWorker.class)
//                .build();
//        OneTimeWorkRequest workB=new OneTimeWorkRequest
//                .Builder(BWorker.class)
//                .build();
//        WorkManager.getInstance(this)
//                .beginWith(workA)
//                .then(workB)
//                .enqueue();
//    }

    public void addWork(View view) {
        OneTimeWorkRequest workA = new OneTimeWorkRequest
                .Builder(AWorker.class)
                .build();
        OneTimeWorkRequest workB = new OneTimeWorkRequest
                .Builder(BWorker.class)
                .build();
        OneTimeWorkRequest workC = new OneTimeWorkRequest
                .Builder(CWorker.class)
                .build();
        OneTimeWorkRequest workD = new OneTimeWorkRequest
                .Builder(DWorker.class)
                .build();
        OneTimeWorkRequest workE = new OneTimeWorkRequest
                .Builder(EWorker.class)
                .build();
        WorkContinuation continuation1 = WorkManager.getInstance(this)
                .beginWith(workA)
                .then(workB);
        WorkContinuation continuation2 = WorkManager.getInstance(this)
                .beginWith(workC)
                .then(workD);
        List<WorkContinuation> taskList = new ArrayList<>();
        taskList.add(continuation1);
        taskList.add(continuation2);
        WorkContinuation.combine(taskList)
                .then(workE)
                .enqueue();
    }
}
