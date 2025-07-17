package com.triobites.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triobites.R;
import com.triobites.adapters.DishAdapter;
import com.triobites.data.AppDatabase;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuRecyclerView = findViewById(R.id.dishRecyclerView);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        DishAdapter adapter = new DishAdapter(AppDatabase.getInstance(this).dishDao().getAllDishes());
        menuRecyclerView.setAdapter(adapter);
    }
}
