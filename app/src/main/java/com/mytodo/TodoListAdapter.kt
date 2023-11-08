package com.mytodo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mytodo.databinding.ItemTodoBinding
import com.mytodo.model.TodoEntity

class TodoListAdapter : ListAdapter<TodoEntity, TodoViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<TodoEntity>() {
            override fun areItemsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TodoEntity, newItem: TodoEntity): Boolean {
                return oldItem == newItem
            }

        }
    }
}