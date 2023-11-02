package com.mytodo

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL

@BindingAdapter
fun RecyclerView.setDivider(context: Context){
    val decoration = DividerItemDecoration(context,VERTICAL)
    addItemDecoration(decoration)
}