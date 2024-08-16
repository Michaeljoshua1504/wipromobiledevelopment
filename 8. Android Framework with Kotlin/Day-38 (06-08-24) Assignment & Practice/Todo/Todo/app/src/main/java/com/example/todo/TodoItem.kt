package com.example.todo

data class TodoItem(
    val id: String? = null,  // Allow id to be nullable
    val title: String,
    val description: String
)
