package com.example.roombookexample;

import androidx.lifecycle.ViewModel;

import com.example.roombookexample.repository.BookRepository;

import javax.inject.Inject;

public class ViewBookViewModel extends ViewModel {

    @Inject
    BookRepository bookRepository;

}
