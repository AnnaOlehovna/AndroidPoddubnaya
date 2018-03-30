package com.olehovnagmail.anya.classworks.classwork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olehovnagmail.anya.R;

public class MyFragmentOne extends Fragment {

    public static MyFragmentOne getInstance(FragmentManager fragmentManager){

        MyFragmentOne myFragmentOne = (MyFragmentOne) fragmentManager.
                findFragmentByTag(MyFragmentOne.class.getSimpleName());
        if(myFragmentOne==null){
            myFragmentOne = new MyFragmentOne();
        }
        return  myFragmentOne;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //инициализация UI - кнопки, тексты, картинки и тд - то что делали в onCreate() в Activity
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
