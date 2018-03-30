package com.olehovnagmail.anya.presentation.screens.homework3;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.olehovnagmail.anya.BuildConfig;
import com.olehovnagmail.anya.presentation.base.BaseViewModel;

public class HW3ViewModel extends BaseViewModel implements View.OnClickListener {

    public ObservableField<String> text = new ObservableField<>(BuildConfig.API_ENDPOINT);
    public ObservableField<String> textFromEdittext = new ObservableField<>();
    public ObservableField<String> urlImage = new ObservableField<>();


    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }

    @Override
    public void createInject() {

    }

    @Override
    public void onClick(View v) {
        urlImage.set(textFromEdittext.get());
    }


}
