package eg.iti.pillsmanager.medicinces.presenter;

import androidx.lifecycle.LifecycleOwner;

import eg.iti.pillsmanager.model.Medicine;

public interface MedicinePresenterInterface {
    void getActiveMedication(LifecycleOwner owner);
    void getInactiveMedication(LifecycleOwner owner);
    void addMedicineToDataBase(Medicine medicine);
}
