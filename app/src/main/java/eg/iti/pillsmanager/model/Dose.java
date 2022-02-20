package eg.iti.pillsmanager.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "dose")
public class Dose {
    @PrimaryKey  @NonNull
    String user;
    @PrimaryKey  @NonNull
    String medecine;
    int day;
    int month;
    int year;
    int doseQuantity;
    int totalQuantity;
    boolean active;
    long startTime;
    long endTime;
    int lastOne;
    public Dose(@NonNull String user, @NonNull String medecine, int day, int month, int year, int doseQuantity, int totalQuantity, boolean active, long startTime, long endTime, int lastOne) {
        this.user = user;
        this.medecine = medecine;
        this.day = day;
        this.month = month;
        this.year = year;
        this.doseQuantity = doseQuantity;
        this.totalQuantity = totalQuantity;
        this.active = active;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lastOne = lastOne;
    }

    public void setUser(@NonNull String user) {
        this.user = user;
    }

    public void setMedecine(@NonNull String medecine) {
        this.medecine = medecine;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDoseQuantity(int doseQuantity) {
        this.doseQuantity = doseQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setLastOne(int lastOne) {
        this.lastOne = lastOne;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    @NonNull
    public String getMedecine() {
        return medecine;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDoseQuantity() {
        return doseQuantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public boolean isActive() {
        return active;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public int getLastOne() {
        return lastOne;
    }
}
