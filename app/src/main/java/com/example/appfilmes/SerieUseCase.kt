package com.example.appfilmes

import android.app.Application

class SerieUseCase(application: Application) {
    private val apiRepository = SerieApIRepository
    private val dbRepository = SerieSqlLiteRepository(application)

    fun get(): List<Serie> {
        val seriesFromDb = dbRepository.get() ?: listOf()
        val seriesFromApi = apiRepository.get() ?: listOf()


        val allSeries = (seriesFromDb + seriesFromApi).distinctBy { it.id }


        return allSeries.sortedByDescending { it.favorite }
    }

    fun favorite(serie: Serie) {
        serie.favorite = true
        dbRepository.add(serie)
    }

    fun unfavorite(serie: Serie) {
        serie.favorite = false
        dbRepository.delete(serie)
    }
}
