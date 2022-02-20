package eg.iti.pillsmanager.model;

import eg.iti.pillsmanager.AsyncCallBackI;

public interface RepositoryI {

    public void signIn(String email, String password, AsyncCallBackI asyncCallBack);
    public void signUp(User user, AsyncCallBackI asyncCallBack);
    public void resetPassword(AsyncCallBackI asyncCallBack, String email);
    public void signOut(AsyncCallBackI asyncCallBack);

}
