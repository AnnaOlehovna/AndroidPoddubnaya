package com.olehovnagmail.anya.domain.homework6.weatherUsecase;


import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.homework6.weatherEntity.RootEntity;
import com.olehovnagmail.anya.domain.homework6.weatherRepository.WeatherRepository;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ParsingUseCase extends BaseWeatherUseCase{

    private WeatherRepository repository;

    @Inject
    public ParsingUseCase(PostExecutionThread postExecutionThread, WeatherRepository weatherRepository) {
        super(postExecutionThread);
        this.repository = weatherRepository;
    }

    public Observable<RootEntity> parsingFile(File file){
        return repository.parsingFile(file)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
