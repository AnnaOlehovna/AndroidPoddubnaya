package com.olehovnagmail.anya.homeworks.homework6.entity;


import com.olehovnagmail.anya.homeworks.homework6.convertDate.ConvertDate;

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


    public String weatherListToString(){
        String weathers="";
        for (Weather wea : weatherList) {
            weathers=weathers.concat(wea.toString());
        }
        return weathers;
    }


    @Override
    public String toString() {
        ConvertDate convertDate = new ConvertDate();
        return  " \nНАЗВАНИЕ ЦЕНТРА: " + name  +
                "\nДАТА СОЗДАНИЕ ЦЕНТРА: " + convertDate.convertDateToString(date) +
                ", \n\t\t\tПОГОДА" + weatherListToString();
    }
}

