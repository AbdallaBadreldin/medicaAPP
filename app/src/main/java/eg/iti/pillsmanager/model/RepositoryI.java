package eg.iti.pillsmanager.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.database.medicineTable.MedicineDao;

public interface RepositoryI {


    /* remote*///-----------------------------------------------------------
    // firebase auth

    ////////////////////////////////////////////////////////////
    LiveData<List<Dose>> getAllDoses();
    void insertDose(Dose dose);
    void deleteDose(Dose dose);
    void updateDose(Dose dose);
    ////////////////////////////////////////////////////////////
    LiveData<List<Medicine>> getAllMedicine();
    void insertMedicine(Medicine medicine);
    void deleteMedicine(Medicine medicine);
    void updateMedicine(Medicine medicine);

}




