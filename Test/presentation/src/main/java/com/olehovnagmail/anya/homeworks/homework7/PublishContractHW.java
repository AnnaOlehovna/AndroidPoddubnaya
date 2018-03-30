package com.olehovnagmail.anya.homeworks.homework7;

import io.reactivex.subjects.PublishSubject;

public interface PublishContractHW {

    PublishSubject<Integer> getPublishSubject();
}
