package eg.iti.pillsmanager.model;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.network.NetworkDelegate;

public interface RepositoryInterface {

  //DB MEDICINE//*****************************
  //DB ROOM
  LiveData<List<Medicine>> getStoredMedicines();
  LiveData<List<Medicine>> getStoredActiveMedicines();
  LiveData<List<Medicine>> getStoredInactiveMedicines();
  LiveData<List<Medicine>> getAllMedicine();
  void insertMedicine(Medicine medicine);
  void deleteMedicine(Medicine medicine);
  void updateMedicine(Medicine medicine);
    //---------------------------------------------------------

    //DB USERS*****************************
    //DB ROOM
    LiveData<List<User>> getStoredUsers();
    void insetUser(User user);
    void deleteUser(User user);


    //***************************************************
    //network
    void getAllMedicine(NetworkDelegate networkDelegate);


  ////////////////////////////////////////////////////////////
  LiveData<List<Dose>> getAllDoses();
  LiveData<List<Dose>> getDosesByMedicine(String email , String user, String medicine);
  void insertDose(Dose dose);
  void deleteDose(Dose dose);
  void updateDose(Dose dose);
  ////////////////////////////////////////////////////////////


}
