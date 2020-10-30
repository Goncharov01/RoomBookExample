package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roombookexample.repository.BookRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AddBookActivity extends AppCompatActivity {
//    @Inject
//    MyDatabase myDatabase;

    @Inject
    BookRepository bookRepository;

    private EditText bookId, bookTitle, bookAuthor;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        bookId = findViewById(R.id.editId);
        bookTitle = findViewById(R.id.editTitle);
        bookAuthor = findViewById(R.id.editAuthor);

    }

    public void onClickSave(View view) {
        int id = Integer.parseInt(bookId.getText().toString());
        String title = bookTitle.getText().toString();
        String author = bookAuthor.getText().toString();

        BookModel bookModel = new BookModel();
        bookModel.setId(id);
        bookModel.setTitle(title);
        bookModel.setAuthor(author);

        bookRepository.addBook(bookModel);

        bookId.setText("");
        bookTitle.setText("");
        bookAuthor.setText("");

        Toast.makeText(AddBookActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();

    }

}
