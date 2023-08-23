package com.example.sysarksproject.GoodsInterface

import androidx.room.*

@Dao
interface GoodsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(entity: com.example.sysarksproject.Model.Entity)

    @Update
    fun updateNote(entity: com.example.sysarksproject.Model.Entity)

    @Query("SELECT * FROM room_table ORDER BY Id DESC")
    fun getAllData(): MutableList<com.example.sysarksproject.Model.Entity>
}