package eg.iti.pillsmanager.singnIn.presenter;

import com.google.firebase.database.core.Context;

import eg.iti.pillsmanager.AsyncCallBackI;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.model.Repository;

public class SignInPresenter implements SignInpresenterI {
    Repository repository;
    LocalSource localSource;
    Context context;

   public SignInPresenter(){
        //repository = Repository.getInstance(localSource,context);
    }

    @Override
    public void signIn(String email, String password, AsyncCallBackI asyncCallBackI) {
        repository.signIn(email, password, asyncCallBackI);
    }
}
