package com.olehovnagmail.anya.domain.homework6.weatherUsecase;




import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.homework6.weatherRepository.WeatherRepository;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DownloadFileUseCase extends BaseWeatherUseCase {


    private WeatherRepository weatherRepository;

    @Inject
    public DownloadFileUseCase(PostExecutionThread postExecutionThread, WeatherRepository weatherRepository) {
        super(postExecutionThread);
        this.weatherRepository = weatherRepository;
    }

    public Observable<File> downloadFile(String url){
        return weatherRepository.downloadFile(url)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
