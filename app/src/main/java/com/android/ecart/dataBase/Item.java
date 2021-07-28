package com.android.ecart.dataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Item implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int ItemId;
    @ColumnInfo(name = "Name")
    private String ItemName;
    @ColumnInfo(name = "Category")
    private String ItemCategory;
    @ColumnInfo(name = "Price")
    private int ItemPrice;
    @ColumnInfo(name = "Quantity")
    private int ItemQuantity;
    @ColumnInfo(name = "Total")
    private int ItemTotalPrice;
    @ColumnInfo(name = "Image")
    private String ItemImage;

    public int getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(int itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    public int getItemTotalPrice() {
        return ItemTotalPrice;
    }

    public void setItemTotalPrice(int itemTotalPrice) {
        ItemTotalPrice = itemTotalPrice;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getItemCategory() {
        return ItemCategory;
    }

    public String getItemImage() {
        return ItemImage;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setItemCategory(String itemCategory) {
        ItemCategory = itemCategory;
    }

    public void setItemImage(String itemImage) {
        ItemImage = itemImage;
    }
}
