package com.triobites.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
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

    private Spinner dishSpinner;
    private NumberPicker quantityPicker;
    private Button placeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        dishSpinner = findViewById(R.id.dishSpinner);
        quantityPicker = findViewById(R.id.quantityPicker);
        placeOrderButton = findViewById(R.id.btnPlaceOrder);

        quantityPicker.setMinValue(1);
        quantityPicker.setMaxValue(10);

        List<Dish> dishList = AppDatabase.getInstance(this).dishDao().getAllDishes();
        ArrayAdapter<Dish> dishAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, dishList);
        dishAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dishSpinner.setAdapter(dishAdapter);


        placeOrderButton.setOnClickListener(v -> {
            Dish selectedDish = (Dish) dishSpinner.getSelectedItem();
            int quantity = quantityPicker.getValue();

            int totalAmount = selectedDish.getPrice() * quantity;

            Order order = new Order(selectedDish.getName(), quantity, new Date(), totalAmount);
            AppDatabase.getInstance(this).orderDao().insertOrder(order);
            Toast.makeText(this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
        });
    }
}