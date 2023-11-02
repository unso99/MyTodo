package com.mytodo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "TodoEntity")
data class TodoEntity(
    @PrimaryKey(true)
    val id : Int = 0,

    @ColumnInfo
    val todo : String,

    @ColumnInfo
    val time : String,

    @ColumnInfo
    val isDone : Boolean


) : Serializable
