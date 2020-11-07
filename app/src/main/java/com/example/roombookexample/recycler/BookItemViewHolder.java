package com.example.roombookexample.recycler;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roombookexample.BR;
import com.example.roombookexample.BookModel;
import com.example.roombookexample.R;
import com.example.roombookexample.databinding.TaskListItemBinding;
import com.example.roombookexample.repository.BookRepository;

import java.util.List;

public class BookItemViewHolder extends RecyclerView.ViewHolder {


    TaskListItemBinding binding;
    BookModel bookModel;

    public BookItemViewHolder(View v) {
        super(v);
        binding = DataBindingUtil.bind(v);
    }

    public void bind(Object obj, BookRepository bookRepository) {
        binding.setVariable(BR.model, obj);
        bookModel = (BookModel) obj;
        binding.executePendingBindings();
        binding.getRoot().findViewById(R.id.layoutList).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(view.getContext(),"Click" + bookModel.getId(),Toast.LENGTH_SHORT).show();
                List<BookModel> bookModels = bookRepository.getBooks();
                System.out.println("**********" + bookModels);
                return false;
            }
        });
    }

}