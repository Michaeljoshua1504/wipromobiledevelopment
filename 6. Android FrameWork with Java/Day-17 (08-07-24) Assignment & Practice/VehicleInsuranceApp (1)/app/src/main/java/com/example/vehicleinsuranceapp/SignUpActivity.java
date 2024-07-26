package com.example.vehicleinsuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, dobEditText;
    private Button signUpButton;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize views
        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.signupemail); // Notice the ID correction
        passwordEditText = findViewById(R.id.signuppass);
        dobEditText = findViewById(R.id.Dob);
        signUpButton = findViewById(R.id.signupbtn);

        // Initialize ApiService instance
        apiService = ApiClient.getClient().create(ApiService.class);

        // Set click listeners
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from EditTexts
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String dob = dobEditText.getText().toString();

                // Create SignupRequest object
                ApiService.SignupRequest signupRequest = new ApiService.SignupRequest(name, email, password, dob);

                // Make network call
                apiService.signup(signupRequest).enqueue(new Callback<ApiService.SignupResponse>() {
                    @Override
                    public void onResponse(Call<ApiService.SignupResponse> call, Response<ApiService.SignupResponse> response) {
                        if (response.isSuccessful()) {
                            // Handle successful response
                            Toast.makeText(SignUpActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // Optional: close current activity to prevent going back to it on back press
                        } else {
                            // Handle unsuccessful response
                            Toast.makeText(SignUpActivity.this, "Signup failed. Please try again later.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiService.SignupResponse> call, Throwable t) {
                        // Handle failure
                        Toast.makeText(SignUpActivity.this, "Signup failed. Please check your internet connection.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
