package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.roombookexample.databinding.ActivityMainBinding;
import com.example.roombookexample.databinding.ActivityViewBookBinding;
import com.example.roombookexample.repository.BookRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ViewBookActivity extends AppCompatActivity {

//    @Inject
//    MyDatabase myDatabase;

    @Inject
    BookRepository bookRepository;

    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        ActivityViewBookBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_book);
        ViewBookViewModel viewBookViewModel = ViewModelProviders.of(this).get(ViewBookViewModel.class);
        binding.setViewViewModel(viewBookViewModel);

        txtInfo = findViewById(R.id.tvInfo);

//        List<BookModel> bookModels = myDatabase.myDao().getBooks();
        List<BookModel> bookModels = bookRepository.getBooks();

        String info = "";

        for (BookModel bookModel : bookModels) {
            int id = bookModel.getId();
            String title = bookModel.getTitle();
            String author = bookModel.getAuthor();

            info = info + "\n\n" + "ID:" + id + "\n Name:" + title + "\n Email:" + author;
        }

        txtInfo.setText(info);

    }
}
