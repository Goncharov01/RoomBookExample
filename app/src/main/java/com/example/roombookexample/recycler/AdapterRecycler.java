package com.example.roombookexample.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roombookexample.BookModel;
import com.example.roombookexample.databinding.TaskListItemBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class AdapterRecycler extends RecyclerView.Adapter<BookItemViewHolder> {

    List<BookModel> bookList = new ArrayList<>();

    @Inject
    public AdapterRecycler() {
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskListItemBinding binding = TaskListItemBinding.inflate(inflater, parent, false);
        return new BookItemViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder holder, int position) {
        BookModel bookModel = bookList.get(position);
        holder.bind(bookModel);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void onChange(List<BookModel> books) {
        bookList.clear();
        bookList.addAll(books);
        notifyDataSetChanged();
    }

}