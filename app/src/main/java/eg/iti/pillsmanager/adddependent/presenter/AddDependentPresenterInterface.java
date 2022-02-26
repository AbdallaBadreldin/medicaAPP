package eg.iti.pillsmanager.adddependent.presenter;

import androidx.lifecycle.LifecycleOwner;

import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.User;

public interface AddDependentPresenterInterface {
    void addUserToDataBase(User user);
}
