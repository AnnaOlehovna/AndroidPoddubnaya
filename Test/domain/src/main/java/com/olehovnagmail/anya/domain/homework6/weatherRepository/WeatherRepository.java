package com.olehovnagmail.anya.domain.homework6.weatherRepository;




import com.olehovnagmail.anya.domain.homework6.weatherEntity.RootEntity;

import java.io.File;

import io.reactivex.Observable;

public interface WeatherRepository {

    Observable<File> downloadFile(String url);
    Observable<RootEntity> parsingFile(File file);
}
