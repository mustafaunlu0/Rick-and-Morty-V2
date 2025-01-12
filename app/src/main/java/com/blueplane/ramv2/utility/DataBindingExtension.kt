package com.blueplane.ramv2.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> ViewGroup.inflateBinding(
    inflateMethod : (LayoutInflater, ViewGroup?, Boolean) -> T) : T {
    val layoutInflater = LayoutInflater.from(context)
    return inflateMethod(layoutInflater, this, false)
}