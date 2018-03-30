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

public class MyFragmentTwo extends Fragment {

    private static final String KEY_VALUE = "VALUE_KEY";

    public static MyFragmentTwo getInstance(FragmentManager fragmentManager, int value){


        MyFragmentTwo myFragmentTwo = (MyFragmentTwo) fragmentManager.
                 findFragmentByTag(MyFragmentTwo.class.getSimpleName());
        if(myFragmentTwo==null){
            myFragmentTwo = new MyFragmentTwo();
        }

        //чтобы красиво передать какие-то данные фрагменту, например int
        //а потом в методе onViewCreated их вытянуть
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VALUE,value);
        myFragmentTwo.setArguments(bundle);

        return  myFragmentTwo;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_two,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            int value = bundle.getInt(KEY_VALUE);
        }
        //инициализация UI - кнопки, тексты, картинки и тд - то что делали в onCreate() в Activity
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
