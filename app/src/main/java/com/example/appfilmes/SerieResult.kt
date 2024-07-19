package com.example.appfilmes

import com.google.gson.annotations.SerializedName

class SerieResult(
 val page : Int,
 val results: List<Serie>,
@SerializedName("total_pages") val totalPages: Int,
@SerializedName("total_results")  val totalResults: Int

)