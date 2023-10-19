package com.example.trebirthassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetail extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Get data passed from MainActivity
        Intent intent = getIntent();
        int product = intent.getIntExtra("product", 0);
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);

        // Display the result in TextViews
        TextView resultTextView = findViewById(R.id.productTextView);
        resultTextView.setText("Product: " + product);

        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText("Name: " + name);

        TextView ageTextView = findViewById(R.id.ageTextView);
        ageTextView.setText("Age: " + age);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            // Here, we are creating an intent and going back to previous MainActivity
            // by clearing all the previous activity that are on top of it.
            Intent intent1 = new Intent(ProductDetail.this, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
            finish();
        });

    }
}