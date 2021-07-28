package com.android.ecart.search;

import com.android.ecart.dataBase.Item;

import java.util.List;

public interface SearchContractor {
    interface Presenter{
        void attachView(SearchContractor.View view);
        void searchItem(String itemName);
    }
    interface View{
        void DisplayData(List<Item> itemList);
    }
}
