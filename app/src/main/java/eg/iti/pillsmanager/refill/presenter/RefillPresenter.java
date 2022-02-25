package eg.iti.pillsmanager.refill.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.iti.pillsmanager.medicinces.view.AllMedicineViewInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.refill.view.RefillFragmentInterface;

public class RefillPresenter implements RefillPresenterInterface {

    RefillFragmentInterface refillFragmentInterface;
    Repository repository;

    public RefillPresenter(RefillFragmentInterface refillFragmentInterface, Repository repository) {
        this.refillFragmentInterface = refillFragmentInterface;
        this.repository = repository;
    }

    @Override
    public void getActiveMedication(LifecycleOwner owner) {
        repository.getStoredActiveMedicines().observe(owner, new Observer<List<Medicine>>() {
            @Override
            public void onChanged(List<Medicine> medicines) {
                refillFragmentInterface.showList(medicines);
            }
        });
    }

    @Override
    public void updateRefillActiveStatue(Medicine medicine) {
    repository.updateMedicine(medicine);
    }

}
