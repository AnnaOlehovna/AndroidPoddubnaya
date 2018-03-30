package com.olehovnagmail.anya.data.homework6.weatherEntity;



import java.util.Date;
import java.util.List;

public class Root {

    private String name;
    private Date date;


    private List<Weather> weatherList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

}

