package com.example.roombookexample.recycler;

import androidx.recyclerview.widget.DiffUtil;

import com.example.roombookexample.BookModel;

import java.util.ArrayList;
import java.util.List;

public class BookDiffUtil extends DiffUtil.Callback {

    List<BookModel> oldList = new ArrayList<>();
    List<BookModel> newList = new ArrayList<>();

    public BookDiffUtil(List<BookModel> oldList, List<BookModel> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        BookModel bookModelOld = oldList.get(oldItemPosition);
        BookModel bookModelNew = newList.get(newItemPosition);

        return bookModelOld.getId() == bookModelNew.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        BookModel bookModelOld = oldList.get(oldItemPosition);
        BookModel bookModelNew = newList.get(newItemPosition);

        return bookModelOld.getAuthor().equals(bookModelNew.getAuthor()) & bookModelOld.getTitle().equals(bookModelNew.getTitle());
    }

}
