package com.example.smarthomecontrollerapp.Networking

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("devices")
    fun getDevices(): Call<List<Device>>
}