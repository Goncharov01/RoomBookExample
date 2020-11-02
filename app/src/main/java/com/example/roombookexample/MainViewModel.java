package com.example.roombookexample;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    public void onClickAdd(View view) {

        Context context = view.getContext();

        Intent intent = new Intent(context, AddBookActivity.class);
        context.startActivity(intent);

    }

    public void onClickView(View view) {

        Context context = view.getContext();

        Intent intent = new Intent(context, ViewBookActivity.class);
        context.startActivity(intent);

    }


}
