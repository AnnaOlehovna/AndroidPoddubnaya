package com.olehovnagmail.anya.data.homework6.weatherEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Weather {

    private int id;
    private String title;
    private String description;
    private Date date;
    private int tempMin;
    private int tempMax;
    private int humidity;

    private HashMap<String, List<City>> location;

    public Weather() {
    }

    public Weather(Date date, String description, int humidity, int id, HashMap<String, List<City>> location, int tempMax, int tempMin, String title) {
        this.date = date;
        this.description = description;
        this.humidity = humidity;
        this.id = id;
        this.location = location;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String, List<City>> getLocation() {
        return location;
    }

    public void setLocation(HashMap<String, List<City>> location) {
        this.location = location;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
