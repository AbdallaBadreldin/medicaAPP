package eg.iti.pillsmanager.refill.presenter;

import androidx.lifecycle.LifecycleOwner;

import eg.iti.pillsmanager.model.Medicine;

public interface RefillPresenterInterface {

    void getActiveMedication(LifecycleOwner owner);
    void updateRefillActiveStatue(Medicine medicine);

    }
