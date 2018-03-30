package com.olehovnagmail.anya.classworks.classwork9;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ActivityCw9Binding;


public class CW9Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyEntity myEntity = new MyEntity();
        ActivityCw9Binding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_cw9);

        binding.setMyEntity(myEntity);

    }

}
