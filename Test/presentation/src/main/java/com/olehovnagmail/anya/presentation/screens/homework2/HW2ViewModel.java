package com.olehovnagmail.anya.presentation.screens.homework2;

import android.databinding.ObservableField;

import com.olehovnagmail.anya.presentation.base.BaseViewModel;

public class HW2ViewModel extends BaseViewModel {

    public ObservableField<String> austria = new ObservableField<>("Австрия");
    public ObservableField<String> poland = new ObservableField<>("Польша");
    public ObservableField<String> italy = new ObservableField<>("Италия");
    public ObservableField<String> colombia = new ObservableField<>("Колумбия");
    public ObservableField<String> madagaskar = new ObservableField<>("Мадагаскар");
    public ObservableField<String> thailand = new ObservableField<>("Таиланд");
    public ObservableField<String> denmark = new ObservableField<>("Дания");

    @Override
    public void createInject() {

    }
}
