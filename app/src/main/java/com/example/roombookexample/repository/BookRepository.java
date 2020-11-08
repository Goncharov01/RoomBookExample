package com.example.roombookexample.repository;

import com.example.roombookexample.BookModel;
import com.example.roombookexample.MyDao;
import com.example.roombookexample.MyDatabase;

import java.util.List;

import javax.inject.Inject;


public class BookRepository  {

    MyDao myDao;

    @Inject
    public BookRepository(MyDatabase myDatabase) {
        this.myDao = myDatabase.myDao();
    }

    public void addBook(BookModel bookModel){
         myDao.addBooks(bookModel);
    }

    public List<BookModel> getBooks(){
        return myDao.getBooks();
    }

    public void deleteBook(BookModel bookModel){
        myDao.deleteBook(bookModel);
    }

}
