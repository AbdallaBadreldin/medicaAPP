package eg.iti.pillsmanager.auth.resetPassword.presenter;

import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;

public interface ResetPasswordPresenterI {
    public void resetPassword(AuthAsyncCallBackI asyncCallBack, String email);
}
