package com.olehovnagmail.anya.classworks.classwork5;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.olehovnagmail.anya.R;

public class CW5Activity extends AppCompatActivity {
    private static final String ACTION_MY_MESSAGE = "com.olehovnagmail.anya.classworks.classwork1.ACTION_MY_MESSAGE";

    private Button buttonForBroadcast;
    private LocalBroadcastManager broadcastManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw5);
        broadcastManager = LocalBroadcastManager.getInstance(this);

        buttonForBroadcast = findViewById(R.id.buttonCW5);
        buttonForBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACTION_MY_MESSAGE);

                broadcastManager.sendBroadcast(intent);

            }
        });

    }

    private BroadcastReceiver myReceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("aaaa", "my action for receiver");

//          boolean isAirPlaneOn = intent.getBooleanExtra("state",false);
//           if(isAirPlaneOn){
//            Log.e("aaaaa","messageActivity mode ON");
//        }else{
//               Log.e("aaaaa","messageActivity mode OFF");
//           }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_MY_MESSAGE);
        broadcastManager.registerReceiver(myReceiver2, intentFilter);

        Intent intent = new Intent(this,MyService.class);
        startService(intent);

        Intent intent2 =new Intent(this,MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_LINK,"http://film1");
        startService(intent2);

        Intent intent3 =new Intent(this,MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_LINK,"http://film2");
        startService(intent3);

        Intent intent4 =new Intent(this,MyIntentService.class);
        intent4.putExtra(MyIntentService.KEY_LINK,"http://film3");
        startService(intent4);

    }

    @Override
    protected void onStop() {
        super.onStop();
        broadcastManager.unregisterReceiver(myReceiver2);
        stopService( new Intent(this,MyService.class));
    }
}
