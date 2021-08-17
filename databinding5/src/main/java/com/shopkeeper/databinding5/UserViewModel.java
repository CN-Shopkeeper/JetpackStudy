package com.shopkeeper.databinding5;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class UserViewModel {
    private ObservableField<User> userObservableField;

    public UserViewModel(){
        User user=new User("zero two");
        userObservableField=new ObservableField<>();
        userObservableField.set(user);
    }

    public String getUserName(){
        return userObservableField.get().userName;
    }

    public void setUserName(String userName){
        Log.d("shopkeeperTag", "setUserName: "+userName);
        userObservableField.get().setUserName(userName);
    }

    public void to02(){
        Log.i("shopkeeperTag", "to02: "+userObservableField.get().userName);
        userObservableField.get().setUserName("02");
    }
}
