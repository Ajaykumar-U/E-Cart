package com.android.ecart.addItem;

public interface AddItemContractor {
    interface Presenter{
        void attachView(AddItemContractor.View view);
        void getItemInput(String itemName,String itemPrice,String itemImageUrl,String Category);
    }
    interface View{
        void closeAddActivity();
    }
}
