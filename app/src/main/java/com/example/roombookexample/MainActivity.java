package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

//    Депенденси инжектион - внедрение зависимости, один из механизмов реализации инверсии контроля
    @Inject
    MyDatabase myDatabase;
    Button buttonAdd;
    Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.button_add);
        buttonView = findViewById(R.id.button_view);

    }

    public void onClickAdd(View view) {

        Intent intent = new Intent(MainActivity.this, AddBookActivity.class);

        startActivity(intent);

    }

    public void onClickView(View view) {

        Intent intent = new Intent(MainActivity.this, ViewBookActivity.class);

        startActivity(intent);

    }


}
