package com.example.roombookexample.recycler;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.example.roombookexample.BookModel;
import com.example.roombookexample.repository.BookRepository;

import java.util.List;

public class BookDataSource extends PositionalDataSource<BookModel> {

    private BookRepository bookRepository;

    public BookDataSource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<BookModel> callback) {
        List<BookModel> bookModels = bookRepository.getBooks();
                List<BookModel> bookModels1 = bookModels.subList(params.requestedStartPosition,params.pageSize-1);
        callback.onResult(bookModels,0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<BookModel> callback) {
        List<BookModel> bookModels = bookRepository.getBooks().subList(params.startPosition,params.loadSize);

        callback.onResult(bookModels);
    }
}
