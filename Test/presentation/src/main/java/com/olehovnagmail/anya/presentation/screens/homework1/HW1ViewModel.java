package com.olehovnagmail.anya.presentation.screens.homework1;

import android.databinding.ObservableField;
import android.view.View;

import com.olehovnagmail.anya.presentation.base.BaseViewModel;

public class HW1ViewModel extends BaseViewModel implements View.OnClickListener{

    public ObservableField<String> textView1 = new ObservableField<>("text 1");
    public ObservableField<String> textView2 = new ObservableField<>("text 2");

    public HW1ViewModel() {
    }

    @Override
    public void createInject() {

    }


    @Override
    public void onClick(View v) {
        String temp = textView1.get();
        textView1.set(textView2.get());
        textView2.set(temp);
    }
}
