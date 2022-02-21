package eg.iti.pillsmanager.model;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.network.NetworkDelegate;
import eg.iti.pillsmanager.network.RemoteSource;

public class Repository implements RepositoryInterface {

    private final LocalSource localSource;
    private final RemoteSource remoteSource;
    private static Repository repository = null;

    private Repository(RemoteSource remoteSource, LocalSource localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }

    public static Repository getRepositoryInstance(RemoteSource remoteSource, LocalSource localSource) {
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
    public void insertMedicine(Medicine medicine) {

    }

    @Override
    public void deleteMedicine(Medicine medicine) {

    }
//***************************************************************
    //room user
    @Override
    public LiveData<List<User>> getStoredUsers() {
        return null;
    }

    @Override
    public void insetUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }


    //network-------------------------------------------
    @Override
    public void getAllMedicine(NetworkDelegate networkDelegate) {

    }
}
