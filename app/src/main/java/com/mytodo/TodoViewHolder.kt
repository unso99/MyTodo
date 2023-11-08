package com.mytodo

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.mytodo.databinding.ItemTodoBinding
import com.mytodo.model.TodoEntity

class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TodoEntity) {
        binding.item = item

        binding.todoTextView.paintFlags = if (item.isDone) {
            binding.todoTextView.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else 0
    }
}