package com.example.trebirthassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText userName, userAge, number1, number2;
    Button productButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing the local variables from the values provided by the form
        userName = findViewById(R.id.userName);
        userAge = findViewById(R.id.userAge);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        productButton = findViewById(R.id.productButton);

        // Product Button onclick handler that will call submitProduct
        productButton.setOnClickListener(this::submitProduct);
    }


    public void submitProduct(View view) {
        // checking if user pressed the button without entering details
        if (isValid()) {
            try {
                moveToNextActivity();
            } catch (NumberFormatException e){
                Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            // Toast appears when user leaves the edit text field blank
            Toast.makeText(MainActivity.this, "Please enter details in all the fields", Toast.LENGTH_SHORT).show();
        }
    }
    private void moveToNextActivity(){
        String name = userName.getText().toString();
        int age = Integer.parseInt(userAge.getText().toString());
        int usernumber1 = Integer.parseInt(number1.getText().toString());
        int usernumber2 = Integer.parseInt(number2.getText().toString());
        int productofNumbers = usernumber1 * usernumber2;
        // Create an Intent to open ProductDetail
        Intent intent = new Intent(MainActivity.this, ProductDetail.class);

        // Pass data to ProductDetailActivity using Intent extras
        intent.putExtra("product", productofNumbers);
        intent.putExtra("name", name);
        intent.putExtra("age", age);

        // Start ProductDetailActivity
        startActivity(intent);
    }
    private Boolean isValid(){
        return !userName.getText().toString().isEmpty() &&
                !userAge.getText().toString().isEmpty() &&
                !number1.getText().toString().isEmpty() &&
                !number2.getText().toString().isEmpty();
    }
}