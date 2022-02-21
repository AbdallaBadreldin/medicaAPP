package eg.iti.pillsmanager.database;


import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.User;

// here we add our interface for all local data
/*
when we will add new tables or add new methods in daos
we will modify localSource
 */
public interface LocalSource {

    //interface for medecine table
    LiveData<List<Medicine>>getAllMedicine();
    void insertMedicine(Medicine medicine);
    void deleteMedicine(Medicine medicine
    );
    void updateMedicine(Medicine medicine);


    //interface for user table
    LiveData<List<User>>  getAllUsers();
    void insertUser(User user);
    void deleteUser(User user);



    //interface for dose table
    LiveData<List<Dose>> getAllDoses();
    void insertDose(Dose dose);
    void deleteDose(Dose dose);
    void updateDose(Dose dose);


    //interface for medicine table
    LiveData<List<Medicine>> getAllMedicine();
    LiveData<List<Medicine>> getAllActiveMedicine();
    LiveData<List<Medicine>> getAllInactiveMedicine();
    void insertMedicine(Medicine medicine);
    void deleteMedicine(Medicine medicine);


    //interface for alarm table
//    LiveData<List<User>> getAllUsers();
//    void insertUser(User user);
//    void deleteUser(User user);
}
