package com.olehovnagmail.anya.presentation.screens.homework2;

import android.arch.lifecycle.ViewModelProviders;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ActivityHw2Binding;
import com.olehovnagmail.anya.presentation.base.BaseMvvmActivity;


public class HW2Activity extends BaseMvvmActivity<ActivityHw2Binding,HW2ViewModel> {
    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw2;
    }

    @Override
    public HW2ViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(HW2ViewModel.class);
    }
}
