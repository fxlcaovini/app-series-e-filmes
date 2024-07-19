package com.example.appfilmes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SeriesViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(application) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(application) as T
            else -> throw IllegalArgumentException("Classe Invalida")
        }
    }
}
