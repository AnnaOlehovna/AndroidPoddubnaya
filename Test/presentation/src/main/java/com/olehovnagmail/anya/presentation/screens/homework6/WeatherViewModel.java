package com.olehovnagmail.anya.presentation.screens.homework6;


import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.olehovnagmail.anya.app.App;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.CityEntity;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.RootEntity;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.WeatherEntity;
import com.olehovnagmail.anya.domain.homework6.weatherUsecase.DownloadFileUseCase;
import com.olehovnagmail.anya.domain.homework6.weatherUsecase.ParsingUseCase;
import com.olehovnagmail.anya.presentation.base.BaseViewModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class WeatherViewModel extends BaseViewModel {

    public String link = "";

    public WeatherAdapter adapter = new WeatherAdapter();

    public ObservableField<String> centerName = new ObservableField<>();
    public ObservableBoolean progressBar = new ObservableBoolean(true);
    public ObservableField<String> text = new ObservableField<>();
    private List<WeatherEntity> weatherEntities = new ArrayList<>();

    @Inject
    public DownloadFileUseCase downloadFileUseCase;

    @Inject
    public ParsingUseCase parsingUseCase;

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        downloadFileUseCase.downloadFile(link)
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(File file) throws Exception {
                        parsingUseCase.parsingFile(file)
                                .subscribe(new Consumer<RootEntity>() {
                                    @Override
                                    public void accept(RootEntity rootEntity) throws Exception {
                                        progressBar.set(false);
                                        centerName.set(rootEntity.getName());
                                        weatherEntities = rootEntity.getWeatherList();
                                        adapter.setWeathers(weatherEntities);
                                    }
                                });
                    }
                });
    }

    public TextWatcher textWatcher = new TextWatcher() {
        Timer timer;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (timer != null) {
                timer.cancel();
            }
        }

        @Override

        public void afterTextChanged(Editable s) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    AndroidSchedulers.mainThread().scheduleDirect(new Runnable() {
                        @Override
                        public void run() {
                            String searchingCity = text.get();
                            if (searchingCity.equals("")) {
                                adapter.setWeathers(weatherEntities);
                            } else {
                                adapter.setWeathers(searchByCity(searchingCity));
                            }
                        }
                    });
                }
            }, 600);
        }
    };

    @BindingAdapter("android:textChangedListener")
    public static void bindTextWatcher(EditText editText, TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);

    }


    private List<WeatherEntity> searchByCity(String nameCity) {
        ArrayList<WeatherEntity> weatherForCity = new ArrayList<>();
        for (int i = 0; i < weatherEntities.size(); i++) {
            WeatherEntity weather = weatherEntities.get(i);
            for (HashMap.Entry<String, List<CityEntity>> entry : weather.getLocation().entrySet()) {
                for (CityEntity city : entry.getValue()) {
                    if (city.getName().toLowerCase().contains(nameCity.toLowerCase())) {
                        weatherForCity.add(weather);
                    }
                }
            }
        }
        return weatherForCity;
    }
}
