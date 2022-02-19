package eg.iti.pillsmanager.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.database.userTable.UserDao;
import eg.iti.pillsmanager.database.userTable.UserDataBase;
import eg.iti.pillsmanager.model.User;

//here we add all Daos as we will create new daos
public class ConcreteLocalClass implements LocalSource {
    private final UserDao userDao;
    private final LiveData<List<User>> storedUsers;
    private static ConcreteLocalClass concreteLocalClass = null;

    //for future use
//    private final AlarmDao movieDao;
//    private final MedicineDao movieDao;
//    private final DoseDao movieDao;

    //once we add new daos we will edit this constractor
    public ConcreteLocalClass(Context context) {
      UserDataBase userDataBase = UserDataBase.getUserDataBaseInstance(context.getApplicationContext());
        userDao = userDataBase.getUserDao();
    storedUsers = userDao.getAllUsers();
    }

    //we don't have to editi this
    public static ConcreteLocalClass getConcreteLocalClassInstance(Context context) {
        if (concreteLocalClass == null) {
            concreteLocalClass = new ConcreteLocalClass(context);
        }
        return concreteLocalClass;
    }


    // the more daos we will add the more methods we will need
   //once we edited old daos we will mopdifiy localSource then we will modifiy this
   //hint don't forget to mofify constructor if you added new tables

    //User dao methods
    // 1 get all users data
    // 2 insert user
    // 3 delete user
    @Override
    public LiveData<List<User>> getAllUsers() {
        return storedUsers;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }



    //Mediciene dao





    //alarm dao
}


