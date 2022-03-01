package eg.iti.pillsmanager.model;


import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity( tableName = "medicine",primaryKeys = {"medicineName", "Email"} )
public class Medicine implements Serializable {

    @NonNull
    String Email;
    @NonNull
    String medicineName;
    @NonNull
    String firstName;

    boolean active;
    String reason;
    String form;
    String strengthValue;
    String strength;
    String start_date;
    String end_date;
    int totalQuantity;
    int lastdoseQuantity;
    String dose_quantity;
    int days;
    int quantityRemindAt;
    boolean activeRefillReminder;
    String timeOfMed;
    String dateOfMed;
    String add_dose_quantity;


    //User user;
    //Dose dose;

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dose getDose() {
        return dose;
    }

    public void setDose(Dose dose) {
        this.dose = dose;
    }
*/

    // []days;
//    List<String> days_of_week;
    private ArrayList<String> days_of_week;

    public ArrayList<String> getDays_of_week() {
        return days_of_week;
    }

    public void setDays_of_week(ArrayList<String> days_of_week) {
        this.days_of_week = days_of_week;
    }


    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDose_quantity() {
        return dose_quantity;
    }

    public void setDose_quantity(String dose_quantity) {
        this.dose_quantity = dose_quantity;
    }


    public Medicine(@NonNull String firstName, @NonNull String Email, @NonNull String medicineName, boolean active, String reason, String form, String strengthValue, String strength, String start_date, String end_date, int totalQuantity, int lastdoseQuantity, String dose_quantity, int days, int quantityRemindAt, boolean activeRefillReminder, String timeOfMed, String dateOfMed, String add_dose_quantity, ArrayList<String> days_of_week) {
        this.firstName = firstName;
        this.Email = Email;
        this.medicineName = medicineName;
        this.active = active;
        this.reason = reason;
        this.form = form;
        this.strengthValue = strengthValue;
        this.strength = strength;
        this.start_date = start_date;
        this.end_date = end_date;
        this.totalQuantity = totalQuantity;
        this.lastdoseQuantity = lastdoseQuantity;
        this.dose_quantity = dose_quantity;
        this.days = days;
        this.quantityRemindAt = quantityRemindAt;
        this.activeRefillReminder = activeRefillReminder;
        this.timeOfMed = timeOfMed;
        this.dateOfMed = dateOfMed;
        this.add_dose_quantity = add_dose_quantity;
        this.days_of_week = days_of_week;
    }

    /////////////////////////////////////////////////////////////////////////
@Ignore
public Medicine(){}



    public void setAdd_dose_quantity(String add_dose_quantity) {
        this.add_dose_quantity = add_dose_quantity;
    }

    public String getAdd_dose_quantity() {
        return add_dose_quantity;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getEmail() {
        return Email;
    }

    public void setEmail(@NonNull String email) {
        Email = email;
    }
/*@NonNull
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(@NonNull String secondName) {
        this.secondName = secondName;
    }*/

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

    public String getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(String strengthValue) {
        this.strengthValue = strengthValue;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
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

    public void setQuantityRemindAt( int quantityRemindAt) {
        this.quantityRemindAt = quantityRemindAt;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setTimeOfMed(String timeOfMed) {
        this.timeOfMed = timeOfMed;
    }

    public void setDateOfMed(String dateOfMed) {
        this.dateOfMed = dateOfMed;
    }

    public boolean isActiveRefillReminder() {
        return activeRefillReminder;
    }

    public void setActiveRefillReminder(boolean activeRefillReminder) {
        this.activeRefillReminder = activeRefillReminder;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getTimeOfMed() {
        return timeOfMed;
    }

    public String getDateOfMed() {
        return dateOfMed;
    }




}