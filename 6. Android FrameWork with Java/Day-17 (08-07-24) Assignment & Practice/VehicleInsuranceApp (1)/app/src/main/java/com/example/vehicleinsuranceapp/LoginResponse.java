package com.example.vehicleinsuranceapp;

public class LoginResponse {
    private boolean success;
    private String message;
    private String userId; // Add this line

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() { // Add this getter
        return userId;
    }

    public void setUserId(String userId) { // Add this setter
        this.userId = userId;
    }
}
