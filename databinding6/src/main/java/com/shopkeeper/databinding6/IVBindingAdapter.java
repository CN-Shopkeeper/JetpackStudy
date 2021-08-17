package com.shopkeeper.databinding6;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class IVBindingAdapter {
    @BindingAdapter("itemImage")
    public static void setImage(ImageView imageView,String url){
        if (!TextUtils.isEmpty(url)){
            Glide.with(imageView)
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }else {
            imageView.setBackgroundColor(Color.GRAY);
        }
    }
}
