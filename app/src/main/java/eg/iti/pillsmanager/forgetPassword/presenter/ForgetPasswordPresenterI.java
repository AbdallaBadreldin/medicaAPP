package eg.iti.pillsmanager.forgetPassword.presenter;

import eg.iti.pillsmanager.AsyncCallBackI;

public interface ForgetPasswordPresenterI {
    public void resetPassword(AsyncCallBackI asyncCallBack, String email);
}
