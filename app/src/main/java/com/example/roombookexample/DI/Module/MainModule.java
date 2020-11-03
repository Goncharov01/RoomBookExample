package com.example.roombookexample.DI.Module;

import android.app.Application;

import androidx.room.Room;

import com.example.roombookexample.MyDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Singleton
    @Provides
    public MyDatabase getMyDao(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(), MyDatabase.class, "bookdb")
                .allowMainThreadQueries()
                .build();
    }

}