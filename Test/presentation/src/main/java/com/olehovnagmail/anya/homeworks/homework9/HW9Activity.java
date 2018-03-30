package com.olehovnagmail.anya.homeworks.homework9;


import com.olehovnagmail.anya.R;

import com.olehovnagmail.anya.databinding.ActivityHw9Binding;
import com.olehovnagmail.anya.presentation.base.BaseMvvmActivity;

public class HW9Activity extends BaseMvvmActivity<ActivityHw9Binding,UserHWViewModel>{

    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw9;
    }

    @Override
    public UserHWViewModel provideViewModel() {
        return new UserHWViewModel();
    }
}
