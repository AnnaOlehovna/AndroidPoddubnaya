package com.olehovnagmail.anya.presentation.screens.homework6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.olehovnagmail.anya.R;

public class HW6ActivityOne extends AppCompatActivity {

    private final String LINK_XML = "http://kiparo.ru/t/weather.xml";
    private final String LINK_JSON = "http://kiparo.ru/t/weather.json";

    private Button buttonXML;
    private Button buttonJSON;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw6_one);

        buttonXML = findViewById(R.id.parse_xml);
        buttonXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HW6ActivityOne.this,HW6ActivityTwo.class);
                intent.putExtra("KEY_LINK",LINK_XML);
                startActivity(intent);
            }
        });


        buttonJSON = findViewById(R.id.parse_json);
        buttonJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HW6ActivityOne.this,HW6ActivityTwo.class);
                intent.putExtra("KEY_LINK",LINK_JSON);
                startActivity(intent);
            }
        });
    }
}
