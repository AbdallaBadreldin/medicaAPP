package com.example.test.singnUp.presenter;

import com.example.test.AsyncCallBackI;
import com.example.test.model.Repository;
import com.example.test.model.User;

public class SignUpPresenter implements SignUpPresenterI{
    Repository repository;

    public SignUpPresenter() {
        repository = Repository.getInstance();
    }

    @Override
    public void signUp(User user, AsyncCallBackI asyncCallBack) {
        repository.signUp(user, asyncCallBack);
    }
}
