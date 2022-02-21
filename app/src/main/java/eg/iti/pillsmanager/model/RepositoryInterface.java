package eg.iti.pillsmanager.model;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.network.NetworkDelegate;

public interface RepositoryInterface {
    //DB
    LiveData<List<Medicine>> getStoredMedicines();
    //network
    void getAllMovies(NetworkDelegate networkDelegate);
    //DB
    void insertMovie(Medicine medicine);
    void deleteMovie(Medicine medicine);
}
