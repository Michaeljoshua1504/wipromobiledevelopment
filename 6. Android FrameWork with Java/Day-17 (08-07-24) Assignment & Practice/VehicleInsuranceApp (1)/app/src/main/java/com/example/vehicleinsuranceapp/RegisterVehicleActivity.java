package com.example.vehicleinsuranceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import okhttp3.ResponseBody;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterVehicleActivity extends AppCompatActivity {

    private TextView textViewDynamicUserId;
    private Spinner spinnerVehicleType;
    private EditText editTextVehicleNumber;
    private EditText editTextVehicleOwnerName;
    private Spinner spinnerVehiclePolicy;
    private Button buttonSubmit;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_vehicle);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get userId from intent
        Intent intent = getIntent();
        userId = intent.getStringExtra("userId");

        // Initialize UI elements
        textViewDynamicUserId = findViewById(R.id.textViewDynamicUserId);
        spinnerVehicleType = findViewById(R.id.spinnerVehicleType);
        editTextVehicleNumber = findViewById(R.id.editTextVehicleNumber);
        editTextVehicleOwnerName = findViewById(R.id.editTextVehicleOwnerName);
        spinnerVehiclePolicy = findViewById(R.id.spinnerVehiclePolicy);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set userId TextView
        if (userId != null && !userId.isEmpty()) {
            textViewDynamicUserId.setText(userId);
        }

        // Dummy data for vehicle types and policies (replace with actual data if available)
        List<String> vehicleTypes = new ArrayList<>();
        vehicleTypes.add("Bike");
        vehicleTypes.add("Car");
        // Add more types as needed

        List<String> vehiclePolicies = new ArrayList<>();
        vehiclePolicies.add("1. Comprehensive Insurance");
        vehiclePolicies.add("2. Collision Insurance");
        vehiclePolicies.add("3. Liability Insurance");
        vehiclePolicies.add("4. Uninsured/Underinsured Motorist Coverage");
        vehiclePolicies.add("5. Personal Injury Protection ");
        // Add more policies as needed

        // Setup adapters for spinners
        ArrayAdapter<String> vehicleTypeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, vehicleTypes);
        vehicleTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicleType.setAdapter(vehicleTypeAdapter);

        ArrayAdapter<String> vehiclePolicyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, vehiclePolicies);
        vehiclePolicyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehiclePolicy.setAdapter(vehiclePolicyAdapter);

        // Handle submit button click
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capture input data
                String vehicleType = spinnerVehicleType.getSelectedItem().toString();
                String vehicleNumber = editTextVehicleNumber.getText().toString();
                String vehicleOwnerName = editTextVehicleOwnerName.getText().toString();
                String vehiclePolicy = spinnerVehiclePolicy.getSelectedItem().toString();

                // Send data to backend
                sendVehicleDetailsToServer(userId, vehicleType, vehicleNumber, vehicleOwnerName, vehiclePolicy);
            }
        });
    }

    // Method to send vehicle details to the backend
    private void sendVehicleDetailsToServer(String userId, String vehicleType, String vehicleNumber, String vehicleOwnerName, String vehiclePolicy) {
        // Create a new API client instance and define the request body
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Vehicle vehicle = new Vehicle(userId, vehicleType, vehicleNumber, vehicleOwnerName, vehiclePolicy);

        Call<ResponseBody> call = apiService.registerVehicle(vehicle);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    // Handle success
                    Toast.makeText(RegisterVehicleActivity.this, "Vehicle registration successful", Toast.LENGTH_SHORT).show();

                    // Save vehicle details in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("VehicleDetails", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("vehicleType", vehicleType);
                    editor.putString("vehicleNumber", vehicleNumber);
                    editor.putString("vehicleOwnerName", vehicleOwnerName);
                    editor.putString("vehiclePolicy", vehiclePolicy);
                    editor.apply();

                    // Navigate to HomePageActivity and pass vehicle details
                    Intent intent = new Intent(RegisterVehicleActivity.this, HomePageActivity.class);
                    intent.putExtra("userId", userId);
                    intent.putExtra("vehicleType", vehicleType);
                    intent.putExtra("vehicleNumber", vehicleNumber);
                    intent.putExtra("vehicleOwnerName", vehicleOwnerName);
                    intent.putExtra("vehiclePolicy", vehiclePolicy);
                    startActivity(intent);
                } else {
                    // Handle failure
                    Toast.makeText(RegisterVehicleActivity.this, "Vehicle registration failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Handle failure
                Toast.makeText(RegisterVehicleActivity.this, "Failed to connect to server: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to handle back to home button click
    public void navigateToHomePage(View view) {
        Intent intent = new Intent(RegisterVehicleActivity.this, HomePageActivity.class);
        intent.putExtra("userId", userId);
        startActivity(intent);
    }
}
