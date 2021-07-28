package com.android.ecart.finalBill;

import com.android.ecart.dataBase.Item;

import java.util.List;

public interface BillingContractor {
    interface Presenter{
        void attachView(BillingContractor.View view);
        void detachView();
        void getFinalBillData();
        void removeBillData();
    }
    interface View{
        void getFinalDataBill(List<Item> items);
    }
}
