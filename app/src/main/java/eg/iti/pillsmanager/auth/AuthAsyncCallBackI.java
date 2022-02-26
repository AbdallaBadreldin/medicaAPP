package eg.iti.pillsmanager.auth;

public interface AuthAsyncCallBackI {
    public void onSuccess(String actionType);
    public void onFailure(String erorrMessage);
}
