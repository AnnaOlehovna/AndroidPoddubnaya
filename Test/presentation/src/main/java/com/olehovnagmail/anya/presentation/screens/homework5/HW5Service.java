package com.olehovnagmail.anya.presentation.screens.homework5;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class HW5Service extends Service{

    private MyBinder myBinder = new MyBinder();


    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyBinder extends Binder {

        HW5Service getService() {
            return HW5Service.this;
        }
    }



        public void changeWifiState(){
        WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(wifi.isWifiEnabled()){
            wifi.setWifiEnabled(false);
        }else if(!wifi.isWifiEnabled()){
            wifi.setWifiEnabled(true);
        }
    }



}
