package com.android.ecart.dataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Item")
    List<Item> getAllData();

    @Insert
    void insertItem(Item item);

    @Update
    void updateItem(Item item);

    @Delete
    void deleteItem(Item item);

    @Query("UPDATE Item SET Price = :price, Quantity = :quantity, Total= :total  WHERE Name = :name")
    void updatingBill(int price,int quantity,int total,String name);

    @Query("SELECT * FROM Item WHERE Total > 0")
    List<Item> getBillingData();

    @Query("UPDATE Item SET Quantity = 0, Total= 0  WHERE Total > 0")
    void deleteBill();

    @Query("SELECT * FROM Item WHERE Category LIKE :categoryName")
    List<Item> getCategoriesWiseData(String categoryName);

    @Query("SELECT * FROM Item Where Name LIKE :itemName")
    List<Item> getItemWiseData(String itemName);

    @Query("SELECT * FROM Item WHERE Category LIKE 'Fruit%'")
    List<Item> getFruits();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Vegetable%'")
    List<Item> getVegetables();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Vegetable%' OR Category LIKE 'Fruit%'")
    List<Item> getFruVeges();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Dairy%'")
    List<Item> getDairy();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Snack%'")
    List<Item> getSnacks();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Instan%'")
    List<Item> getInstantFood();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Beverage%'")
    List<Item> getBeverages();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Grocery%'")
    List<Item> getGrocery();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Fashion%'")
    List<Item> getFashion();

    @Query("SELECT * FROM Item WHERE Category LIKE 'Medi%'")
    List<Item> getMedicines();
}
