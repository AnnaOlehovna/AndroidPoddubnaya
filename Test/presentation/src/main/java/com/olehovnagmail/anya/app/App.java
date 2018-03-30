package com.olehovnagmail.anya.app;


import android.app.Application;

import com.olehovnagmail.anya.injection.AppComponent;
import com.olehovnagmail.anya.injection.AppModule;
import com.olehovnagmail.anya.injection.DaggerAppComponent;

public class App extends Application{


    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();


    }
}
