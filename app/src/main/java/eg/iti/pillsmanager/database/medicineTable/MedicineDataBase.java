package eg.iti.pillsmanager.database.medicineTable;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import eg.iti.pillsmanager.model.Medicine;



//table of users modifiy it if we will modifiy UserDao so as results we will modifit localSource for sure
@Database(entities = {Medicine.class}, version = 2)
public abstract class MedicineDataBase extends RoomDatabase {

    public static MedicineDataBase medicineDataBase = null;

    public static synchronized MedicineDataBase getMedicineDataBaseInstance(Context context) {
        if (medicineDataBase == null) {
            medicineDataBase = Room.databaseBuilder(context.getApplicationContext(), MedicineDataBase.class, "medicine")
                    .build();
        }
        return medicineDataBase;
    }

    public abstract MedicineDao getMedicineDao();


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {
    //getUserDao().deleteAllUsers();
    }
}
