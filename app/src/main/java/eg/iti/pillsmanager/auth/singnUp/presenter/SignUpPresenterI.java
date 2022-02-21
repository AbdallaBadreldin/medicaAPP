package eg.iti.pillsmanager.auth.singnUp.presenter;
import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.model.User;

public interface SignUpPresenterI {
    public void signUp(User user, AuthAsyncCallBackI asyncCallBack);
}
