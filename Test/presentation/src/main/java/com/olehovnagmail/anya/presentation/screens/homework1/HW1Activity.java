package com.olehovnagmail.anya.presentation.screens.homework1;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ActivityHw1Binding;
import com.olehovnagmail.anya.presentation.base.BaseMvvmActivity;



public class HW1Activity extends BaseMvvmActivity<ActivityHw1Binding,HW1ViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw1;
    }

    @Override
    public HW1ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(HW1ViewModel.class);
    }

}
