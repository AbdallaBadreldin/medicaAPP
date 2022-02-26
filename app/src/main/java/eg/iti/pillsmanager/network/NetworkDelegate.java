package eg.iti.pillsmanager.network;


import java.util.ArrayList;

import eg.iti.pillsmanager.model.Medicine;

public interface NetworkDelegate {
    void onSuccessResult(ArrayList<Medicine> medicines);
    void onFailureResult(String errorMessage);
}
