package com.shopkeeper.databinding4;

import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserViewModel extends BaseObservable {
    private User user;

    public UserViewModel() {
        user=new User("zero two");
    }

    @Bindable
    public String getUserName(){
        return user.userName;
    }

    public void setUserName(String name){
        if (!TextUtils.isEmpty(name)&&!name.equals(user.userName)){
            user.userName=name;
            Log.d("shopkeeperTag", "setUserName: "+name);
//            BR是用Bindable注解标记的量，且必须是getXXX
            notifyPropertyChanged(BR.userName);
        }
    }


    public void to02(){
        user.userName="02";
        Log.i("shopkeeperTag", "to02: "+user.userName);
        notifyPropertyChanged(BR.userName);
    }

}
