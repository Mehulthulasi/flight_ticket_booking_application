package com.example.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    private EditText nameEditText;
    private EditText phoneNumberEditText;
    private EditText flightNameEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Initialize UI elements
        nameEditText = findViewById(R.id.nameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        flightNameEditText = findViewById(R.id.flightNameEditText);
        submitButton = findViewById(R.id.submitButton);

        // Retrieve data from the intent
        Intent intent = getIntent();
        String selectedAirline = intent.getStringExtra("selectedAirline");
        String passengerName = intent.getStringExtra("passengerName");
        String phoneNumber = intent.getStringExtra("phoneNumber");

        // Set the retrieved data in the EditTexts
        nameEditText.setText(passengerName);
        phoneNumberEditText.setText(phoneNumber);
        flightNameEditText.setText(selectedAirline);

        // Handle button click to submit user info
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String passengerName = nameEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                String airline = flightNameEditText.getText().toString();

                // You can now use the obtained user information as needed
                // For example, display a confirmation message or proceed to the next step

                // For now, we'll just display a toast message with the user's name
                String message = "Hello, " + passengerName + "! Your information has been submitted.";
                showToast(message);

                // You can proceed to the next activity or take further actions based on your requirements
            }
        });
    }

    // Utility method to display a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
