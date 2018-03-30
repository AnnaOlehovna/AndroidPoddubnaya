package com.olehovnagmail.anya.presentation.screens.homework3;

import android.arch.lifecycle.ViewModelProviders;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ActivityHw3Binding;
import com.olehovnagmail.anya.presentation.base.BaseMvvmActivity;


public class HW3Activity extends BaseMvvmActivity<ActivityHw3Binding,HW3ViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw3;
    }

    @Override
    public HW3ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(HW3ViewModel.class);
    }


}
