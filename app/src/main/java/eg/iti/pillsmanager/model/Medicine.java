package eg.iti.pillsmanager.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medecine")
public class Medicine {
    @PrimaryKey@NonNull
    String username;
    @PrimaryKey@NonNull
    String medecineName;
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

    public Medicine(@NonNull String username, @NonNull String medecineName, boolean active, String reason, String form, int strengthValue, String strength, long treatmentDuration, int totalQuantity, int lastdoseQuantity, int quantityRemindAt, boolean activeRefillReminder) {
        this.username = username;
        this.medecineName = medecineName;
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

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public void setMedecineName(@NonNull String medecineName) {
        this.medecineName = medecineName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setStrengthValue(int strengthValue) {
        this.strengthValue = strengthValue;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setTreatmentDuration(long treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setLastdoseQuantity(int lastdoseQuantity) {
        this.lastdoseQuantity = lastdoseQuantity;
    }

    public void setQuantityRemindAt(int quantityRemindAt) {
        this.quantityRemindAt = quantityRemindAt;
    }

    public void setActiveRefillReminder(boolean activeRefillReminder) {
        this.activeRefillReminder = activeRefillReminder;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getMedecineName() {
        return medecineName;
    }

    public boolean isActive() {
        return active;
    }

    public String getReason() {
        return reason;
    }

    public String getForm() {
        return form;
    }

    public int getStrengthValue() {
        return strengthValue;
    }

    public String getStrength() {
        return strength;
    }

    public long getTreatmentDuration() {
        return treatmentDuration;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getLastdoseQuantity() {
        return lastdoseQuantity;
    }

    public int getQuantityRemindAt() {
        return quantityRemindAt;
    }

    public boolean isActiveRefillReminder() {
        return activeRefillReminder;
    }
}