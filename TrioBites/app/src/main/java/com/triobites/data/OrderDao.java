package com.triobites.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.triobites.models.Order;

import java.util.List;

@Dao
public interface OrderDao {

    @Insert
    void insertOrder(Order order);

    @Query("SELECT * FROM orders")
    List<Order> getAllOrders();
}
