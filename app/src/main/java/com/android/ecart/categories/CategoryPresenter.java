package com.android.ecart.categories;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;

import java.util.ArrayList;
import java.util.List;

public class CategoryPresenter implements CategoryContractor.Presenter{
    CategoryContractor.View view;
    @Override
    public void attachView(CategoryContractor.View view) {
        this.view = view;
    }

    @Override
    public void getItemFromDb() {


        class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

            @Override
            protected List<Item> doInBackground(Void... voids) {
                List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                        .itemDao().getAllData();
                return dataList;
            }

            @Override
            protected void onPostExecute(List<Item> shoppingItem) {
                super.onPostExecute(shoppingItem);
                view.displayData((ArrayList<Item>) shoppingItem);
            }
        }
        DisplayingData displayingData = new DisplayingData();
        displayingData.execute();
    }

    @Override
    public void getItemBasedCategory(String CategoryName) {
        class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

            @Override
            protected List<Item> doInBackground(Void... voids) {
                List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                        .itemDao().getCategoriesWiseData(CategoryName);
                return dataList;
            }

            @Override
            protected void onPostExecute(List<Item> shoppingItem) {
                super.onPostExecute(shoppingItem);
                view.displayData((ArrayList<Item>) shoppingItem);
            }
        }
        DisplayingData displayingData = new DisplayingData();
        displayingData.execute();
    }
}
