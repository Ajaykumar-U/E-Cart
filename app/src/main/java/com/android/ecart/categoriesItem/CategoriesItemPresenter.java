package com.android.ecart.categoriesItem;

import android.content.Context;
import android.os.AsyncTask;
import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;

import java.util.ArrayList;
import java.util.List;

public class CategoriesItemPresenter implements CategoriesItemContractor.Presenter {
    CategoriesItemContractor.View view;
    @Override
    public void attachView(CategoriesItemContractor.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void getItemFromDb(int id) {
        if(id == 1){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getFruits();
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
        else if(id == 2){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getVegetables();
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
        else if(id == 3 || id == 12){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getDairy();
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
        else if(id == 4 || id == 10){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getGrocery();
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
        else if(id == 11){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getFruVeges();
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
        else if(id == 13){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getSnacks();
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
        else if(id == 14){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getBeverages();
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
        else if(id == 15){
            class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

                @Override
                protected List<Item> doInBackground(Void... voids) {
                    List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                            .itemDao().getInstantFood();
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
        else{
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

    }
}
