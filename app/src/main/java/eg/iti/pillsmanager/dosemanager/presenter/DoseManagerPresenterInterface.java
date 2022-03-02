package eg.iti.pillsmanager.dosemanager.presenter;

import androidx.lifecycle.LifecycleOwner;

public interface DoseManagerPresenterInterface {
    void getAllDoses(LifecycleOwner owner);
    void getDosesByMedicine(String email, String user,String medicine,LifecycleOwner owner );
}
