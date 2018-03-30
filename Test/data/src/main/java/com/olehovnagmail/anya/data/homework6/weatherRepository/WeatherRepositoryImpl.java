package com.olehovnagmail.anya.data.homework6.weatherRepository;

import android.content.Context;

import com.olehovnagmail.anya.data.homework6.parsing.ParseJSON;
import com.olehovnagmail.anya.data.homework6.parsing.ParseXML;
import com.olehovnagmail.anya.data.homework6.parsing.Parsing;


import com.olehovnagmail.anya.data.homework6.weatherEntity.City;
import com.olehovnagmail.anya.data.homework6.weatherEntity.Root;
import com.olehovnagmail.anya.data.homework6.weatherEntity.Weather;
import com.olehovnagmail.anya.data.rest.RestService;
import com.olehovnagmail.anya.domain.homework6.convertDate.ConvertDateToString;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.CityEntity;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.RootEntity;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.WeatherEntity;
import com.olehovnagmail.anya.domain.homework6.weatherRepository.WeatherRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepositoryImpl implements WeatherRepository {

    private Context context;
    private RestService restService;


    private Parsing parsing;

    private ConvertDateToString convertDateToString = new ConvertDateToString();


    public WeatherRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<File> downloadFile(String url) {
        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        String filePath = "";
        if (url.endsWith(".xml")) {
            filePath = "weather.xml";
        } else if (url.endsWith(".json")) {
            filePath = "weather.json";
        }
        final File file = new File(context.getFilesDir(), filePath);

        restService.downloadFile(url).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream inputStream = null;
                FileOutputStream fileOutputStream = null;
                try {
                    int byteRead = -1;
                    byte[] buffer = new byte[2048];
                    inputStream = response.body().byteStream();
                    fileOutputStream = new FileOutputStream(file);
                    while ((byteRead = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, byteRead);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null && fileOutputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        return new Observable<File>() {
            @Override
            protected void subscribeActual(Observer<? super File> observer) {
                observer.onNext(file);
            }
        };

    }


    @Override
    public Observable<RootEntity> parsingFile(File file) {
        if (file.getAbsolutePath().contains(".xml")) {
            parsing = new ParseXML();
        } else if (file.getAbsolutePath().contains(".json")) {
            parsing = new ParseJSON();
        }
        return parsing.parsingFile(file)
                .map(new Function<Root, RootEntity>() {
                    @Override
                    public RootEntity apply(Root root) throws Exception {
                        RootEntity rootEntity = new RootEntity();
                        rootEntity.setName(root.getName());
                        rootEntity.setDate(convertDateToString.convertDateToString(root.getDate()));
                        List<WeatherEntity> weatherEntityList = new ArrayList<>();
                        for (Weather weather : root.getWeatherList()) {
                            WeatherEntity weatherEntity = new WeatherEntity();
                            weatherEntity.setTitle(weather.getTitle());
                            weatherEntity.setDescription(weather.getDescription());
                            weatherEntity.setDate(convertDateToString.convertDateToString(weather.getDate()));
                            weatherEntity.setId(weather.getId());
                            weatherEntity.setHumidity(weather.getHumidity());
                            weatherEntity.setTempMin(weather.getTempMin());
                            weatherEntity.setTempMax(weather.getTempMax());
                            HashMap<String, List<CityEntity>> hashMap = new HashMap<>();
                            for (HashMap.Entry<String, List<City>> entry : weather.getLocation().entrySet()) {
                                List<CityEntity> list = new ArrayList<>();
                                for (City city : entry.getValue()) {
                                    CityEntity cityEntity = new CityEntity();
                                    cityEntity.setName(city.getName());
                                    list.add(cityEntity);
                                }
                                hashMap.put(entry.getKey(), list);
                            }
                            weatherEntity.setLocation(hashMap);

                            weatherEntityList.add(weatherEntity);
                        }
                        rootEntity.setWeatherList(weatherEntityList);
                        return rootEntity;
                    }
                });
    }

}

