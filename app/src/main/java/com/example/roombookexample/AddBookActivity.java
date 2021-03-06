package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.roombookexample.databinding.ActivityAddBookBinding;
import com.example.roombookexample.repository.BookRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

import static android.view.View.VISIBLE;

public class AddBookActivity extends AppCompatActivity {

    BookModel bookModel;

    @Inject
    UserViewModelFactory userViewModelFactory;

    @Inject
    BookRepository bookRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        ActivityAddBookBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_book);
        AddBookViewModel addBookViewModel = ViewModelProviders.of(this, userViewModelFactory).get(AddBookViewModel.class);
        binding.setAddBookViewModel(addBookViewModel);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            bookModel = bundle.getParcelable("bookmodel");
            binding.setBookModel(bookModel);
            System.out.println(bookModel + "@@@@@@@@@@@@@@@@@@@@");
            addBookViewModel.idLive.setValue(String.valueOf(bookModel.id));
            addBookViewModel.titleLive.setValue(String.valueOf(bookModel.title));
            addBookViewModel.authorLive.setValue(String.valueOf(bookModel.author));
        }

    }

}
