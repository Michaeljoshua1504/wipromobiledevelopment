package com.example.todo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ApiService {
    @POST("signup")
    fun signup(@Body user: User): Call<User>

    @POST("login")
    fun login(@Body user: User): Call<User>

    @GET("todos")
    fun getTodos(): Call<List<TodoItem>>

    @POST("todos")
    fun createTodo(@Body todo: TodoItem): Call<TodoItem>

    @PUT("todos/{id}")
    fun updateTodo(@Path("id") id: String, @Body todo: TodoItem): Call<TodoItem>

    @DELETE("todos/{id}")
    fun deleteTodo(@Path("id") id: String): Call<Void>
}
