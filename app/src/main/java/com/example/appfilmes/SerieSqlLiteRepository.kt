package com.example.appfilmes

import android.app.Application
import androidx.room.Room

class SerieSqlLiteRepository(application: Application) {
    companion object{
        var database: DbSerie? = null
    }
    init{
        database = Room.databaseBuilder(application, DbSerie::class.java, "serie_db")
            .allowMainThreadQueries()
            .build()
    }
    fun add(serie: Serie){
        database?.serieDao()?.insert(serie)

    }
    fun delete(serie: Serie){
        database?.serieDao()?.insert(serie)
    }
    fun get(): List<Serie>{
       return database?.serieDao()?.get()!!
    }
}