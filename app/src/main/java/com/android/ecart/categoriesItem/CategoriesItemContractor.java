package com.android.ecart.categoriesItem;

import com.android.ecart.categories.CategoryContractor;
import com.android.ecart.dataBase.Item;

import java.util.ArrayList;

public class CategoriesItemContractor {
    interface View{
        void displayData(ArrayList<Item> items);
    }
    interface Presenter{
        void attachView(CategoriesItemContractor.View view);
        void detachView();
        void getItemFromDb(int id);
    }
}
