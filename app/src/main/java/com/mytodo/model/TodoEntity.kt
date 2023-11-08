package com.mytodo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Todo")
data class TodoEntity(
    @PrimaryKey(true)
    val id : Int = 0,

    @ColumnInfo
    val todo : String,

    @ColumnInfo
    val time : String? = null,

    @ColumnInfo
    val isDone : Boolean = false


) : Serializable
