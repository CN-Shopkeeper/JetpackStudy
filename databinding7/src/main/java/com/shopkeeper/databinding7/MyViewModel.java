package com.shopkeeper.databinding7;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> scoreMTD;
    private int lastScore;

    public MutableLiveData<Integer> getScoreMTD() {
        if (scoreMTD==null){
            scoreMTD=new MutableLiveData<>();
            scoreMTD.setValue(0);
        }
        return scoreMTD;
    }

    public void setScoreMTD(MutableLiveData<Integer> scoreMTD) {
        this.scoreMTD = scoreMTD;
    }

    public void addScore(){
        saveLastScore();
        scoreMTD.setValue(scoreMTD.getValue()+1);
    }

    public void undo(){
        scoreMTD.setValue(lastScore);
    }

    public void reset(){
        scoreMTD.setValue(0);
    }

    private void saveLastScore(){
        this.lastScore=this.scoreMTD.getValue();
    }
}
