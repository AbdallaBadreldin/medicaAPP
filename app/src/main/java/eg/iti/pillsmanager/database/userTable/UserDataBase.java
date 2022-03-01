package eg.iti.pillsmanager.database.userTable;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.Ignore;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import eg.iti.pillsmanager.model.User;


//table of users modifiy it if we will modifiy UserDao so as results we will modifit localSource for sure
@Database(entities = {User.class}, version = 5)
public abstract class UserDataBase extends RoomDatabase {

    public static UserDataBase userDataBase = null;

    public static synchronized UserDataBase getUserDataBaseInstance(Context context) {
        if (userDataBase == null) {
            userDataBase = Room.databaseBuilder(context.getApplicationContext(), UserDataBase.class, "users")
                    .build();
        }
        return userDataBase;
    }

    @Ignore
    public abstract UserDao getUserDao();


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
//        getUserDao().deleteAllUsers();
    }
}
