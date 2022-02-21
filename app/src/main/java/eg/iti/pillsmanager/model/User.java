package eg.iti.pillsmanager.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user" ,primaryKeys = {"firstName","secondName"} )
public class User {
     @NonNull
    private String firstName;
     @NonNull
    private String secondName;
    private long age;
    private String email;
    private String password;
    private String userID;

    public User(@NonNull String firstName, @NonNull String secondName, long age, String email, String password, String userID) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.userID = userID;
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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
