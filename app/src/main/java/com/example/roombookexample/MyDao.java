package com.example.roombookexample;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addBooks(BookModel bookModel);

    @Query("select * from books")
    public List<BookModel> getBooks();

}
