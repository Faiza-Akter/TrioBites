package com.triobites.models;

import androidx.databinding.adapters.Converters;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "orders")
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String dishName;
    private int quantity;

    @TypeConverters(Converters.class)
    private Date orderDate;

    private int totalAmount;

    public Order(String dishName, int quantity, Date orderDate, int totalAmount) {
        this.dishName = dishName;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getDishName() { return dishName; }
    public int getQuantity() { return quantity; }
    public Date getOrderDate() { return orderDate; }
    public int getTotalAmount() { return totalAmount; }

    public void setId(int id) { this.id = id; }
    public void setDishName(String dishName) { this.dishName = dishName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }
}
