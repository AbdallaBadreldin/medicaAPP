package eg.iti.pillsmanager;

public interface AsyncCallBackI {
    public void onSuccess(String actionType);
    public void onFailure(String erorrMessage);
}
