package eg.iti.pillsmanager.database.medicineTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.User;

//user dao maybe we will need to edit it
@Dao
public interface MedicineDao {

    @Query("Select * From Medicine")
    LiveData<List<Medicine>> getAllMedicine();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMedicine(Medicine medicine);

    @Delete
    void deleteMedicine(Medicine medicine);

//    @Delete(Select * From user)
//    void deleteAllUsers();
}


