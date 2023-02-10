package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        hideActionbar()

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        tvResult.text = result.toString().substring(0..4)

        val classification: String = when {
            result < 18.5f -> getString(R.string.message_underWeight)
            result in 18.5f..25.0f -> getString(R.string.message_normal)
            result in 25.0f..30.0f -> getString(R.string.message_overWeight)
            result in 30.0f..39.9f -> getString(R.string.message_obesity)
            else -> getString(R.string.message_severeObesity)
        }

        val classificationColor: String = when {
            result < 18.5f -> "#C80000"
            result in 18.5f..25.0f -> "#7f00ff"
            result in 25.0f..30.0f -> "#FFC107"
            result in 30.0f..39.9f -> "#FF5722"
            else -> "#C80000"
        }

        tvClassification.text = classification
        tvClassification.setTextColor(Color.parseColor(classificationColor))
    }

    fun hideActionbar() {
        supportActionBar?.hide()

    }
}