package com.example.roombookexample.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.roombookexample.BookModel;

public class DiffUtilItem extends DiffUtil.ItemCallback<BookModel> {

    @Override
    public boolean areItemsTheSame(@NonNull BookModel oldItem, @NonNull BookModel newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull BookModel oldItem, @NonNull BookModel newItem) {
        return oldItem.getAuthor().equals(newItem.getAuthor()) & oldItem.getTitle().equals(newItem.getTitle());
    }
}
