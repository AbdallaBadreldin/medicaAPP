package eg.iti.pillsmanager.auth.resetPassword.presenter;

import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.network.Authentication;

public class ResetPasswordPresenter implements ResetPasswordPresenterI {
    Authentication authentication;

    public ResetPasswordPresenter() {
        authentication = Authentication.getInstance();
    }

    @Override
    public void resetPassword(AuthAsyncCallBackI asyncCallBack, String email) {
        authentication.resetPassword(asyncCallBack, email);
    }
}
