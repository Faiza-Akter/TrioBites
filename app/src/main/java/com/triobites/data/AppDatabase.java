package com.triobites.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.triobites.models.Customer;
import com.triobites.models.Dish;
import com.triobites.models.Order;

@Database(entities = {Dish.class, Order.class, Customer.class}, version = 1)
@TypeConverters(RoomTypeConverters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract DishDao dishDao();
    public abstract OrderDao orderDao();
    public abstract CustomerDao customerDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "trio_bites_db"
            ).allowMainThreadQueries().build(); // Use ViewModel/Coroutine for production
        }
        return instance;
    }
}
