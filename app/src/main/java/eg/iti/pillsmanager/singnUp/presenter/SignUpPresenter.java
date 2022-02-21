package eg.iti.pillsmanager.singnUp.presenter;
import eg.iti.pillsmanager.AsyncCallBackI;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.User;

public class SignUpPresenter implements SignUpPresenterI{
    Repository repository;

    public SignUpPresenter() {
        //repository = Repository.getInstance();
    }

    @Override
    public void signUp(User user, AsyncCallBackI asyncCallBack) {
        repository.signUp(user, asyncCallBack);
    }
}
