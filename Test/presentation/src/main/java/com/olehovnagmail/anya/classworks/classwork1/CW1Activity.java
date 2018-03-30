package com.olehovnagmail.anya.classworks.classwork1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.classworks.classwork2.CW2Activity;
import com.olehovnagmail.anya.classworks.classwork6.CW6Activity;

public class CW1Activity extends AppCompatActivity {

    private static final String TAG = CW1Activity.class.getSimpleName();

    private Button buttonToCW2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw1);


        buttonToCW2 = findViewById(R.id.to_cw2);
        buttonToCW2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CW1Activity.this, CW2Activity.class);

                intent.putExtra(CW2Activity.KEY_TEXT,"Hellooo");

                startActivity(intent);

            }
        });


        Log.e(TAG,"onCreate");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
