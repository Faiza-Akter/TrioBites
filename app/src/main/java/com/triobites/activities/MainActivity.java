package com.triobites.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.triobites.R;

public class MainActivity extends AppCompatActivity {

    private Button menuButton, orderButton, billingButton, customerInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = findViewById(R.id.btnMenu);
        orderButton = findViewById(R.id.btnOrder);
        billingButton = findViewById(R.id.btnBilling);
        customerInfoButton = findViewById(R.id.btnCustomerInfo);

        menuButton.setOnClickListener(v -> startActivity(new Intent(this, MenuActivity.class)));
        orderButton.setOnClickListener(v -> startActivity(new Intent(this, OrderActivity.class)));
        billingButton.setOnClickListener(v -> startActivity(new Intent(this, BillingActivity.class)));
        customerInfoButton.setOnClickListener(v -> startActivity(new Intent(this, CustomerInfoActivity.class)));
    }
}
