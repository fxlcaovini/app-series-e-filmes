package com.example.appfilmes

import androidx.room.Dao
import androidx.room.Delete import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ISerieDao {
    @Query("SELECT * FROM serie")
    fun get(): List<Serie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg serie: Serie)

    @Delete
    fun delete(serie: Serie)
}