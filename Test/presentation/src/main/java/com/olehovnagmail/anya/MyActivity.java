package com.olehovnagmail.anya;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.olehovnagmail.anya.classworks.classwork1.CW1Activity;
import com.olehovnagmail.anya.presentation.screens.HomeWorksAllActivity;


public class MyActivity extends AppCompatActivity {

    private Button buttonCW;
    private Button buttonHW;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        buttonCW = findViewById(R.id.buttonClasswork);
        buttonCW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, CW1Activity.class);
                startActivity(intent);
            }
        });


        buttonHW = findViewById(R.id.buttonHomework);
        buttonHW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, HomeWorksAllActivity.class);
                startActivity(intent);
            }
        });

    }
}

