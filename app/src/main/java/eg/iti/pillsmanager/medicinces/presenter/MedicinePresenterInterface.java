package eg.iti.pillsmanager.medicinces.presenter;

import androidx.lifecycle.LifecycleOwner;

public interface MedicinePresenterInterface {
    void getActiveMedication(LifecycleOwner owner);
    void getInActiveMedication(LifecycleOwner owner);
//    void addToFavourite(Movie movie);
}
