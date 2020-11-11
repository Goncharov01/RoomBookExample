package com.example.roombookexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addBooks(BookModel bookModel);

    @Query("select * from books")
    public List<BookModel> getBooks();

    @Delete
    public void deleteBook(BookModel bookModel);

    @Update
    public void updateBook(BookModel bookModel);

}
