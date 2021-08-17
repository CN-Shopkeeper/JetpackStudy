package com.shopkeeper.databinding3;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class IVBindingAdapter {
    @BindingAdapter("image")
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

    @BindingAdapter("image")
    public static void setImage(ImageView imageView,int res){
        if (res!=0){
            Glide.with(imageView)
                    .load(res)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }else {
            imageView.setBackgroundColor(Color.GRAY);
        }
    }

    @BindingAdapter(value = {"image","default_image"},requireAll = false)
    public static void setImage(ImageView imageView,String url,int res){
        if (!TextUtils.isEmpty(url)){
            Glide.with(imageView)
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }else {
            Glide.with(imageView)
                    .load(res)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);        }
    }
}
