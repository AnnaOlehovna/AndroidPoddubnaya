package com.olehovnagmail.anya.homeworks.homework7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olehovnagmail.anya.R;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class FragmentHW7One extends Fragment {

    public TextView textView;
    private PublishContractHW publishContractHW;
    private Disposable disposable;

    public static FragmentHW7One getInstance(){
        return new FragmentHW7One();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_hw7_one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.counter_one);
    }

    @Override
    public void onResume() {
        super.onResume();
        subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(disposable!=null){
            disposable.dispose();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            publishContractHW =(PublishContractHW) activity;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        publishContractHW =null;
    }


    private void subscribe(){
        //здесь мы подписались на observable
        disposable = publishContractHW
                .getPublishSubject()
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        //сюда прилетают данные
                        textView.setText(string);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
