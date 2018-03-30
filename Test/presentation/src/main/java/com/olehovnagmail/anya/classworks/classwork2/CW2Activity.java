package com.olehovnagmail.anya.classworks.classwork2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.classworks.classwork3.CW3Activity;
import com.olehovnagmail.anya.classworks.classwork4.CW4Activity;
import com.olehovnagmail.anya.classworks.classwork5.CW5Activity;
import com.olehovnagmail.anya.classworks.classwork6.CW6Activity;
import com.olehovnagmail.anya.classworks.classwork7.CW7Activity;
import com.olehovnagmail.anya.classworks.classwork8.CW8Activity;
import com.olehovnagmail.anya.classworks.classwork9.CW9Activity;


public class CW2Activity extends AppCompatActivity {


    public static final String KEY_TEXT="KEY_TEXT";

    private Button buttonToCW3;
    private Button buttonToCW4;
    private Button buttonToCW5;
    private Button buttonToCW6;
    private Button buttonToCW7;
    private Button buttonToCW8;
    private Button buttonToCW9;
    private Button buttonToCW10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw2);

        String text=getIntent().getStringExtra(KEY_TEXT);

        if(text.contains("Hello")){
            Log.e("AAA","contains");
        }else{
            Log.e("AAA","not contain");
        }

        buttonToCW3 = findViewById(R.id.to_cw3);
        buttonToCW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CW2Activity.this,CW3Activity.class);
                startActivity(intent);
            }
        });


        buttonToCW4 =findViewById(R.id.to_cw4);
        buttonToCW4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CW2Activity.this,CW4Activity.class);
                startActivity(intent);

            }
        });

        buttonToCW5 = findViewById(R.id.to_cw5);
        buttonToCW5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CW2Activity.this,CW5Activity.class);
                startActivity(intent);
            }
        });

        buttonToCW6 = findViewById(R.id.to_cw6);
        buttonToCW6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CW2Activity.this,CW6Activity.class);
                startActivity(intent);
            }
        });

        buttonToCW7 = findViewById(R.id.to_cw7);
        buttonToCW7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CW2Activity.this,CW7Activity.class);
                startActivity(intent);
            }
        });

        buttonToCW8 = findViewById(R.id.to_cw8);
        buttonToCW8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CW2Activity.this,CW8Activity.class);
                startActivity(intent);
            }
        });

        buttonToCW9 = findViewById(R.id.to_cw9);
        buttonToCW9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CW2Activity.this,CW9Activity.class);
                startActivity(intent);
            }
        });


    }
}
