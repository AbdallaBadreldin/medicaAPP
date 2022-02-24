package eg.iti.pillsmanager.adddependent.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.iti.pillsmanager.adddependent.view.AddDependentInterface;
import eg.iti.pillsmanager.medicinces.view.AllMedicineViewInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.User;

public class AddDependentPresenter implements AddDependentPresenterInterface{
    AddDependentInterface addDependentInterface;
    Repository repository;

    public AddDependentPresenter(AddDependentInterface addDependentInterface, Repository repository) {
        this.addDependentInterface = addDependentInterface;
        this.repository = repository;
    }

    @Override
    public void addUserToDataBase(User user) {
        repository.insetUser(user);
        addDependentInterface.showFeedBack();
    }
}
