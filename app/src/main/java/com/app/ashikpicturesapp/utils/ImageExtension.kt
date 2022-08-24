package com.app.ashikpicturesapp.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.app.ashikpicturesapp.R
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl","context")
fun setImageDrawable(imageView : ImageView,  imageUrl: String, context: Context) {
    Glide.with(context)
        .load(imageUrl)
        .error(R.drawable.ic_launcher_foreground)
        .into(imageView)
}