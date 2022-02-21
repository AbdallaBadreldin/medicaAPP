package eg.iti.pillsmanager.database.DoseDao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import eg.iti.pillsmanager.model.Dose;
@Dao
public interface DoseDao {
    @Query("Select * From Dose")
    LiveData<List<Dose>> getAllDoses();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDose(Dose dose);

    @Delete
    void deleteDose(Dose dose);
    @Update
    void updateDose(Dose dose);
}
