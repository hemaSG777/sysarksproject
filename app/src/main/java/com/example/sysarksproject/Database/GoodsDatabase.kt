package com.example.sysarksproject.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sysarksproject.Model.Entity
import com.example.sysarksproject.GoodsInterface.GoodsDao

@Database(entities = [Entity::class], version = 2, exportSchema = true)
abstract class GoodsDatabase : RoomDatabase() {
    abstract fun dao(): GoodsDao
}

