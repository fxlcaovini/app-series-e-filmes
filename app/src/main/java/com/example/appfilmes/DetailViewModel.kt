package com.example.appfilmes

import android.app.Application
import androidx.lifecycle.ViewModel

class DetailViewModel(application: Application) : ViewModel() {
    private val useCase = SerieUseCase(application)

    fun favorite(serie: Serie){
        useCase.favorite(serie)
    }
    fun unfavorite(serie: Serie){
        useCase.unfavorite(serie)
    }
}