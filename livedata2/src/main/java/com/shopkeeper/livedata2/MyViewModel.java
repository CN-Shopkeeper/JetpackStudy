package com.shopkeeper.livedata2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> progressMTD;

    public MutableLiveData<Integer> getProgressMTD() {
        if (progressMTD==null){
            progressMTD=new MutableLiveData<>();
            progressMTD.setValue(0);
        }
        return progressMTD;
    }

    public void setProgressMTD(MutableLiveData<Integer> progressMTD) {
        this.progressMTD = progressMTD;
    }
}
