package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ViewBookActivity extends AppCompatActivity {

    private TextView txtInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        txtInfo = findViewById(R.id.tvInfo);

        List<BookModel> bookModels = MainActivity.myDatabase.myDao().getBooks();   // <-- ojo

        String info = "";

        for (BookModel bookModel : bookModels)
        {
            int id = bookModel.getId();
            String title = bookModel.getTitle();
            String author = bookModel.getAuthor();

            info = info + "\n\n" + "ID:"+ id + "\n Name:" + title + "\n Email:" + author;
        }

        txtInfo.setText(info);

    }
}
