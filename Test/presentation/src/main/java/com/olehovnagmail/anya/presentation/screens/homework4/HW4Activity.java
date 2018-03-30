package com.olehovnagmail.anya.presentation.screens.homework4;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.olehovnagmail.anya.R;

public class HW4Activity extends AppCompatActivity {
    private  AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4);
        ImageView sova = findViewById(R.id.owl);
        animationDrawable= (AnimationDrawable) sova.getDrawable();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            animationDrawable.start();
        }

    }
}
