package com.triobites.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triobites.R;
import com.triobites.adapters.CustomerAdapter;
import com.triobites.data.AppDatabase;
import com.triobites.models.Customer;

import java.util.List;

public class CustomerInfoActivity extends AppCompatActivity {

    private EditText nameEditText, phoneEditText, addressEditText;
    private Button saveCustomerButton;
    private RecyclerView customerRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        saveCustomerButton = findViewById(R.id.saveCustomerButton);
        customerRecyclerView = findViewById(R.id.customerRecyclerView);

        customerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshCustomerList();

        saveCustomerButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();
            String address = addressEditText.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
                return;
            }

            Customer customer = new Customer(name, phone, address);
            AppDatabase.getInstance(this).customerDao().insertCustomer(customer);
            Toast.makeText(this, "Customer info saved!", Toast.LENGTH_SHORT).show();

            nameEditText.setText("");
            phoneEditText.setText("");
            addressEditText.setText("");

            refreshCustomerList();
        });
    }

    private void refreshCustomerList() {
        List<Customer> customers = AppDatabase.getInstance(this).customerDao().getAllCustomers();
        customerRecyclerView.setAdapter(new CustomerAdapter(customers));
    }
}
