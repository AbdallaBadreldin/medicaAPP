package eg.iti.pillsmanager.refill.view;

import java.util.List;

import eg.iti.pillsmanager.model.Medicine;

public interface RefillFragmentInterface {

    void showList(List<Medicine> medicines);

    void updateMedicine(Medicine medicine);
}
