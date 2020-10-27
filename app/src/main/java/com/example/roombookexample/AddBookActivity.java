package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    private EditText bookId, bookTitle, bookAuthor;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        bookId = findViewById(R.id.editId);
        bookTitle = findViewById(R.id.editTitle);
        bookAuthor = findViewById(R.id.editAuthor);

    }

    public void onClickSave(View view)
    {
        int id = Integer.parseInt(bookId.getText().toString());
        String title  = bookTitle.getText().toString();
        String author = bookAuthor.getText().toString();

        BookModel bookModel = new BookModel();
        bookModel.setId(id);
        bookModel.setTitle(title);
        bookModel.setAuthor(author);

        MainActivity.myDatabase.myDao().addBooks(bookModel);

        bookId.setText("");
        bookTitle.setText("");
        bookAuthor.setText("");

        Toast.makeText(AddBookActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();

    }

}
