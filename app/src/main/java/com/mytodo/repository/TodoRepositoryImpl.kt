package com.mytodo.repository

import com.mytodo.data.dao.TodoDao
import com.mytodo.model.TodoEntity
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val todoDao: TodoDao) : TodoRepository {
    override fun loadTodoList() = todoDao.selectAll()

    override suspend fun insert(item: TodoEntity) {
        todoDao.insert(item)
    }

    override suspend fun modify(item: TodoEntity) {
        todoDao.insert(item)
    }

    override suspend fun delete(item: TodoEntity) {
        todoDao.delete(item)
    }
}