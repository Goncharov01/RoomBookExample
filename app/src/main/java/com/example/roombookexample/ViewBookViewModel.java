package com.example.roombookexample;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.roombookexample.repository.BookRepository;

import java.util.List;

import javax.inject.Inject;

public class ViewBookViewModel extends ViewModel {

    @Inject
    BookRepository bookRepository;

//    List<BookModel> bookModels = bookRepository.getBooks();

    public void setTextInfo() {

        String info = "";

//        for (BookModel bookModel : bookModels) {
//            int id = bookModel.getId();
//            String title = bookModel.getTitle();
//            String author = bookModel.getAuthor();
//
//            info = info + "\n\n" + "ID:" + id + "\n Name:" + title + "\n Email:" + author;
//        }

    }


}
