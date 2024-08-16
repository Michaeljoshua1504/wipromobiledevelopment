package com.example.smarthomecontrollerapp.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.smarthomecontroller.Networking.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeviceRepository {
    private val _devices = MutableLiveData<List<Device>>()
    val devices: LiveData<List<Device>> get() = _devices

    fun fetchDevices() {
        RetrofitClient.instance.getDevices().enqueue(object : Callback<List<Device>> {
            override fun onResponse(call: Call<List<Device>>, response: Response<List<Device>>) {
                _devices.value = response.body()
            }

            override fun onFailure(call: Call<List<Device>>, t: Throwable) {
                _devices.value = emptyList()
            }
        })
    }
}