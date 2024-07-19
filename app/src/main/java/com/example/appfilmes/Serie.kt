package com.example.appfilmes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "serie")

data class Serie(
    @PrimaryKey
    val id:Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    @ColumnInfo("backdrop_path")@SerializedName("backdrop_path") val backdropPath: String,
    @ColumnInfo("poster_path")@SerializedName("poster_path")val posterPath: String,
    var favorite: Boolean

): Serializable {

}