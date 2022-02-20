package com.example.test.singnUp.presenter;

import com.example.test.AsyncCallBackI;
import com.example.test.model.User;

public interface SignUpPresenterI {
    public void signUp(User user, AsyncCallBackI asyncCallBack);
}
