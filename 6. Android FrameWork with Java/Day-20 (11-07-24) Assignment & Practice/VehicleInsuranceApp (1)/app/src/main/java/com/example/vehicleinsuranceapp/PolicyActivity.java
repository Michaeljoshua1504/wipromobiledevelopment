package com.example.vehicleinsuranceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        // Initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button
        getSupportActionBar().setTitle("Policy Details");

        TextView textViewPolicy = findViewById(R.id.textViewPolicy);

        // Set policy text directly here
        String policyText = "1. Comprehensive Insurance\n" +
                "\n" +
                "Coverage: Theft, vandalism, fire, natural disasters, and non-collision damages.\n" +
                "Benefits: Wide-ranging protection for unexpected events.\n" + "\n" +
                "2. Collision Insurance\n" +
                "Coverage: Damage from collisions, regardless of fault.\n" +
                "Benefits: Ensures repair or replacement of your vehicle after an accident.\n" +"\n" +
                "3. Liability Insurance\n" +
                "\n" +
                "Coverage: Injuries or damages caused to others.\n" +
                "Benefits: Legal and medical expense protection, often required.\n" + "\n" +
                "4. Uninsured/Underinsured Motorist Coverage\n" +
                "\n" +
                "Coverage: Protection if the other driver lacks sufficient insurance.\n" +
                "Benefits: Covers medical costs and damages despite the other party's insurance status.\n" + "\n" +
                "5. Personal Injury Protection (PIP) or Medical Payments Coverage (MedPay)\n" +
                "\n" +
                "Coverage: Medical expenses for you and passengers.\n" +
                "Benefits: Immediate medical cost coverage, regardless of fault.";
        textViewPolicy.setText(policyText);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHomePage();
            }
        });
    }

    private void navigateToHomePage() {
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear all activities in stack
        startActivity(intent);
        finish(); // Finish current activity
    }

    @Override
    public boolean onSupportNavigateUp() {
        navigateToHomePage();
        return true;
    }
}
