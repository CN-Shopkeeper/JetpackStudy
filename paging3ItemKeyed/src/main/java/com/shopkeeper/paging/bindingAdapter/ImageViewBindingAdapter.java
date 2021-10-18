package com.shopkeeper.paging.bindingAdapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageViewBindingAdapter {

    @BindingAdapter("loadImage")
    public static void bindingImageView(ImageView imageView, String url) {
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }
}
