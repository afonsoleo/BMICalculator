package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideActionbar()

        val btnCalculate: Button = findViewById(R.id.btn_calculate)
        val edtWeight: EditText = findViewById(R.id.edttext_weight)
        val edtHeight: EditText = findViewById(R.id.edttext_height)

        btnCalculate.setOnClickListener {

            val heightStr: String = edtHeight.text.toString()
            val weightStr: String = edtWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()
                val finalHeight: Float = height * height

                val result: Float = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun hideActionbar() {
        supportActionBar?.hide()
    }
}