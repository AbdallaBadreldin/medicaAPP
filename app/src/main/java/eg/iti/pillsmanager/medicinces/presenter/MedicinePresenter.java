package eg.iti.pillsmanager.medicinces.presenter;

import androidx.lifecycle.LifecycleOwner;

import java.util.List;

import eg.iti.pillsmanager.medicinces.view.MedicineViewInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;

public class MedicinePresenter implements MedicinePresenterInterface{
    MedicineViewInterface medicineViewInterface;
    Repository repository;

    public MedicinePresenter(MedicineViewInterface medicineViewInterface, Repository repository) {
        this.medicineViewInterface = medicineViewInterface;
        this.repository = repository;
    }

    @Override
    public void getActiveMedication(LifecycleOwner owner) {
//        medicineViewInterface.showData((List<Medicine>) repository.getAllMedicine(owner));
    }

    @Override
    public void getInActiveMedication(LifecycleOwner owner) {

    }
}
