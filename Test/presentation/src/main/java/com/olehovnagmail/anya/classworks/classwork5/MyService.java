package com.olehovnagmail.anya.classworks.classwork5;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service", "onBind");
        return null;

    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("service", "onUnbind");
        return super.onUnbind(intent);

    }

}
