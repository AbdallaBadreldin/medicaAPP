package eg.iti.pillsmanager.medicinces.view;

import java.util.List;

import eg.iti.pillsmanager.model.Medicine;

public interface AllMedicineViewInterface {

    void showActiveMedicines(List<Medicine> medicines);
    void showInactiveMedicines(List<Medicine> medicines);

}
