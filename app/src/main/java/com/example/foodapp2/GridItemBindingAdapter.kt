package com.example.foodapp2

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class GridItemBindingAdapter {
    companion object {
        @BindingAdapter("android:src")
        @JvmStatic // Required for static methods in Kotlin
        fun setImageResource(imageView: ImageView, resourceId: Int) {
            imageView.setImageResource(resourceId)
        }
    }
}