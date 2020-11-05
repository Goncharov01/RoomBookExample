package com.example.roombookexample.DI.Module;

import android.app.Application;

import com.example.roombookexample.App;
import com.example.roombookexample.ViewBookActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModules {

    @Binds
    abstract Application application(App app);

}
