package com.example.sysarksproject.Model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@androidx.room.Entity(tableName = "room_table")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    @ColumnInfo(name = "title")
    val Title: String?,
    @ColumnInfo(name = "desc")
    val Description: String?,
    @ColumnInfo(name = "quantity")
    val Quantity: String
)