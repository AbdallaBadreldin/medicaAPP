package com.example.test.forgetPassword.presenter;

import com.example.test.AsyncCallBackI;
import com.example.test.model.Repository;

public class ForgetPasswordPresenter implements ForgetPasswordPresenterI{
    Repository repository;

    public ForgetPasswordPresenter() {
        repository = Repository.getInstance();
    }

    @Override
    public void resetPassword(AsyncCallBackI asyncCallBack, String email) {
        repository.resetPassword(asyncCallBack, email);
    }
}
