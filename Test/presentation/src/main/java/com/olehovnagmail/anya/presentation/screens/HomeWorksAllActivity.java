package com.olehovnagmail.anya.presentation.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.olehovnagmail.anya.R;


import com.olehovnagmail.anya.presentation.screens.homework4.HW4Activity;
import com.olehovnagmail.anya.presentation.screens.homework5.HW5Activity;
import com.olehovnagmail.anya.presentation.screens.homework6.HW6ActivityOne;
import com.olehovnagmail.anya.presentation.screens.homework7.HW7Activity;
import com.olehovnagmail.anya.presentation.screens.homework8.HW8Activity;
import com.olehovnagmail.anya.presentation.screens.homework9.HW9Activity;
import com.olehovnagmail.anya.presentation.screens.homework1.HW1Activity;
import com.olehovnagmail.anya.presentation.screens.homework2.HW2Activity;
import com.olehovnagmail.anya.presentation.screens.homework3.HW3Activity;

public class HomeWorksAllActivity extends AppCompatActivity {

    private Button buttonHW1;
    private Button buttonHW2;
    private Button buttonHW3;
    private Button buttonHW4;
    private Button buttonHW5;
    private Button buttonHW6;
    private Button buttonHW7;
    private Button buttonHW8;
    private Button buttonHW9;
    private Button buttonHW12;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hw);

        buttonHW1=findViewById(R.id.hw1);
        buttonHW1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this, HW1Activity.class);
                startActivity(intent);
            }
        });


       buttonHW2=findViewById(R.id.hw2);
       buttonHW2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(HomeWorksAllActivity.this, HW2Activity.class);
               startActivity(intent);
           }
       });



        buttonHW3=findViewById(R.id.hw3);
        buttonHW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW3Activity.class);
                startActivity(intent);
            }
        });

        buttonHW4=findViewById(R.id.hw4);
        buttonHW4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
            }
        });

        buttonHW5=findViewById(R.id.hw5);
        buttonHW5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW5Activity.class);
                startActivity(intent);
            }
        });


        buttonHW6=findViewById(R.id.hw6);
        buttonHW6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW6ActivityOne.class);
                startActivity(intent);
            }
        });


        buttonHW7=findViewById(R.id.hw7);
        buttonHW7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW7Activity.class);
                startActivity(intent);
            }
        });

        buttonHW8=findViewById(R.id.hw8);
        buttonHW8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW8Activity.class);
                startActivity(intent);
            }
        });

        buttonHW9=findViewById(R.id.hw9);
        buttonHW9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWorksAllActivity.this,HW9Activity.class);
                startActivity(intent);
            }
        });

    }

}
