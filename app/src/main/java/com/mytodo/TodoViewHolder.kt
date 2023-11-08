package com.mytodo

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.mytodo.databinding.ItemTodoBinding
import com.mytodo.model.TodoEntity

class TodoViewHolder(
    private val binding: ItemTodoBinding,
    private val handler: MainActivity.Handler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TodoEntity) {
        binding.item = item
        binding.handler = handler

        binding.todoTextView.paintFlags = if (item.isDone) {
            Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}