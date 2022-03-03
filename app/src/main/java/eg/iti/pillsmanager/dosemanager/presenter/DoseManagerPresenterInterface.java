package eg.iti.pillsmanager.dosemanager.presenter;

import androidx.lifecycle.LifecycleOwner;

import eg.iti.pillsmanager.model.Dose;

public interface DoseManagerPresenterInterface {
    void getAllDoses(LifecycleOwner owner);
    void getDosesByMedicine(String email,String medicine,LifecycleOwner owner );
    void insertDose(Dose dose);
}
