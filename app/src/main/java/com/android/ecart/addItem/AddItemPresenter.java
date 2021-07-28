package com.android.ecart.addItem;

import android.content.Context;
import android.os.AsyncTask;

import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;

public class AddItemPresenter implements AddItemContractor.Presenter {
    AddItemContractor.View view;
    @Override
    public void attachView(AddItemContractor.View view) {
        this.view = view;
    }

    @Override
    public void getItemInput(String itemName, String itemPrice, String itemImageUrl, String itemCategory) {
        class InsertingData extends AsyncTask<Void,Void,Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                int price = Integer.parseInt(itemPrice);
                Item item = new Item();
                item.setItemName(itemName);
                item.setItemPrice(price);
                item.setItemCategory(itemCategory);
                item.setItemQuantity(0);;
                item.setItemTotalPrice(0);
                item.setItemImage(itemImageUrl);
                ItemDatabase.getItemDatabaseInstance((Context) view).itemDao().insertItem(item);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                view.closeAddActivity();
            }
        }
        InsertingData insertingData=new InsertingData();
        insertingData.execute();
    }
}
