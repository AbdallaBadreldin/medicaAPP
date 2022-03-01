package eg.iti.pillsmanager.database.DoseDao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import eg.iti.pillsmanager.model.Dose;

@Database(entities = {Dose.class}, version = 3)
public abstract class DoseDataBase extends RoomDatabase {
    public static DoseDataBase doseDataBase = null;

    public static synchronized DoseDataBase getDoseDataBaseInstance(Context context) {
        if ( doseDataBase == null) {
            doseDataBase = Room.databaseBuilder(context.getApplicationContext(),  DoseDataBase.class, "Dose")
                    .build();
        }
        return  doseDataBase;
    }

    public abstract DoseDao getDoseDao();


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
