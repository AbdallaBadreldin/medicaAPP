package eg.iti.pillsmanager.refill.view;

import android.widget.CheckBox;

import eg.iti.pillsmanager.model.Medicine;

public interface OnRefillClickListenerInterface {
    void changeRefillReminderStatus(Medicine medicine);
    void refillMedicine(Medicine medicine);
}
