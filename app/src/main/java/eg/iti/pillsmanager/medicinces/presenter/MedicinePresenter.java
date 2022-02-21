package eg.iti.pillsmanager.medicinces.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.iti.pillsmanager.medicinces.view.AllMedicineViewInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;

public class MedicinePresenter implements MedicinePresenterInterface {

    AllMedicineViewInterface allMedicineViewInterface;
    Repository repository;

    public MedicinePresenter(AllMedicineViewInterface allMedicineViewInterface, Repository repository) {
        this.allMedicineViewInterface = allMedicineViewInterface;
        this.repository = repository;
    }

    @Override
    public void getActiveMedication(LifecycleOwner owner) {
        repository.getStoredActiveMedicines().observe(owner, new Observer<List<Medicine>>() {
            @Override
            public void onChanged(List<Medicine> movies) {
                allMedicineViewInterface.showActiveMedicines(movies);
            }
        });
    }

    @Override
    public void getInactiveMedication(LifecycleOwner owner) {
        repository.getStoredInactiveMedicines().observe(owner, new Observer<List<Medicine>>() {
            @Override
            public void onChanged(List<Medicine> movies) {
                allMedicineViewInterface.showInactiveMedicines(movies);
            }
        });
    }

    @Override
    public void addMedicineToDataBase(Medicine medicine) {
        repository.insertMedicine(medicine);
    }
}
