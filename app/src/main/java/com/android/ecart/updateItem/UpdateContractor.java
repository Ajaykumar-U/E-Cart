package com.android.ecart.updateItem;

import com.android.ecart.dataBase.Item;

public class UpdateContractor {
    interface Presenter{
        void setView(UpdateContractor.View view);
        void getShoppingItem(String itemName, String itemPrice,String itemCategory, String itemImage, Item shoppingItemEntities);
        void deleteItem(Item shoppingItemEntities);
    }
    interface View{
        void closeActivity();
    }
}
