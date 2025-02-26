package com.android.lab3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aEditText = findViewById<EditText>(R.id.aTN)
        val bEditText = findViewById<EditText>(R.id.bTN)
        val cEditText = findViewById<EditText>(R.id.cTN)
        val solveButton = findViewById<Button>(R.id.button)

        solveButton.setOnClickListener {
            val a = aEditText.text.toString()
            val b = bEditText.text.toString()
            val c = cEditText.text.toString()

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("a", a)
                putExtra("b", b)
                putExtra("c", c)
            }
            startActivity(intent)
        }
    }
}
