package com.android.ecart.updateItem;

import android.content.Context;
import android.os.AsyncTask;

import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;

public class UpdatePresenter implements UpdateContractor.Presenter{
    UpdateContractor.View view;
    @Override
    public void setView(UpdateContractor.View view) {
        this.view = view;
    }

    @Override
    public void getShoppingItem(String itemName, String itemPrice, String itemCategory, String itemImage, Item item) {
        class UpdateClass extends AsyncTask<Void,Void,Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                item.setItemName(itemName);
                item.setItemPrice(Integer.parseInt(itemPrice));
                item.setItemImage(itemImage);
                item.setItemCategory(itemCategory);
                item.setItemQuantity(0);;
                item.setItemTotalPrice(0);
                ItemDatabase.getItemDatabaseInstance((Context) view).itemDao().updateItem(item);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                view.closeActivity();
            }
        }
        UpdateClass updateClass = new UpdateClass();
        updateClass.execute();
    }

    @Override
    public void deleteItem(Item item) {
        class DeleteClass extends AsyncTask<Void,Void,Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                ItemDatabase.getItemDatabaseInstance((Context) view).itemDao().deleteItem(item);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                view.closeActivity();
            }
        }
        DeleteClass deleteClass = new DeleteClass();
        deleteClass.execute();
    }
}
