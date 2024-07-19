package com.example.appfilmes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ItmdbClient {
    @GET("3/tv/popular")
    fun getTvPopular(@Query("api_key") apiKey: String): Call<SerieResult>

}