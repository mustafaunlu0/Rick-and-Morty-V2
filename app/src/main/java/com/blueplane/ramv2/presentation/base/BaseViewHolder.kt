package com.blueplane.ramv2.presentation.base

import androidx.recyclerview.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder <T : Any>(view : View) : RecyclerView.ViewHolder(view){
    abstract fun bind(data : T)
}