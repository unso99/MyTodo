package com.mytodo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    var todo: String,

    @ColumnInfo
    var time: String? = null,

    @ColumnInfo
    var isDone: Boolean = false
) : Serializable
