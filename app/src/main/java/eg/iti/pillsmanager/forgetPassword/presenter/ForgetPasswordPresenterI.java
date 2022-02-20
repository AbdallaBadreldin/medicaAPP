package com.example.test.forgetPassword.presenter;

import com.example.test.AsyncCallBackI;

public interface ForgetPasswordPresenterI {
    public void resetPassword(AsyncCallBackI asyncCallBack, String email);
}
