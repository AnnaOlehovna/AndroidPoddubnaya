package com.olehovnagmail.anya.domain.interactors;


import com.olehovnagmail.anya.domain.entity.UserEntity;
import com.olehovnagmail.anya.domain.executor.PostExecutionThread;
import com.olehovnagmail.anya.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetUserListUseCase extends BaseUseCase {

    private UserRepository userRepository;

    @Inject
    public GetUserListUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(postExecutionThread);
        this.userRepository = userRepository;
    }

    public Observable<List<UserEntity>> get() {
        return userRepository.get()
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
