package com.olehovnagmail.anya.presentation.screens.homework6;


import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.olehovnagmail.anya.R;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.CityEntity;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.WeatherEntity;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class WeatherItemViewModel {

    PublishSubject<WeatherEntity> subject = PublishSubject.create();

    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> description = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();
    public ObservableField<String> location = new ObservableField<>();
    public ObservableField<String> minTemp = new ObservableField<>();
    public ObservableField<String> maxTemp = new ObservableField<>();
    public ObservableField<String> humidity = new ObservableField<>();

    public void setWeatherEntity(WeatherEntity weatherEntity) {
        subject.subscribe(new Consumer<WeatherEntity>() {
            @Override
            public void accept(WeatherEntity weatherEntity) throws Exception {
                title.set(weatherEntity.getTitle());
                description.set(weatherEntity.getDescription());
                date.set(weatherEntity.getDate());
                String locationString = "Country: ";
                for (String country : weatherEntity.getLocation().keySet()) {
                    locationString = locationString.concat(country);
                    for (CityEntity city:weatherEntity.getLocation().get(country) ) {
                        locationString = locationString.concat("\n\t"+city.getName());
                    }
                }
                location.set(locationString);
                minTemp.set("Min temperature: ".concat(String.valueOf(weatherEntity.getTempMin())));
                maxTemp.set("Max temperature: ".concat(String.valueOf(weatherEntity.getTempMax())));
                humidity.set("Humidity: ".concat(String.valueOf(weatherEntity.getHumidity())));
            }
        });
        subject.onNext(weatherEntity);
    }

    @BindingAdapter("android:src")
    public static void setImage(ImageView view, String title){
        switch (title.toLowerCase()) {
            case "sunny":
            case "clear":
                view.setImageResource(R.drawable.sunny);
                break;
            case "clouds":
                view.setImageResource(R.drawable.cloud);
                break;
            case "rain":
                view.setImageResource(R.drawable.rain);
                break;
            default:
                break;
        }
    }
}
