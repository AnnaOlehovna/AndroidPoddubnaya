package com.olehovnagmail.anya.presentation.screens.homework6;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.databinding.ItemWeatherBinding;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.WeatherEntity;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {

    private List<WeatherEntity> weathers = new ArrayList<>();

    public void setWeathers(List<WeatherEntity> weathers) {
        this.weathers = weathers;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemWeatherBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_weather, parent, false);
        return new MyHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.binding.getViewModel().setWeatherEntity(weathers.get(position));

    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        ItemWeatherBinding binding;

        public MyHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.setViewModel(new WeatherItemViewModel());
        }
    }
}
