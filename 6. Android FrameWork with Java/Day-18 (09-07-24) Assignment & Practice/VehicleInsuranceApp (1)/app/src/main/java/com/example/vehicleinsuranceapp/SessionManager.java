package com.example.vehicleinsuranceapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    // Login session preferences
    private static final String PREF_NAME_LOGIN = "LoginSession";
    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "name";

    // Vehicle details preferences
    private static final String PREF_NAME_VEHICLE = "VehicleInsuranceAppPreferences";
    private static final String KEY_VEHICLE_TYPE = "vehicleType";
    private static final String KEY_VEHICLE_NUMBER = "vehicleNumber";
    private static final String KEY_VEHICLE_OWNER_NAME = "vehicleOwnerName";
    private static final String KEY_VEHICLE_POLICY = "vehiclePolicy";

    private SharedPreferences loginPreferences;
    private SharedPreferences vehiclePreferences;
    private SharedPreferences.Editor loginEditor;
    private SharedPreferences.Editor vehicleEditor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        loginPreferences = context.getSharedPreferences(PREF_NAME_LOGIN, Context.MODE_PRIVATE);
        vehiclePreferences = context.getSharedPreferences(PREF_NAME_VEHICLE, Context.MODE_PRIVATE);
        loginEditor = loginPreferences.edit();
        vehicleEditor = vehiclePreferences.edit();
    }

    // Login session methods

    public void createLoginSession(String userId, String email, String name) {
        loginEditor.putBoolean(IS_LOGGED_IN, true);
        loginEditor.putString(KEY_USER_ID, userId);
        loginEditor.putString(KEY_EMAIL, email);
        loginEditor.putString(KEY_NAME, name); // Store the user's name
        loginEditor.apply();
    }

    public boolean isLoggedIn() {
        return loginPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    public String getUserId() {
        return loginPreferences.getString(KEY_USER_ID, null);
    }

    public String getEmail() {
        return loginPreferences.getString(KEY_EMAIL, null);
    }

    public String getName() {
        return loginPreferences.getString(KEY_NAME, null);
    }

    public void logoutUser() {
        loginEditor.clear();
        loginEditor.apply();
    }

    // Vehicle details methods

    public void saveVehicleDetails(Vehicle vehicle) {
        vehicleEditor.putString(KEY_VEHICLE_TYPE, vehicle.getVehicleType());
        vehicleEditor.putString(KEY_VEHICLE_NUMBER, vehicle.getVehicleNumber());
        vehicleEditor.putString(KEY_VEHICLE_OWNER_NAME, vehicle.getVehicleOwnerName());
        vehicleEditor.putString(KEY_VEHICLE_POLICY, vehicle.getVehiclePolicy());
        vehicleEditor.apply();
    }

    public Vehicle getVehicleDetails() {
        String vehicleType = vehiclePreferences.getString(KEY_VEHICLE_TYPE, null);
        String vehicleNumber = vehiclePreferences.getString(KEY_VEHICLE_NUMBER, null);
        String vehicleOwnerName = vehiclePreferences.getString(KEY_VEHICLE_OWNER_NAME, null);
        String vehiclePolicy = vehiclePreferences.getString(KEY_VEHICLE_POLICY, null);

        if (vehicleType != null && vehicleNumber != null && vehicleOwnerName != null && vehiclePolicy != null) {
            return new Vehicle(getUserId(), vehicleType, vehicleNumber, vehicleOwnerName, vehiclePolicy);
        }
        return null;
    }
}
