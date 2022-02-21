package eg.iti.pillsmanager.model;

import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;

public interface AuthenticationI {

    public void signIn(String email, String password, AuthAsyncCallBackI asyncCallBack);
    public void signUp(User user, AuthAsyncCallBackI asyncCallBack);
    public void resetPassword(AuthAsyncCallBackI asyncCallBack, String email);
    public void signOut(AuthAsyncCallBackI asyncCallBack);

}
