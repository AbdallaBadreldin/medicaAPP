package eg.iti.pillsmanager.singnIn.presenter;



import eg.iti.pillsmanager.AsyncCallBackI;

public interface SignInpresenterI {

    public void signIn(String email, String password, AsyncCallBackI asyncCallBackI);

}
