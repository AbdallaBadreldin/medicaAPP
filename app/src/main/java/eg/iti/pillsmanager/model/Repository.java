package eg.iti.pillsmanager.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.network.NetworkDelegate;
import eg.iti.pillsmanager.network.RemoteSource;

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

    private static Repository repository=null;
    RemoteSource remoteResource;//API
    LocalSource localSource;//db
    private Context context;


    private Repository(RemoteSource remoteResource, LocalSource localSource, Context context){
        this.remoteResource = remoteResource;
        this.localSource = localSource;
        this.context=context;
    }
    public static Repository getInstance(RemoteSource remoteResource,LocalSource localSource,Context context) {
        if (repository == null) {
            repository =new Repository(remoteResource,localSource,context);

        }
        return repository;
    }


    //room medicine
    @Override
    public LiveData<List<Medicine>> getStoredMedicines() {
        return localSource.getAllMedicine();
    }

    @Override
    public LiveData<List<Medicine>> getStoredActiveMedicines() { return localSource.getAllActiveMedicine(); }

    @Override
    public LiveData<List<Medicine>> getStoredInactiveMedicines() { return localSource.getAllInactiveMedicine(); }

    @Override
    public LiveData<List<Medicine>> getAllMedicine() {
        return null;
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
    public void updateMedicine(Medicine medicine) {
    localSource.updateMedicine(medicine);
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




    //doses db
    @Override
    public LiveData<List<Dose>> getAllDoses() {
        return localSource.getAllDoses();
    }

    @Override
    public LiveData<List<Dose>> getDosesByMedicine(String email, String user, String medicine) {
        return localSource.getDosesByMedicine(email,user,medicine); }

    @Override
    public void insertDose(Dose dose) { localSource.insertDose(dose); }

    @Override
    public void deleteDose(Dose dose) { localSource.deleteDose(dose); }

    @Override
    public void updateDose(Dose dose) { localSource.updateDose(dose); }
}