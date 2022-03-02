package eg.iti.pillsmanager.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Dose",primaryKeys = {"email", "user","medicine"}  )
public class Dose implements Serializable {
    @NonNull
    String email;
    @NonNull
    String user;
    @NonNull
    String medicine;
    int day;
    int month;
    int flag;
    int dose;
    boolean active;
    long doseTime;
    String startDate;
    String endDate;
    long lastDosegivenTime;
    String lastOnegivenMedicine;

    @Ignore
    public Dose() {
    }


    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    public void setUser(@NonNull String user) {
        this.user = user;
    }

    @NonNull
    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(@NonNull String medicine) {
        this.medicine = medicine;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getDoseTime() {
        return doseTime;
    }

    public void setDoseTime(long doseTime) {
        this.doseTime = doseTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getLastDosegivenTime() {
        return lastDosegivenTime;
    }

    public void setLastDosegivenTime(long lastDosegivenTime) {
        this.lastDosegivenTime = lastDosegivenTime;
    }

    public String getLastOnegivenMedicine() {
        return lastOnegivenMedicine;
    }

    public void setLastOnegivenMedicine(String lastOnegivenMedicine) {
        this.lastOnegivenMedicine = lastOnegivenMedicine;
    }

    public Dose(@NonNull String email, @NonNull String user, @NonNull String medicine, int day, int month, int flag, int dose, boolean active, long doseTime, String startDate, String endDate, long lastDosegivenTime, String lastOnegivenMedicine) {
        this.email = email;
        this.user = user;
        this.medicine = medicine;
        this.day = day;
        this.month = month;
        this.flag = flag;
        this.dose = dose;
        this.active = active;
        this.doseTime = doseTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastDosegivenTime = lastDosegivenTime;
        this.lastOnegivenMedicine = lastOnegivenMedicine;
    }
}
