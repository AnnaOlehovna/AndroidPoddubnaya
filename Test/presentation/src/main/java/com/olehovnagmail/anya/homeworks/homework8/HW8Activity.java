package com.olehovnagmail.anya.homeworks.homework8;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.olehovnagmail.anya.R;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class HW8Activity extends AppCompatActivity {


    private TextView text;
    private Observable<Long> observable = Observable.interval(1,TimeUnit.SECONDS);
    private Disposable disposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw8);
        text = findViewById(R.id.text_hw8);
    }

    @Override
    protected void onResume() {
        super.onResume();

        disposable = observable
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong % 2 == 0;
                    }
                })
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return String.valueOf(aLong);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(s);
                            }
                        });

                    }
                });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(disposable!=null){
            disposable.dispose();
        }
    }
}
