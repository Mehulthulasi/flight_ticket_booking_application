package com.example.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private TextView airlineTextView;
    private TextView departureTextView;
    private TextView destinationTextView;
    private Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        airlineTextView = findViewById(R.id.airlineTextView);
        departureTextView = findViewById(R.id.departureTextView);
        destinationTextView = findViewById(R.id.destinationTextView);
        payButton = findViewById(R.id.payButton);

        // Retrieve data from the intent
        Intent intent = getIntent();
        String selectedAirline = intent.getStringExtra("airline");
        String departure = intent.getStringExtra("departure");
        String destination = intent.getStringExtra("destination");

        // Display data in TextViews
        airlineTextView.setText("Selected Airline: " + selectedAirline);
        departureTextView.setText("Departure: " + departure);
        destinationTextView.setText("Destination: " + destination);

        // Handle button click to proceed with payment
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the entered name and phone number
                EditText namee = findViewById(R.id.nameEditText);
                EditText num=findViewById(R.id.phoneNumberEditText);

                String passengerName = namee.getText().toString();
                String phoneNumber = num.getText().toString();


                // Replace MainActivity5.class with the actual class you want to navigate to
                Intent paymentIntent = new Intent(MainActivity4.this, MainActivity5.class);

                // Pass the data to the next activity
                paymentIntent.putExtra("selectedAirline", selectedAirline);
                paymentIntent.putExtra("passengerName", passengerName);
                paymentIntent.putExtra("phoneNumber", phoneNumber);

                // Start the next activity
                startActivity(paymentIntent);
            }
        });
    }
}
