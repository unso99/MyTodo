package com.mytodo.data.dao

import androidx.room.*
import com.mytodo.model.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun selectAll(): Flow<List<TodoEntity>>

    @Delete
    suspend fun delete(item: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: TodoEntity)
}