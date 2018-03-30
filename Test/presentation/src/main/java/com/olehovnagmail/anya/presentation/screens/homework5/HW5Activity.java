package com.olehovnagmail.anya.presentation.screens.homework5;


import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.olehovnagmail.anya.R;

public class HW5Activity extends AppCompatActivity {

    private Button wifiChange;
    private ImageView imageView;
    private boolean isBinded;
    private HW5Service mService;



    private ServiceConnection serviceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            HW5Service.MyBinder binder = (HW5Service.MyBinder) service;
            mService = binder.getService();
            isBinded = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBinded = false;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5);
        imageView = findViewById(R.id.wifi_icon);
        wifiChange = findViewById(R.id.wifi_change);
        wifiChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.changeWifiState();

            }
        });
        checkWifi();


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(br, intentFilter);

        Intent intentService = new Intent(HW5Activity.this, HW5Service.class);
        bindService(intentService, serviceConn, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isBinded) {
            unbindService(serviceConn);
            isBinded = false;
        }

    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkWifi();
        }
    };


    private void checkWifi() {
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()) {
            imageView.setColorFilter(getResources().getColor(R.color.wifi_on),
                    android.graphics.PorterDuff.Mode.SRC_IN);
            wifiChange.setText("turn off");

        } else {
            imageView.setColorFilter(getResources().getColor(R.color.wifi_off),
                    android.graphics.PorterDuff.Mode.SRC_IN);
            wifiChange.setText("turn on");
        }


    }


}
