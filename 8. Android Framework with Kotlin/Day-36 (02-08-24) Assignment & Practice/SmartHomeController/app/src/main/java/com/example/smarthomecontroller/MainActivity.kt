package com.example.smarthomecontroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText: TextView = findViewById(R.id.welcomeText)
        val lightsButton: Button = findViewById(R.id.lightsButton)
        val thermostatButton: Button = findViewById(R.id.thermostatButton)

        lightsButton.setOnClickListener {
            // Handle lights button click
            welcomeText.text = "Lights control clicked"
        }

        thermostatButton.setOnClickListener {
            // Handle thermostat button click
            welcomeText.text = "Thermostat control clicked"
        }
    }
}
