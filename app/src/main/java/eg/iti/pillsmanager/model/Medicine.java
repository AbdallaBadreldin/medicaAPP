package eg.iti.pillsmanager.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity( tableName = "medicine",primaryKeys = {"medicineName", "firstName","secondName"} )
public class Medicine {

    @NonNull
    String firstName;
    @NonNull
    String secondName;
    @NonNull
    String medicineName;
    boolean active;
    String reason;
    String form;
    int strengthValue;
    String strength;
    long treatmentDuration;
    int totalQuantity;
    int lastdoseQuantity;
    int quantityRemindAt;
    boolean activeRefillReminder;

    public Medicine(@NonNull String firstName, @NonNull String secondName, @NonNull String medicineName, boolean active, String reason, String form, int strengthValue, String strength, long treatmentDuration, int totalQuantity, int lastdoseQuantity, int quantityRemindAt, boolean activeRefillReminder) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.medicineName = medicineName;
        this.active = active;
        this.reason = reason;
        this.form = form;
        this.strengthValue = strengthValue;
        this.strength = strength;
        this.treatmentDuration = treatmentDuration;
        this.totalQuantity = totalQuantity;
        this.lastdoseQuantity = lastdoseQuantity;
        this.quantityRemindAt = quantityRemindAt;
        this.activeRefillReminder = activeRefillReminder;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(@NonNull String secondName) {
        this.secondName = secondName;
    }

    @NonNull
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(@NonNull String medicineName) {
        this.medicineName = medicineName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(int strengthValue) {
        this.strengthValue = strengthValue;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public long getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(long treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getLastdoseQuantity() {
        return lastdoseQuantity;
    }

    public void setLastdoseQuantity(int lastdoseQuantity) {
        this.lastdoseQuantity = lastdoseQuantity;
    }

    public int getQuantityRemindAt() {
        return quantityRemindAt;
    }

    public void setQuantityRemindAt(int quantityRemindAt) {
        this.quantityRemindAt = quantityRemindAt;
    }

    public boolean isActiveRefillReminder() {
        return activeRefillReminder;
    }

    public void setActiveRefillReminder(boolean activeRefillReminder) {
        this.activeRefillReminder = activeRefillReminder;
    }
}