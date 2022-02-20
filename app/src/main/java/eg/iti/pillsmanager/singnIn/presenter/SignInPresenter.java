package com.example.test.singnIn.presenter;

import com.example.test.AsyncCallBackI;
import com.example.test.model.Repository;

public class SignInPresenter implements SignInpresenterI {
    Repository repository;

   public SignInPresenter(){
        repository = Repository.getInstance();
    }

    @Override
    public void signIn(String email, String password, AsyncCallBackI asyncCallBackI) {
        repository.signIn(email, password, asyncCallBackI);
    }



}
