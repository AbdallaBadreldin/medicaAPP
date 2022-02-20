package eg.iti.pillsmanager.medicinces.view;

import eg.iti.pillsmanager.model.Medicine;

public interface OnMedicineClickListener {
    void openAlarms(Medicine medicine);
    void openEdit(Medicine medicine);
    void openMedicine(Medicine medicine);
}
