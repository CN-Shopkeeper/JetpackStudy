package com.shopkeeper.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> currentSecondLd;


    public MutableLiveData<Integer> getCurrentSecondLd() {
        if (currentSecondLd==null){
            currentSecondLd=new MutableLiveData<>();
            currentSecondLd.setValue(0);
        }
        return currentSecondLd;
    }

    public void setCurrentSecondLd(MutableLiveData<Integer> currentSecondLd) {
        this.currentSecondLd = currentSecondLd;
    }
}
