package com.mytodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mytodo.data.dao.TodoDao
import com.mytodo.model.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun todoDao() : TodoDao
}