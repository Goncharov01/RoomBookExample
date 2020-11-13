package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.roombookexample.databinding.ActivityViewBookBinding;
import com.example.roombookexample.recycler.AdapterRecycler;
import com.example.roombookexample.repository.BookRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ViewBookActivity extends AppCompatActivity {

    @Inject
    BookRepository bookRepository;

    @Inject
    AdapterRecycler adapterRecycler;
    ViewBookViewModel viewBookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        ActivityViewBookBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_book);
        viewBookViewModel = ViewModelProviders.of(this).get(ViewBookViewModel.class);
        binding.setViewViewModel(viewBookViewModel);
        binding.setMyAdapter(adapterRecycler);

        List<BookModel> bookModels = bookRepository.getBooks();
        adapterRecycler.onChange(bookModels);

    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        view.setText(Integer.toString(value));
    }
}
