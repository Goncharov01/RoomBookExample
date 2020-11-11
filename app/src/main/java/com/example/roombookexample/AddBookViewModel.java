package com.example.roombookexample;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roombookexample.repository.BookRepository;


public class AddBookViewModel extends ViewModel {

    BookRepository bookRepository;

    public MutableLiveData<String> idLive = new MutableLiveData<>();
    public MutableLiveData<String> titleLive = new MutableLiveData<>();
    public MutableLiveData<String> authorLive = new MutableLiveData<>();

    BookModel bookModel = new BookModel();

    public AddBookViewModel(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        idLive.setValue(String.valueOf(bookModel.id));
        titleLive.setValue(bookModel.title);
        authorLive.setValue(bookModel.author);
    }

    public void onClick() {

        BookModel bookModel = new BookModel();
        bookModel.setId(Integer.parseInt(idLive.getValue()));
        bookModel.setTitle(titleLive.getValue());
        bookModel.setAuthor(authorLive.getValue());

        System.out.println(bookModel + "***********");

        if (bookModel.getId() == 0){
            bookRepository.addBook(bookModel);
            System.out.println("SAVE BOOKMODEL" + bookModel);
        } else {
            bookRepository.updateBook(bookModel);
            System.out.println("UPDATE BOOKMODEL" + bookModel);
        }

    }

}
