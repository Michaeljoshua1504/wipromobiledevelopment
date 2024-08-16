package com.example.smarthomecontrollerapp.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class DeviceViewModel : ViewModel() {
    private val repository = DeviceRepository()
    val devices: LiveData<List<Device>> get() = repository.devices

    init {
        repository.fetchDevices()
    }
}