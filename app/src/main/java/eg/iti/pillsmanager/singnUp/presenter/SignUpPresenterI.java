package eg.iti.pillsmanager.singnUp.presenter;
import eg.iti.pillsmanager.AsyncCallBackI;
import eg.iti.pillsmanager.model.User;

public interface SignUpPresenterI {
    public void signUp(User user, AsyncCallBackI asyncCallBack);
}
