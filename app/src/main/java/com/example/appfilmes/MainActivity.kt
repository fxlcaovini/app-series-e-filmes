package com.example.appfilmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val viewModel by lazy {
        val factory = SeriesViewModelFactory(application)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rcvSeries)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = SerieAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.serie.observe(this) { series ->
            adapter.updateSeries(series)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }
}
