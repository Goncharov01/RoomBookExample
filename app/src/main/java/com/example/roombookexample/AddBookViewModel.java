package com.example.roombookexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.VisibleForTesting;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roombookexample.repository.BookRepository;

import static android.view.View.VISIBLE;


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

    public void onClick(View v) {

        Context context = v.getContext();

        BookModel bookModel = new BookModel();
        bookModel.setId(Integer.parseInt(idLive.getValue()));
        bookModel.setTitle(titleLive.getValue());
        bookModel.setAuthor(authorLive.getValue());

        System.out.println(bookModel + "***********");

        if (bookModel.getId() == 0) {
            bookRepository.addBook(bookModel);
            System.out.println("SAVE BOOKMODEL" + bookModel);
        } else {
            bookRepository.updateBook(bookModel);
            System.out.println("UPDATE BOOKMODEL" + bookModel);
        }

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

}
