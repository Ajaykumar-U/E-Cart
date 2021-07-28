package com.android.ecart.categories;

import com.android.ecart.dataBase.Item;

import java.util.ArrayList;

public interface CategoryContractor {
    interface View{
        void displayData(ArrayList<Item> items);
    }
    interface Presenter{
        void attachView(CategoryContractor.View view);
        void getItemFromDb();
        void getItemBasedCategory(String CategoryName);
    }
}
