package com.android.ecart.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Item.class},version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
    static ItemDatabase itemDatabaseInstance;
    public static synchronized ItemDatabase getItemDatabaseInstance(Context context){
        if(itemDatabaseInstance == null){
            itemDatabaseInstance = Room.databaseBuilder(context,ItemDatabase.class,"Item's List").build();
        }
        return itemDatabaseInstance;
    }
}
