package com.mytodo.repository

import com.mytodo.model.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun loadTodoList(): Flow<List<TodoEntity>>

    suspend fun insert(item: TodoEntity)

    suspend fun modify(item: TodoEntity)

    suspend fun delete(item: TodoEntity)
}