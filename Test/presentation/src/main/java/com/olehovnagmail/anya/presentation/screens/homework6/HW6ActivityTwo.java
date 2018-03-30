package com.olehovnagmail.anya.presentation.screens.homework6;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ActivityHw6TwoBinding;
import com.olehovnagmail.anya.presentation.base.BaseMvvmActivity;

public class HW6ActivityTwo extends BaseMvvmActivity<ActivityHw6TwoBinding,WeatherViewModel> {


    @Override
    public int provideLayoutId() {
        return R.layout.activity_hw6_two;
    }

    @Override
    public WeatherViewModel provideViewModel() {
        WeatherViewModel viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        viewModel.link = getIntent().getStringExtra("KEY_LINK");
        return viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = findViewById(R.id.recycler_hw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(viewModel.adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }
}