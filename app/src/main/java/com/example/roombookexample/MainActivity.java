package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static MyDatabase myDatabase;
    Button buttonAdd;
    Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"bookdb").allowMainThreadQueries().build();

        buttonAdd = findViewById(R.id.button_add);
        buttonView = findViewById(R.id.button_view);

    }

    public void onClickAdd(View view){

        Intent intent = new Intent(MainActivity.this,AddBookActivity.class);

        startActivity(intent);

    }

    public void onClickView(View view){

        Intent intent = new Intent(MainActivity.this,ViewBookActivity.class);

        startActivity(intent);

    }


}
