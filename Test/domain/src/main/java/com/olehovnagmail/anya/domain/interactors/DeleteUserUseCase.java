package com.olehovnagmail.anya.domain.interactors;


import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteUserUseCase extends BaseUseCase {
    private UserRepository userRepository;

    @Inject
    public DeleteUserUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Completable remove(String id) {
        return userRepository.remove(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
