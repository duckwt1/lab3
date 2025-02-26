package com.android.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Lấy dữ liệu từ Intent
        val a = intent.getStringExtra("a")?.toDoubleOrNull() ?: 0.0
        val b = intent.getStringExtra("b")?.toDoubleOrNull() ?: 0.0
        val c = intent.getStringExtra("c")?.toDoubleOrNull() ?: 0.0


        val delta = b * b - 4 * a * c

        val result = when {
            delta < 0 -> "Phương trình vô nghiệm"
            delta == 0.0 -> "Phương trình có nghiệm kép: x = ${-b / (2 * a)}"
            else -> {
                val x1 = (-b + Math.sqrt(delta)) / (2 * a)
                val x2 = (-b - Math.sqrt(delta)) / (2 * a)
                "Nghiệm của phương trình:\nx1 = $x1\nx2 = $x2"
            }
        }

        // Hiển thị kết quả
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = "Result: $result"

        // Nút Back để quay lại MainActivity
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // Kết thúc activity và quay lại MainActivity
        }
    }
}
