package com.olehovnagmail.anya.classworks.classwork5;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//сюда будут прилетать события, на которые мы подписались
public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("aaaaa","message");
    }
}
