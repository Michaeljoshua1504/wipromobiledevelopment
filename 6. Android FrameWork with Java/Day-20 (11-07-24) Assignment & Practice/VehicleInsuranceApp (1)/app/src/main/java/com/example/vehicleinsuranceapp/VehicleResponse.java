package com.example.vehicleinsuranceapp;

import com.example.vehicleinsuranceapp.Vehicle;
import com.google.gson.annotations.SerializedName;

public class VehicleResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("vehicle")
    private Vehicle vehicle;

    public String getMessage() {
        return message;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
