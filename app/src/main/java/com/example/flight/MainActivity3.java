package com.example.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private TextView departureTextView;
    private TextView destinationTextView;
    private Button nextButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        departureTextView = findViewById(R.id.departureTextView);
        destinationTextView = findViewById(R.id.destinationTextView);
        nextButton = findViewById(R.id.continueButton);
        radioGroup = findViewById(R.id.radioGroup);

        // Retrieve data from the intent
        String departure = getIntent().getStringExtra("departure");
        String destination = getIntent().getStringExtra("destination");

        // Display data in TextViews
        departureTextView.setText("Departure: " + departure);
        destinationTextView.setText("Destination: " + destination);

        // Handle button click to redirect to the PaymentActivity
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected radio button id
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                // Find the selected radio button
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                // Get the text of the selected radio button
                String selectedAirline = selectedRadioButton.getText().toString();

                // Create an intent to start the PaymentActivity
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);

                // Put the selected details as extras in the intent
                intent.putExtra("airline", selectedAirline);
                intent.putExtra("departure", departure);
                intent.putExtra("destination", destination);

                // Start the PaymentActivity
                startActivity(intent);
            }
        });
    }
}
