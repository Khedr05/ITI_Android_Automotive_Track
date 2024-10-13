package com.example.rotatecounter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView countTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        countTxtView = findViewById(R.id.counterTxt);

        // Restore saved state (if any)
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
        }

        // Update the counter and text view on each rotation
        counter++;
        countTxtView.setText("Rotate Counter: " + counter);

    }

    // Save the counter value before rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
}