package com.example.test.singnIn.presenter;

import com.example.test.AsyncCallBackI;

public interface SignInpresenterI {

    public void signIn(String email, String password, AsyncCallBackI asyncCallBackI);

}
