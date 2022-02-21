package eg.iti.pillsmanager.model;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.network.NetworkDelegate;

public interface RepositoryInterface {

  //DB MEDICINE//*****************************
    //DB ROOM
    LiveData<List<Medicine>> getStoredMedicines();

    //DB ROOM
    void insertMedicine(Medicine medicine);
    void deleteMedicine(Medicine medicine);
    //---------------------------------------------------------

    //DB USERS
    //DB ROOM
    LiveData<List<User>> getStoredUsers();

    //DB ROOM
    void insetUser(User user);
    void deleteUser(User user);


    //***************************************************
    //network
    void getAllMedicine(NetworkDelegate networkDelegate);

}
