package com.example.roombookexample;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.roombookexample.repository.BookRepository;

import javax.inject.Inject;

public class UserViewModelFactory implements ViewModelProvider.Factory {

    BookRepository bookRepository;

    @Inject
    public UserViewModelFactory(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(AddBookViewModel.class)) {
            return (T) new AddBookViewModel(bookRepository);
        } else {
            throw new IllegalArgumentException("Unknown class");
        }

    }

}