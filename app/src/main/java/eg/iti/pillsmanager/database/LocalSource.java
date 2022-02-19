package eg.iti.pillsmanager.database;


import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.model.User;

// here we add our interface for all local data
/*
when we will add new tables or add new methods in daos
we will modify localSource
 */
public interface LocalSource {

    //interface for user table
    LiveData<List<User>> getAllUsers();
    void insertUser(User user);
    void deleteUser(User user);


    //interface for medicine table



    //interface for alarm table

}
