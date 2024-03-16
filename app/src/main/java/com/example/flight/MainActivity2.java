package com.example.flight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private AutoCompleteTextView departureAutoCompleteTextView;
    private AutoCompleteTextView destinationAutoCompleteTextView;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        departureAutoCompleteTextView = findViewById(R.id.departureAutoCompleteTextView);
        destinationAutoCompleteTextView = findViewById(R.id.destinationAutoCompleteTextView);
        searchButton = findViewById(R.id.searchButton);

        // Create ArrayAdapter using a string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.sample_array, // Define your array in res/values/arrays.xml
                android.R.layout.simple_dropdown_item_1line
        );

        // Apply the adapter to the AutoCompleteTextViews
        departureAutoCompleteTextView.setAdapter(adapter);
        destinationAutoCompleteTextView.setAdapter(adapter);

        // Set listener to handle item selection
        departureAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the selected item in departureAutoCompleteTextView
            }
        });

        destinationAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the selected item in destinationAutoCompleteTextView
            }
        });

        // Set click listener for the searchButton
        searchButton.setOnClickListener(view -> {
            String departure = departureAutoCompleteTextView.getText().toString();
            String destination = destinationAutoCompleteTextView.getText().toString();

            // Pass the departure and destination to MainActivity3
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("departure", departure);
            intent.putExtra("destination", destination);
            startActivity(intent);
        });
    }
}
