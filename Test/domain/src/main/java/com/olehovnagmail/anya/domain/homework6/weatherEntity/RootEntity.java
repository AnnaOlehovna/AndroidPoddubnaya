package com.olehovnagmail.anya.domain.homework6.weatherEntity;

import java.util.List;

public class RootEntity {

    private String name;
    private String date;


    private List<WeatherEntity> weatherList;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherEntity> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<WeatherEntity> weatherList) {
        this.weatherList = weatherList;
    }

}

