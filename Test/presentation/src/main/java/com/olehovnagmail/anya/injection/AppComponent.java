package com.olehovnagmail.anya.injection;

import com.olehovnagmail.anya.presentation.screens.homework6.WeatherViewModel;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(

        modules = {AppModule.class}
)

public interface AppComponent {


    void inject(WeatherViewModel weatherViewModel);

}
