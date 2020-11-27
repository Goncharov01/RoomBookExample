package com.example.roombookexample.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roombookexample.AddBookActivity;
import com.example.roombookexample.BR;
import com.example.roombookexample.BookModel;
import com.example.roombookexample.R;
import com.example.roombookexample.databinding.TaskListItemBinding;
import com.example.roombookexample.repository.BookRepository;

public class BookItemViewHolder extends RecyclerView.ViewHolder {

    TaskListItemBinding binding;
    BookModel bookModel;

    public BookItemViewHolder(View v) {
        super(v);
        binding = DataBindingUtil.bind(v);
    }

    public void bind(Object obj, BookRepository bookRepository, ClickChangeListener clickChangeListener) {
        binding.setVariable(BR.model, obj);
        bookModel = (BookModel) obj;
        binding.executePendingBindings();
        binding.getRoot().findViewById(R.id.layoutList).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(view.getContext(), "Deleted book with ID " + bookModel.getId(), Toast.LENGTH_SHORT).show();
                bookRepository.deleteBook(bookModel);
                clickChangeListener.onChange(bookRepository.getBooks());
                return false;
            }
        });


        binding.getRoot().findViewById(R.id.layoutList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AddBookActivity.class);
                intent.putExtra("bookmodel", bookModel);
                context.startActivity(intent);
            }
        });

    }

}