package eg.iti.pillsmanager.forgetPassword.presenter;

import eg.iti.pillsmanager.AsyncCallBackI;
import eg.iti.pillsmanager.model.Repository;

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
