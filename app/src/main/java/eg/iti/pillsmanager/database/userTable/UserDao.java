package eg.iti.pillsmanager.database.userTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import eg.iti.pillsmanager.model.User;

//user dao maybe we will need to edit it
@Dao
public interface UserDao {

    @Query("Select * From user")
    LiveData<List<User>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

//    @Delete(Select * From user)
//    void deleteAllUsers();
}


