package com.android.ecart.search;

import android.content.Context;
import android.os.AsyncTask;

import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter implements SearchContractor.Presenter{
    SearchContractor.View view;
    @Override
    public void attachView(SearchContractor.View view) {
        this.view = view;
    }

    @Override
    public void searchItem(String itemName) {
        String strSearch = "%"+itemName+"%";
        class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

            @Override
            protected List<Item> doInBackground(Void... voids) {
                List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                        .itemDao().getItemWiseData(strSearch);
                return dataList;
            }

            @Override
            protected void onPostExecute(List<Item> shoppingItem) {
                super.onPostExecute(shoppingItem);
                view.DisplayData((ArrayList<Item>) shoppingItem);
            }
        }
        DisplayingData displayingData = new DisplayingData();
        displayingData.execute();
    }
}
