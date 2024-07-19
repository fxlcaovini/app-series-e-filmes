package com.example.appfilmes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities =[Serie::class])
abstract class DbSerie :RoomDatabase(){
    abstract fun serieDao(): ISerieDao
}