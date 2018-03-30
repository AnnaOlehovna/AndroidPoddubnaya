package com.olehovnagmail.anya.domain.executor;


import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class UIThread implements PostExecutionThread {

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
