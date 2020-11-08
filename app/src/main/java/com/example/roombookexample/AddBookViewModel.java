package com.example.roombookexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roombookexample.repository.BookRepository;

import javax.inject.Inject;

public class AddBookViewModel extends ViewModel {

    BookRepository bookRepository;

    public MutableLiveData<String> idLive = new MutableLiveData<>();
    public MutableLiveData<String> titleLive = new MutableLiveData<>();
    public MutableLiveData<String> authorLive = new MutableLiveData<>();

    BookModel bookModel = new BookModel();

    @Inject
    public AddBookViewModel(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        idLive.setValue(String.valueOf(bookModel.id));
        titleLive.setValue(bookModel.title);
        authorLive.setValue(bookModel.author);
    }

    public void onClick() {
        System.out.println(bookModel + "***********");

        BookModel bookModel = new BookModel();
        bookModel.setId(Integer.parseInt(idLive.getValue()));
        bookModel.setTitle(titleLive.getValue());
        bookModel.setAuthor(authorLive.getValue());
        bookRepository.addBook(bookModel);

    }

}
