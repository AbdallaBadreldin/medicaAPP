package eg.iti.pillsmanager.model;

import android.content.Context;

import androidx.annotation.NonNull;

import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.network.NetworkDelegate;
import eg.iti.pillsmanager.network.RemoteSource;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.database.medicineTable.MedicineDao;
import eg.iti.pillsmanager.network.FirebaseDB;

//public class Repository implements RepositoryI{
  //  private static Repository repository;
   // private static FirebaseAuth firebaseAuth;
    //LocalSource localSource;//db room
    //private Context context;
    //MedicineDao medicineDao;
    //////////////////////////////////
    //private Repository( LocalSource localSource, Context context){
     //   this.localSource = localSource;
      //  this.context=context;

public class Repository implements RepositoryInterface {

    private final LocalSource localSource;
    private final RemoteSource remoteSource;
    private static Repository repository = null;

    private Repository(RemoteSource remoteSource, LocalSource localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }
//    public static Repository getInstance(LocalSource localSource,Context context) {
//        if (repository == null) {
//            repository = new Repository(localSource, context);

    public static Repository getRepositoryInstance(RemoteSource remoteSource, LocalSource
            localSource) {
        if (repository == null) {
            repository = new Repository(remoteSource, localSource);

        }
        return repository;
    }

    //room medicine
    @Override
    public LiveData<List<Medicine>> getStoredMedicines() {
        return localSource.getAllMedicine();
    }

    @Override
    public LiveData<List<Medicine>> getStoredActiveMedicines() {
        return localSource.getAllActiveMedicine();
    }

    @Override
    public LiveData<List<Medicine>> getStoredInactiveMedicines() {
        return localSource.getAllInactiveMedicine();
    }

    @Override
    public void insertMedicine(Medicine medicine) {
        localSource.insertMedicine(medicine);
    }

    @Override
    public void deleteMedicine(Medicine medicine) {
localSource.deleteMedicine(medicine);
    }

    @Override
    public LiveData<List<User>> getStoredUsers() {
        return localSource.getAllUsers();
    }

    @Override
    public void insetUser(User user) {
localSource.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
localSource.deleteUser(user);
    }






    
    //******************************************
    @Override
    public void getAllMedicine(NetworkDelegate networkDelegate) {
localSource.getAllMedicine();
    }
}