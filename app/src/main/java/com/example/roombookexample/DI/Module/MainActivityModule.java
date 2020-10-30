package com.example.roombookexample.DI.Module;

import com.example.roombookexample.AddBookActivity;
import com.example.roombookexample.MainActivity;
import com.example.roombookexample.ViewBookActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModules.class)
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector(modules = MainActivityModules.class)
    abstract AddBookActivity contributesMainActivity2();

    @ContributesAndroidInjector(modules = MainActivityModules.class)
    abstract ViewBookActivity contributesMainActivity3();

}
