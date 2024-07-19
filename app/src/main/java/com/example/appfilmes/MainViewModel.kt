package com.example.appfilmes

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application): ViewModel() {
    private val useCase = SerieUseCase(application)
    var serie = MutableLiveData<List<Serie>>()
    fun load(){
        Thread(Runnable{
            serie.postValue(useCase.get())

        }).start()
    }
}