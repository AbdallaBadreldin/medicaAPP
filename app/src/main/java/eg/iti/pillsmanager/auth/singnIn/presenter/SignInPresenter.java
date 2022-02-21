package eg.iti.pillsmanager.auth.singnIn.presenter;

import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.network.Authentication;

public class SignInPresenter implements SignInpresenterI {
    Authentication authentication;

   public SignInPresenter(){
        authentication = Authentication.getInstance();
    }

    @Override
    public void signIn(String email, String password, AuthAsyncCallBackI authAsyncCallBackI) {
        authentication.signIn(email, password, authAsyncCallBackI);
    }
}
