package com.triobites.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.triobites.R;
import com.triobites.data.AppDatabase;
import com.triobites.models.Dish;
import com.triobites.models.Order;

import java.util.Date;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private Spinner dishSpinner, quantitySpinner;
    private Button placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dishSpinner = findViewById(R.id.dishSpinner);
        quantitySpinner = findViewById(R.id.quantitySpinner);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        List<Dish> dishList = AppDatabase.getInstance(this).dishDao().getAllDishes();
        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dishList);
        dishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dishSpinner.setAdapter(dishAdapter);

        Integer[] quantities = new Integer[10];
        for (int i = 0; i < 10; i++) {
            quantities[i] = i + 1;
        }

        ArrayAdapter<Integer> quantityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, quantities);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(quantityAdapter);

        placeOrderButton.setOnClickListener((View v) -> {
            Dish selectedDish = (Dish) dishSpinner.getSelectedItem();
            int quantity = (int) quantitySpinner.getSelectedItem();
            Order order = new Order(selectedDish, quantity, new Date());
            AppDatabase.getInstance(this).orderDao().insertOrder(order);
            Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
        });
    }
}
