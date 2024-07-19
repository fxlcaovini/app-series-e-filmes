package com.example.appfilmes

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SerieApIRepository {
    private val tmdbClient:ItmdbClient
    private val apiKey = "3dc9a09a261ac0becc7f32de8e763ded"
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
        tmdbClient = retrofit.create(ItmdbClient::class.java)
    }
    fun get(): List<Serie>?
    {
        try {
            val call = tmdbClient.getTvPopular(apiKey)
            return call.execute().body()?.results
        }catch (e: Exception)
        {
            Log.e("SerieApiRepository", e.message.toString())
            return null
        }
    }
}