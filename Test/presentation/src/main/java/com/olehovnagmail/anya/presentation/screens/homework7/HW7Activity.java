package com.olehovnagmail.anya.presentation.screens.homework7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.olehovnagmail.anya.R;

import io.reactivex.subjects.PublishSubject;

public class HW7Activity extends AppCompatActivity implements PublishContractHW {


    private int counter = 0;
    private PublishSubject<Integer> publishSubject = PublishSubject.create();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw7);

        findViewById(R.id.change_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                publishSubject.onNext(counter);
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_contain, FragmentHW7One.getInstance());
        transaction.commit();

    }

    @Override
    public PublishSubject<Integer> getPublishSubject() {
        return publishSubject;
    }
}
