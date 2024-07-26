package com.example.vehicleinsuranceapp;

public class Vehicle {
    private String userId;
    private String vehicleType;
    private String vehicleNumber;
    private String vehicleOwnerName;
    private String vehiclePolicy;

    // Constructor
    public Vehicle(String userId, String vehicleType, String vehicleNumber, String vehicleOwnerName, String vehiclePolicy) {
        this.userId = userId;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehiclePolicy = vehiclePolicy;
    }

    // Getters and setters (if needed)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public String getVehiclePolicy() {
        return vehiclePolicy;
    }

    public void setVehiclePolicy(String vehiclePolicy) {
        this.vehiclePolicy = vehiclePolicy;
    }
}
