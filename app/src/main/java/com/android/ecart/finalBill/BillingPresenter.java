package com.android.ecart.finalBill;

import android.content.Context;
import android.os.AsyncTask;

import com.android.ecart.dataBase.Item;
import com.android.ecart.dataBase.ItemDatabase;

import java.util.ArrayList;
import java.util.List;

public class BillingPresenter implements BillingContractor.Presenter {
    BillingContractor.View view;
    @Override
    public void attachView(BillingContractor.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void getFinalBillData() {
        class DisplayingData extends AsyncTask<Void,Void, List<Item>> {

            @Override
            protected List<Item> doInBackground(Void... voids) {
                List<Item> dataList = ItemDatabase.getItemDatabaseInstance((Context) view)
                        .itemDao().getBillingData();
                return dataList;
            }

            @Override
            protected void onPostExecute(List<Item> shoppingItem) {
                super.onPostExecute(shoppingItem);
                view.getFinalDataBill(shoppingItem);
            }
        }
        DisplayingData displayingData = new DisplayingData();
        displayingData.execute();
    }

    @Override
    public void removeBillData() {
        class DeleteClass extends AsyncTask<Void,Void,Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                ItemDatabase.getItemDatabaseInstance((Context) view).itemDao().deleteBill();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }
        DeleteClass deleteClass = new DeleteClass();
        deleteClass.execute();
    }
}
