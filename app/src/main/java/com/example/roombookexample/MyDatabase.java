package com.example.roombookexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BookModel.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
