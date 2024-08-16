package com.example.todo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTodoActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        titleEditText = findViewById(R.id.title)
        descriptionEditText = findViewById(R.id.description)
        saveButton = findViewById(R.id.save_button)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            val newTodo = TodoItem(id = "", title = title, description = description)

            ApiClient.apiService.createTodo(newTodo).enqueue(object : Callback<TodoItem> {
                override fun onResponse(call: Call<TodoItem>, response: Response<TodoItem>) {
                    if (response.isSuccessful) {
                        // Handle successful todo creation
                        finish()
                    }
                }

                override fun onFailure(call: Call<TodoItem>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }
}
