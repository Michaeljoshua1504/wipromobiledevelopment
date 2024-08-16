package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageActivity : AppCompatActivity() {

    private lateinit var todoListView: ListView
    private lateinit var addTodoButton: Button
    private val todoItems = mutableListOf<TodoItem>()
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        todoListView = findViewById(R.id.todo_list)
        addTodoButton = findViewById(R.id.add_todo_button)

        adapter = TodoAdapter(this, todoItems)
        todoListView.adapter = adapter

        loadTodos()

        addTodoButton.setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadTodos() {
        ApiClient.apiService.getTodos().enqueue(object : Callback<List<TodoItem>> {
            override fun onResponse(call: Call<List<TodoItem>>, response: Response<List<TodoItem>>) {
                if (response.isSuccessful) {
                    todoItems.clear()
                    response.body()?.let { todoItems.addAll(it) }
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<TodoItem>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
