package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.rollDiceButton)
        val result = findViewById<TextView>(R.id.rollResultTextView)
        button.setOnClickListener {
            val randomNumber: Int = Random.Default.nextInt(6)
            result.text = "Result: " + randomNumber
        }
    }
}