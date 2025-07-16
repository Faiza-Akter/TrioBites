package com.triobites.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.triobites.models.Dish;

import java.util.List;

@Dao
public interface DishDao {

    @Insert
    void insertDish(Dish dish);

    @Update
    void updateDish(Dish dish);

    @Delete
    void deleteDish(Dish dish);

    @Query("SELECT * FROM dishes")
    List<Dish> getAllDishes();
}
