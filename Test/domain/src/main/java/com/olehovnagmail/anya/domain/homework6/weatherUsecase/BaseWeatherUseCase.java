package com.olehovnagmail.anya.domain.homework6.weatherUsecase;

import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.executor.ThreadExecution;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public abstract class BaseWeatherUseCase {
    //поток, в котором будем получать результат в presentation слое
    protected Scheduler postExecutionThread;

    //поток, в котором будем выполнять сами запросы и операции(другой поток, не UI)

    protected Scheduler threadExecution;

    public BaseWeatherUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseWeatherUseCase(PostExecutionThread postExecutionThread, ThreadExecution threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
