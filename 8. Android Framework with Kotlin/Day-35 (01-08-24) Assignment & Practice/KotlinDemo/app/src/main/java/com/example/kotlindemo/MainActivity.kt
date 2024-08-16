package com.example.kotlindemo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button reference
        val buttonWelcome: Button = findViewById(R.id.buttonWelcome)

        // Set an OnClickListener to the button
        buttonWelcome.setOnClickListener {
            Toast.makeText(this, "Hello, Michael Joshua", Toast.LENGTH_SHORT).show()
        }
    }
}
