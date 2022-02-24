package eg.iti.pillsmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity( tableName = "medicine",primaryKeys = {"medicineName", "firstName","secondName"} )
public class Medicine implements Parcelable {
    @NonNull
    String firstName;
    @NonNull
    String secondName;
    @NonNull
    String medicineName;
    boolean active;
    String reason;
    String form;
   String strengthValue;
    String strength;
    long start_date;
    long end_date;
    int totalQuantity;
    String lastdoseQuantity;
    int quantityRemindAt;
    boolean activeRefillReminder;
    int timeOfMed;
    int dateOfMed;


    public Medicine(@NonNull String firstName, @NonNull String secondName, @NonNull String medicineName, boolean active, String reason, String form, String strengthValue, String strength, long start_date,long end_date, int totalQuantity, String lastdoseQuantity, int quantityRemindAt, boolean activeRefillReminder,int timeOfMed,int dateOfMed) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.medicineName = medicineName;
        this.active = active;
        this.reason = reason;
        this.form = form;
        this.strengthValue = strengthValue;
        this.strength = strength;
        this.start_date=start_date;
        this.end_date=end_date;
        this.totalQuantity = totalQuantity;
        this.lastdoseQuantity = lastdoseQuantity;
        this.quantityRemindAt = quantityRemindAt;
        this.activeRefillReminder = activeRefillReminder;
        this.timeOfMed = timeOfMed;
        this.dateOfMed = dateOfMed;

    }

/////////////////////////////////////////////////////////////////////////
@Ignore
public Medicine(){}

    @Ignore
    protected Medicine(Parcel in) {
        firstName = in.readString();
        secondName = in.readString();
        medicineName = in.readString();
        active = in.readByte() != 0;
        reason = in.readString();
        form = in.readString();
        strengthValue = in.readString();
        strength = in.readString();
        start_date = in.readLong();
        end_date = in.readLong();
        totalQuantity = in.readInt();
        lastdoseQuantity = in.readString();
        quantityRemindAt = in.readInt();
        activeRefillReminder = in.readByte() != 0;
    }

    @Ignore
    public static final Creator<Medicine> CREATOR = new Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel in) {
            return new Medicine(in);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };

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

    public String getLastdoseQuantity() {
        return lastdoseQuantity;
    }

    public void setLastdoseQuantity(String lastdoseQuantity) {
        this.lastdoseQuantity = lastdoseQuantity;
    }

    public int getQuantityRemindAt() {
        return quantityRemindAt;
    }

    public void setQuantityRemindAt(int quantityRemindAt) {
        this.quantityRemindAt = quantityRemindAt;
    }

    public void setStart_date(long start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(long end_date) {
        this.end_date = end_date;
    }

    public void setTimeOfMed(int timeOfMed) {
        this.timeOfMed = timeOfMed;
    }

    public void setDateOfMed(int dateOfMed) {
        this.dateOfMed = dateOfMed;
    }

    public boolean isActiveRefillReminder() {
        return activeRefillReminder;
    }

    public void setActiveRefillReminder(boolean activeRefillReminder) {
        this.activeRefillReminder = activeRefillReminder;
    }

    public long getStart_date() {
        return start_date;
    }

    public long getEnd_date() {
        return end_date;
    }

    public int getTimeOfMed() {
        return timeOfMed;
    }

    public int getDateOfMed() {
        return dateOfMed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(secondName);
        parcel.writeString(medicineName);
        parcel.writeByte((byte) (active ? 1 : 0));
        parcel.writeString(reason);
        parcel.writeString(form);
        parcel.writeString(strengthValue);
        parcel.writeString(strength);
        parcel.writeLong(start_date);
        parcel.writeLong(end_date);
        parcel.writeInt(totalQuantity);
        parcel.writeString(lastdoseQuantity);
        parcel.writeInt(quantityRemindAt);
        parcel.writeByte((byte) (activeRefillReminder ? 1 : 0));
    }
}