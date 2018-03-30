package com.olehovnagmail.anya.domain.interactors;

import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.executor.ThreadExecution;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {

    //поток, в котором будем получать результат в presentation слое
    protected Scheduler postExecutionThread;

    //поток, в котором будем выполнять сами запросы и операции(другой поток, не UI)

    protected Scheduler threadExecution;

    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecution threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
