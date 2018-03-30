package com.olehovnagmail.anya.classworks.classwork8;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.olehovnagmail.anya.R;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class CW8Activity extends AppCompatActivity implements ObservableContractCW {


    private int counter = 0;
    private BehaviorSubject<Integer> subject = BehaviorSubject.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw7);


        findViewById(R.id.change_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                subject.onNext(counter);

            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_contain, FragmentCW8.getInstance());
        transaction.commit();
    }

    @Override
    public Observable<Integer> getObservable() {
        return subject;
    }
}
