package com.olehovnagmail.anya.domain.interactors;


import com.olehovnagmail.anya.domain.entity.UserEntity;
import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class SaveUserUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public SaveUserUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }


    public Completable save(UserEntity userEntity) {
       return userRepository.save(userEntity).
                subscribeOn(threadExecution)
                .observeOn(postExecutionThread);

    }
}
