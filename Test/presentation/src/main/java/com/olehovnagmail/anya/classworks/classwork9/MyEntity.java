package com.olehovnagmail.anya.classworks.classwork9;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

public class MyEntity {

    public ObservableField<String> text = new ObservableField<>("this is TEXTVIEW");
    public ObservableField<String> textButton = new ObservableField<>("this is TEXTBUTTON");
    public ObservableBoolean buttonVisible = new ObservableBoolean(true);

    public MyEntity() {
    }

    public void buttonClick(View view) {
        Log.e("myEntity", "Button click");
        buttonVisible.set(false);
        this.text.set("button has gone");
    }
}
