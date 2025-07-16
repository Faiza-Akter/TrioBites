package com.triobites.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.triobites.models.Customer;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert
    void insertCustomer(Customer customer);

    @Query("SELECT * FROM customers")
    List<Customer> getAllCustomers();
}
