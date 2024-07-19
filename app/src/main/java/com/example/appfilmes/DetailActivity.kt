package com.example.appfilmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var txtTitle: TextView
    private lateinit var txtDescription: TextView
    private lateinit var imgBack: ImageView
    private lateinit var imgPoster: ImageView
    private lateinit var btnFavorite: Button
    private val imgBasePath = "https://image.tmdb.org/t/p/w500"

    private val viewModel by lazy {
        val factory = SeriesViewModelFactory(application)
        ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    private var serie: Serie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        serie = intent.getSerializableExtra("serie") as Serie
        bindView()
    }

    private fun bindView() {
        txtTitle = findViewById(R.id.txtDetailName)
        txtDescription = findViewById(R.id.txtDetailDescription)
        imgBack = findViewById(R.id.imgDetailBack)
        imgPoster = findViewById(R.id.imgDetailPoster)
        btnFavorite = findViewById(R.id.btnDetailFavorite)

        serie?.let { serie ->
            txtTitle.text = serie.name
            txtDescription.text = serie.overview

            Glide.with(this).load("${imgBasePath}${serie.backdropPath}").into(imgBack)
            Glide.with(this).load("${imgBasePath}${serie.posterPath}").into(imgPoster)

            btnFavorite.text = if (serie.favorite) "Desfavoritar" else "Favoritar"
            btnFavorite.setOnClickListener {
                if (serie.favorite) {
                    unfavorite(serie)
                } else {
                    favorite(serie)
                }
                finish()
            }
        }
    }

    private fun favorite(serie: Serie) {
        viewModel.favorite(serie)
    }

    private fun unfavorite(serie: Serie) {
        viewModel.unfavorite(serie)
    }
}
