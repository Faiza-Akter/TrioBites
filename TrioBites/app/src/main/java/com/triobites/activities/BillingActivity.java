package com.triobites.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triobites.R;
import com.triobites.adapters.OrderAdapter;
import com.triobites.data.AppDatabase;
import com.triobites.models.Order;

import java.util.List;

public class BillingActivity extends AppCompatActivity {

    private RecyclerView billingRecyclerView;
    private TextView totalAmountTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);

        billingRecyclerView = findViewById(R.id.billingRecyclerView);
        totalAmountTextView = findViewById(R.id.totalAmountTextView);

        billingRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Order> orders = AppDatabase.getInstance(this).orderDao().getAllOrders();
        billingRecyclerView.setAdapter(new OrderAdapter(orders));

        int total = 0;
        for (Order order : orders) {
            total += order.calculateTotal();
        }
        totalAmountTextView.setText("Total: " + total + " BDT");
    }
}
