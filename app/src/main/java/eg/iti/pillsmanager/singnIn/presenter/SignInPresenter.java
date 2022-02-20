package eg.iti.pillsmanager.singnIn.presenter;

import eg.iti.pillsmanager.AsyncCallBackI;
import eg.iti.pillsmanager.model.Repository;

public class SignInPresenter implements SignInpresenterI {
    Repository repository;

   public SignInPresenter(){
        repository = Repository.getInstance();
    }

    @Override
    public void signIn(String email, String password, AsyncCallBackI asyncCallBackI) {
        repository.signIn(email, password, asyncCallBackI);
    }
}
