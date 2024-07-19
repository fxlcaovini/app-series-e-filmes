package com.example.appfilmes

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SerieAdapter(private var items: List<Serie>) : RecyclerView.Adapter<SerieAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateSeries(newSeries: List<Serie>) {
        items = newSeries
        notifyDataSetChanged()
    }

    class ViewHolder(val itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val imgBasePath = "https://image.tmdb.org/t/p/w500"

        fun bindView(serie: Serie) {
            with(itemview) {
                val imgPicture = findViewById<ImageView>(R.id.imgPicture)
                Glide.with(this).load("${imgBasePath}${serie.posterPath}").into(imgPicture)
                findViewById<ImageView>(R.id.imgFavorite).visibility = if (serie.favorite) View.VISIBLE else View.GONE
                findViewById<TextView>(R.id.txtName).text = serie.name
                itemview.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra("serie", serie)
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.series_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val serie = items[position]
        holder.bindView(serie)
    }
}
