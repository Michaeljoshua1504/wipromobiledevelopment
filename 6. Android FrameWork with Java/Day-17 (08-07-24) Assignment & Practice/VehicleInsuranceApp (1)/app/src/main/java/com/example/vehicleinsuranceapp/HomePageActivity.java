package com.example.vehicleinsuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private CardView vehicleDetailsCardView;
    private TextView textViewVehicleDetails;
    private Button registerVehicleButton;
    private Button claimButton;
    private TextView statusView;
    private SessionManager sessionManager;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize session manager
        sessionManager = new SessionManager(this);

        // Initialize UI elements
        welcomeTextView = findViewById(R.id.welcomeTextView);
        vehicleDetailsCardView = findViewById(R.id.vehicleDetailsCardView);
        textViewVehicleDetails = findViewById(R.id.textViewVehicleDetails);
        registerVehicleButton = findViewById(R.id.registerVehicleButton);
        claimButton = findViewById(R.id.claimButton);
        statusView = findViewById(R.id.statusView);

        // Initialize API service
        apiService = ApiClient.getClient().create(ApiService.class);

        // Set welcome message using user's name
        String name = sessionManager.getName();
        if (name != null && !name.isEmpty()) {
            welcomeTextView.setText("Welcome " + name);
        }

        // Get userId from session
        String userId = sessionManager.getUserId();

        // Fetch vehicle details from server
        fetchVehicleDetails(userId);

        // Handle register vehicle button click
        registerVehicleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, RegisterVehicleActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });

        // Handle claim button click
        claimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle claim action here
                statusView.setText("Status: Submitted");
            }
        });
    }

    private void fetchVehicleDetails(String userId) {
        Call<Vehicle> call = apiService.getVehicleDetails(userId);
        call.enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Vehicle vehicle = response.body();
                    displayVehicleDetails(vehicle);
                    saveVehicleDetailsToPreferences(vehicle); // Save to preferences if needed
                } else {
                    vehicleDetailsCardView.setVisibility(View.GONE);
                    textViewVehicleDetails.setText("No vehicles found."); // Handle no vehicles found
                }
            }

            @Override
            public void onFailure(Call<Vehicle> call, Throwable t) {
                vehicleDetailsCardView.setVisibility(View.GONE);
                textViewVehicleDetails.setText("Failed to fetch vehicle details."); // Handle failure
            }
        });
    }

    private void displayVehicleDetails(Vehicle vehicle) {
        String vehicleDetails = "Vehicle Details:\nType: " + vehicle.getVehicleType() + "\nNumber: " + vehicle.getVehicleNumber() +
                "\nOwner: " + vehicle.getVehicleOwnerName() + "\nPolicy: " + vehicle.getVehiclePolicy();
        textViewVehicleDetails.setText(vehicleDetails);
        vehicleDetailsCardView.setVisibility(View.VISIBLE);
    }

    private void saveVehicleDetailsToPreferences(Vehicle vehicle) {
        sessionManager.saveVehicleDetails(vehicle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void navigateToAboutPolicies(View view) {
        Intent intent = new Intent(this, PolicyActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_profile) {
            startActivity(new Intent(HomePageActivity.this, ProfileActivity.class));
            return true;
        } else if (id == R.id.action_settings) {
            startActivity(new Intent(HomePageActivity.this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_help) {
            startActivity(new Intent(HomePageActivity.this, HelpActivity.class));
            return true;
        } else if (id == R.id.action_about) {
            startActivity(new Intent(HomePageActivity.this, AboutActivity.class));
            return true;
        } else if (id == R.id.action_logout) {
            sessionManager.logoutUser();
            startActivity(new Intent(HomePageActivity.this, MainActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
