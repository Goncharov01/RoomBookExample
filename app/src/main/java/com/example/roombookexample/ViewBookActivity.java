package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.example.roombookexample.databinding.ActivityViewBookBinding;
import com.example.roombookexample.recycler.AdapterRecycler;
import com.example.roombookexample.recycler.BookDataSource;
import com.example.roombookexample.recycler.BookPagedAdapter;
import com.example.roombookexample.recycler.DiffUtilItem;
import com.example.roombookexample.repository.BookRepository;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
        BookDataSource bookDataSource = new BookDataSource(bookRepository);

        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(5)
                .setPrefetchDistance(1)
                .build();

        PagedList<BookModel> pagedList = new PagedList.Builder<>(bookDataSource, config)
                .setFetchExecutor(new MainThreadExecutor())
                .setNotifyExecutor(Executors.newSingleThreadExecutor())
                .build();

        BookPagedAdapter bookPagedAdapter = new BookPagedAdapter(new DiffUtilItem());
        bookPagedAdapter.submitList(pagedList);

        binding.setMyAdapter(bookPagedAdapter);

        List<BookModel> bookModels = bookRepository.getBooks();
        adapterRecycler.onChange(bookModels);

    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        view.setText(Integer.toString(value));
    }

}

class MainThreadExecutor implements Executor {
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable command) {
        mHandler.post(command);
    }
}
