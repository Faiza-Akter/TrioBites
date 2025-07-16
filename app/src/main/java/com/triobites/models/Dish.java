package com.triobites.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dishes")
public class Dish {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String category;
    private int price;

    public Dish(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return name + " (" + category + ") - " + price + " BDT";
    }
}
