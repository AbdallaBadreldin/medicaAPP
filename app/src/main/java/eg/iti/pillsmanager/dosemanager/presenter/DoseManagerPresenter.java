package eg.iti.pillsmanager.dosemanager.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.iti.pillsmanager.dosemanager.view.DoseManagerInterface;
import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.Repository;

public class DoseManagerPresenter implements DoseManagerPresenterInterface{

    DoseManagerInterface doseManagerInterface;
    Repository repository;

    public DoseManagerPresenter(DoseManagerInterface doseManagerInterface, Repository repository) {
        this.doseManagerInterface = doseManagerInterface;
        this.repository = repository;
    }

    @Override
    public void getAllDoses(LifecycleOwner owner) {
        repository.getAllDoses().observe(owner, new Observer<List<Dose>>() {
            @Override
            public void onChanged(List<Dose> doses) {
                doseManagerInterface.updateRecycler(doses);
            }
        });
    }

    @Override
    public void getDosesByMedicine(String email, String medicine, LifecycleOwner owner) {
        repository.getDosesByMedicine(email,medicine).observe(owner, new Observer<List<Dose>>() {
            @Override
            public void onChanged(List<Dose> doses) {
                doseManagerInterface.updateRecycler(doses);
            }
        });
    }

    @Override
    public void insertDose(Dose dose) {
        repository.insertDose(dose);
    }


}