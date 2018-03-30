package com.olehovnagmail.anya.domain.interactors;


import com.olehovnagmail.anya.domain.entity.UserEntity;
import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserByIdUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetUserByIdUseCase(PostExecutionThread postExecutionThread,
                              UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    //по идее должен быть один публичный метод, который выполняет одну функцию
    public Observable<UserEntity> get(String id) {
        return userRepository.get(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);

    }


}
