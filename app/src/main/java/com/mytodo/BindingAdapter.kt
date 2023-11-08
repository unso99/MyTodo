package com.mytodo

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@BindingAdapter("setMonth")
fun TextView.setMonth(currentDate : LocalDate){
    val month = currentDate.month.getDisplayName(TextStyle.FULL, Locale.getDefault())

    text = month
}

@BindingAdapter("setDate")
fun TextView.setDate(currentDate : LocalDate){
    val dayOfWeek = currentDate.dayOfWeek.getDisplayName(TextStyle.FULL,Locale.getDefault())
    val day = currentDate.dayOfMonth

    text = "${dayOfWeek}, ${day}일"
}