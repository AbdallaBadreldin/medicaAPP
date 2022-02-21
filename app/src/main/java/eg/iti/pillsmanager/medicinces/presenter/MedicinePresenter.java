package eg.iti.pillsmanager.medicinces.presenter;

import eg.iti.pillsmanager.medicinces.view.MedicineViewInterface;
import eg.iti.pillsmanager.model.Repository;

public class MedicinePresenter implements MedicinePresenterInterface{
    MedicineViewInterface medicineViewInterface;
    Repository repository;

    public MedicinePresenter(MedicineViewInterface medicineViewInterface, Repository repository) {
        this.medicineViewInterface = medicineViewInterface;
        this.repository = repository;
    }

    @Override
    public void getActiveMedication() {

    }

    @Override
    public void getInActiveMedication() {

    }
}
