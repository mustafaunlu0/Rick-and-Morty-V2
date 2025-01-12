package com.blueplane.ramv2.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.blueplane.ramv2.R
import com.bumptech.glide.Glide

@BindingAdapter("imageUri")
fun loadImage(view: ImageView, imageUri: String) {
    Glide.with(view.context)
        .load(imageUri)
        .into(view)

}