package com.example.roombookexample.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;

import androidx.recyclerview.widget.DiffUtil;

import com.example.roombookexample.BookModel;
import com.example.roombookexample.R;
import com.example.roombookexample.repository.BookRepository;

import java.util.List;

public class BookPagedAdapter extends PagedListAdapter<BookModel,BookItemViewHolder> implements ClickChangeListener {

    BookRepository bookRepository;

    public BookPagedAdapter(@NonNull DiffUtil.ItemCallback<BookModel> diffCallback,BookRepository bookRepository) {
        super(diffCallback);
        this.bookRepository = bookRepository;
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item,parent,false);
        BookItemViewHolder bookItemViewHolder = new BookItemViewHolder(view);

        return bookItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder holder, int position) {
        holder.bind(getItem(position),bookRepository,this);

    }

    @Override
    public void onChange(List<BookModel> books) {

    }
}
