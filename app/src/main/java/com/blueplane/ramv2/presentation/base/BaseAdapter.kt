package com.blueplane.ramv2.presentation.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter <T : Any, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private val items  = mutableListOf<T>()

    fun updateItems(items : List<T>){
        this.items.apply {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }

    private fun getItem(position : Int) = items[position]

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))

    }
    override fun getItemCount(): Int =items.size
}