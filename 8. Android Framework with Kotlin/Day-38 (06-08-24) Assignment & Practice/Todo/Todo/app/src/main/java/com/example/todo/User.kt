package com.example.todo

data class User(
    val id: String? = null,  // Allow id to be nullable
    val username: String,
    val password: String
)

