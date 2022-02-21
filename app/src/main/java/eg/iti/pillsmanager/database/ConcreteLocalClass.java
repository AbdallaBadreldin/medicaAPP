package eg.iti.pillsmanager.database;

import android.content.Context;

import androidx.lifecycle.LiveData;
import java.util.List;
import eg.iti.pillsmanager.database.DoseDao.DoseDao;
import eg.iti.pillsmanager.database.DoseDao.DoseDataBase;
import eg.iti.pillsmanager.database.medicineTable.MedicineDao;
import eg.iti.pillsmanager.database.medicineTable.MedicineDataBase;
import eg.iti.pillsmanager.database.userTable.UserDao;
import eg.iti.pillsmanager.database.userTable.UserDataBase;
import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.User;

//here we add all Daos as we will create new daos
public class ConcreteLocalClass implements LocalSource {
    private static ConcreteLocalClass concreteLocalClass = null;


    private final UserDao userDao;
    private final LiveData<List<User>> storedUsers;

    private final MedicineDao medicineDao;
    private final LiveData<List<Medicine>> storedMedicine;
    private final LiveData<List<Medicine>> storedActiveMedicine;
    private final LiveData<List<Medicine>> storedInactiveMedicine;
//    private static ConcreteLocalClass concreteLocalClass = null;

//    private static ConcreteLocalClass concreteLocalClass = null;
    private final DoseDao doseDao;
    private final LiveData<List<Dose>> storedDose;
    //for future use
//    private final AlarmDao movieDao;
//    private final MedicineDao movieDao;
//    private final DoseDao movieDao;

    //once we add new daos we will edit this constractor
    public ConcreteLocalClass(Context context) {
//        users things
        UserDataBase userDataBase = UserDataBase.getUserDataBaseInstance(context.getApplicationContext());
        userDao = userDataBase.getUserDao();
        storedUsers = userDao.getAllUsers();

        //medicine things
        MedicineDataBase medicineDataBase = MedicineDataBase.getMedicineDataBaseInstance(context.getApplicationContext());
        medicineDao = medicineDataBase.getMedicineDao();
        storedMedicine = medicineDao.getAllMedicine();
        //dose things
        DoseDataBase DoseDataBase = eg.iti.pillsmanager.database.DoseDao.DoseDataBase.getDoseDataBaseInstance(context.getApplicationContext());
        doseDao = DoseDataBase.getDoseDao();
        storedDose =doseDao.getAllDoses();
        storedActiveMedicine = medicineDao.getAllActiveMedicine();
        storedInactiveMedicine = medicineDao.getAllInactiveMedicine();

    }

    //we don't have to edit this
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
    //medicine
    // 1 get all users data
    // 2 insert user
    // 3 delete user
    // 4 get all active users data
    // 5 get all inactive users data
    @Override
    public LiveData<List<Medicine>> getAllMedicine() {
        return storedMedicine;
    }

    @Override
    public LiveData<List<Medicine>> getAllActiveMedicine() {
       return storedActiveMedicine;
    }

    @Override
    public LiveData<List<Medicine>> getAllInactiveMedicine() {
        return storedInactiveMedicine;
    }

    @Override
    public void insertMedicine(Medicine medicine) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                medicineDao.insertMedicine(medicine);
            }
        }.start();
    }

    @Override
    public void deleteMedicine(Medicine medicine) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                medicineDao.deleteMedicine(medicine);
            }
        }.start();
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                medicineDao.updateMedicine(medicine);

            }
        }).start();
    }




    //dose dao
    @Override
    public LiveData<List<Dose>> getAllDoses() {
        return storedDose;
    }

    @Override
    public void insertDose(Dose dose) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doseDao.insertDose(dose);

            }
        }).start();

    }

    @Override
    public void deleteDose(Dose dose) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doseDao.deleteDose(dose);

            }
        }).start();

    }
    @Override
    public void updateDose(Dose dose) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doseDao.updateDose(dose);

            }
        }).start();
    }
}


