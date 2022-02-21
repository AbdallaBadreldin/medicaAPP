package eg.iti.pillsmanager.auth.singnIn.presenter;



import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;

public interface SignInpresenterI {

    public void signIn(String email, String password, AuthAsyncCallBackI authAsyncCallBackI);

}
