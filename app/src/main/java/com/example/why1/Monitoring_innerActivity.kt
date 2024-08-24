package com.example.why1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class Monitoring_innerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoring_inner)

        val foodPercent = 90
        val cafePercent = 75
        val shoppingPercent = 50
        val etcPercent = 30

        val foodProgressBar = findViewById<ProgressBar>(R.id.foodProgressBar)
        val cafeProgressBar = findViewById<ProgressBar>(R.id.cafeProgressBar)
        val shoppingProgressBar = findViewById<ProgressBar>(R.id.shoppingProgressBar)
        val etcProgressBar = findViewById<ProgressBar>(R.id.etcProgressBar)

        foodProgressBar.progress = foodPercent
        cafeProgressBar.progress = cafePercent
        shoppingProgressBar.progress = shoppingPercent
        etcProgressBar.progress = etcPercent
    }
}