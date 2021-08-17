package com.shopkeeper.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class EventHandleListener {
    private Context context;

    public EventHandleListener(Context context) {
        this.context = context;
    }

    public void btnOnClick(View view){
        Toast.makeText(context,"like 02",Toast.LENGTH_SHORT).show();
    }
}
