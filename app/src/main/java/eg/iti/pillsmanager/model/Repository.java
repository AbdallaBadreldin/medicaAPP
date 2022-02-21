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

    @Override
    public LiveData<List<Medicine>> getStoredMedicines() {
        return null;
    }

    @Override
    public void getAllMovies(NetworkDelegate networkDelegate) {

    }

    @Override
    public void insertMovie(Medicine medicine) {

    }

    @Override
    public void deleteMovie(Medicine medicine) {

    }
}
