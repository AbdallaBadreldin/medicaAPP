package eg.iti.pillsmanager.pickdependent.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.User;
import eg.iti.pillsmanager.pickdependent.view.PickDependentInterface;

public class PickDependetPresenter implements PickDependentPresenterInterface{
    PickDependentInterface pickDependentInterface;
    Repository repository;

    public PickDependetPresenter(PickDependentInterface pickDependentInterface, Repository repository) {
        this.pickDependentInterface = pickDependentInterface;
        this.repository = repository;
    }

    @Override
    public void getAllUsers(LifecycleOwner owner) {
        repository.getStoredUsers().observe(owner, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                pickDependentInterface.showList(users);
            }
        });
    }
}
