package eg.iti.pillsmanager.database.userTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import eg.iti.pillsmanager.model.User;

//user dao maybe we will need to edit it
@Dao
public interface UserDao {

    @Query("Select * From user")
    LiveData<List<User>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

//    @Delete(Select * From user)
//    void deleteAllUsers();
}


