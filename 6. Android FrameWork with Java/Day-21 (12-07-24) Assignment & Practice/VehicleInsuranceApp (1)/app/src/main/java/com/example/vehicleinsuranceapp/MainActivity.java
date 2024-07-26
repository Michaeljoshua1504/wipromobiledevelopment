package com.example.vehicleinsuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView forgetPasswordTextView, signUpTextView;
    private ApiService apiService;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.signuppass);
        loginButton = findViewById(R.id.loginbtn);
        forgetPasswordTextView = findViewById(R.id.forgetpasswordtxtbtn);
        signUpTextView = findViewById(R.id.signuptxtbtn);

        // Initialize ApiService and SessionManager
        apiService = ApiClient.getClient().create(ApiService.class);
        sessionManager = new SessionManager(this);

        // Check if user is already logged in
        if (sessionManager.isLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
            startActivity(intent);
            finish();
        }

        // Set click listeners
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate input
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter email and password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create LoginRequest object
                ApiService.LoginRequest loginRequest = new ApiService.LoginRequest(email, password);

                // Make network call
                apiService.login(loginRequest).enqueue(new Callback<ApiService.LoginResponse>() {
                    @Override
                    public void onResponse(Call<ApiService.LoginResponse> call, Response<ApiService.LoginResponse> response) {
                        if (response.isSuccessful()) {
                            ApiService.LoginResponse loginResponse = response.body();
                            if (loginResponse != null && loginResponse.isSuccess()) {
                                // Log successful login
                                Log.d("LoginSuccess", "User ID: " + loginResponse.getUserId());

                                // Save userId, email, and name in session
                                sessionManager.createLoginSession(loginResponse.getUserId(), loginResponse.getEmail(), loginResponse.getName());

                                // Navigate to HomePageActivity
                                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(MainActivity.this, "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            if (response.code() == 401) {
                                Toast.makeText(MainActivity.this, "Invalid email or password. Please try again.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Login failed. Please try again later.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiService.LoginResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Login failed. Please check your internet connection.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
