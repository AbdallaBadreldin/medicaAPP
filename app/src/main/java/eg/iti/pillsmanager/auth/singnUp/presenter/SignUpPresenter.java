package eg.iti.pillsmanager.auth.singnUp.presenter;
import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.model.Authentication;
import eg.iti.pillsmanager.model.User;

public class SignUpPresenter implements SignUpPresenterI{
    Authentication authentication;

    public SignUpPresenter() {
        authentication = Authentication.getInstance();
    }

    @Override
    public void signUp(User user, AuthAsyncCallBackI asyncCallBack) {
        authentication.signUp(user, asyncCallBack);
    }
}
