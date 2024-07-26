package com.example.vehicleinsuranceapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    // Signup endpoint
    @POST("/signup")
    Call<SignupResponse> signup(@Body SignupRequest signupRequest);

    // Login endpoint
    @POST("/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    // Register a new vehicle
    @POST("/vehicle-info")
    Call<ResponseBody> registerVehicle(@Body Vehicle vehicle);

    // Fetch vehicle details by user ID
    @GET("/vehicles/{userId}")
    Call<Vehicle> getVehicleDetails(@Path("userId") String userId);

    // Inner classes for request and response bodies

    // Signup request body
    class SignupRequest {
        private String name;
        private String email;
        private String password;
        private String dob;

        public SignupRequest(String name, String email, String password, String dob) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.dob = dob;
        }

        // Getters and setters (if needed)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }
    }

    // Login request body
    class LoginRequest {
        private String email;
        private String password;

        public LoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }

        // Getters and setters (if needed)
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    // Signup response body
    class SignupResponse {
        private boolean success;
        private String message;

        // Getters and setters (if needed)
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
    }

    // Login response body
    class LoginResponse {
        private boolean success;
        private String message;
        private String userId;
        private String name;
        private String email;

        // Getters and setters (if needed)
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
