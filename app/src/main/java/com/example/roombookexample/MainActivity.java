package com.example.roombookexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.roombookexample.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);

    }

}
