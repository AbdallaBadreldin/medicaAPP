package eg.iti.pillsmanager.database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.iti.pillsmanager.R;
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

    private  LiveData<List<Medicine>> storedAllActiveMedicineByEmail;
    private  LiveData<List<Medicine>> storedAllInactiveMedicineByEmail;

    private List<Medicine> storedActiveMedicineNeedsRefill;
    private final LiveData<List<Medicine>> storedInactiveMedicineNeedsRefill;
    private final LiveData<List<Medicine>> storedEmptyActiveMedicine;
    private final LiveData<List<Medicine>> storedEmptyInactiveMedicine;


    private final DoseDao doseDao;
    private final LiveData<List<Dose>> storedDose;
    private  LiveData<List<Dose>> storedDoseByMedicine;
    private String email = "";
    private String user="";
    private String medicine="";
    //for future use
//    private final AlarmDao movieDao;
//    private final MedicineDao movieDao;
//    private final DoseDao movieDao;

    //once we add new daos we will edit this constractor
    public ConcreteLocalClass(Context context,String email ,String medicine) {
//        users things
        UserDataBase userDataBase = UserDataBase.getUserDataBaseInstance(context.getApplicationContext());
        userDao = userDataBase.getUserDao();
        storedUsers = userDao.getAllUsers();

        //medicine things
        MedicineDataBase medicineDataBase = MedicineDataBase.getMedicineDataBaseInstance(context.getApplicationContext());
        medicineDao = medicineDataBase.getMedicineDao();
        storedMedicine = medicineDao.getAllMedicine();
        new Thread(new Runnable() {
            @Override
            public void run() {
                storedActiveMedicineNeedsRefill=medicineDao.getActiveMedicineNeedsRefill();
            }
        }).start();
        storedInactiveMedicineNeedsRefill =medicineDao.getInactiveMedicineNeedsRefill();
        storedEmptyActiveMedicine = medicineDao.getEmptyActiveMedicine();
        storedEmptyInactiveMedicine = medicineDao.getEmptyInactiveMedicine();
        storedActiveMedicine = medicineDao.getAllActiveMedicine();
        storedInactiveMedicine = medicineDao.getAllInactiveMedicine();
        storedAllActiveMedicineByEmail=medicineDao.getAllActiveMedicineByEmail(email,user);
        storedAllInactiveMedicineByEmail=medicineDao.getAllInactiveMedicineByEmail(email,user);

        //dose things
        DoseDataBase DoseDataBase = eg.iti.pillsmanager.database.DoseDao.DoseDataBase.getDoseDataBaseInstance(context.getApplicationContext());
        doseDao = DoseDataBase.getDoseDao();
        storedDose =doseDao.getAllDoses();
        storedDoseByMedicine =doseDao.getDoseByMedicine(email,medicine);

    }



    //we don't have to edit this
    public static ConcreteLocalClass getConcreteLocalClassInstance(Context context) {
        if (concreteLocalClass == null) {
            concreteLocalClass = new ConcreteLocalClass(context,context.getString(R.string.empty),context.getString(R.string.empty));
        }
        return concreteLocalClass;
    }

    public static ConcreteLocalClass getConcreteLocalClassInstanceDose(Context context, String email, String medicine) {
//        this.email=email;
//        this.medicine=medicine;
        if (concreteLocalClass == null) {
            concreteLocalClass = new ConcreteLocalClass(context,email,medicine);
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
    // 4 update user
    @Override
    public LiveData<List<User>> getAllUsers() {
        return storedUsers;
    }

    @Override
    public void insertUser(User user) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                userDao.insertUser(user);
            }
        }.start();

    }

    @Override
    public void deleteUser(User user) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                userDao.deleteUser(user);
            }
        }.start();

    }

    @Override
    public void updateUser(User user) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                userDao.updateUser(user);
            }
        }.start();
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
    public LiveData<List<Medicine>> getAllActiveMedicineByEmail(String email, String user) {
        if(this.email.equals(email) && this.medicine.equals(user)){
            return storedAllActiveMedicineByEmail;
        }

        this.email=email;
       this.user =user;
//        this.medicine =medicine;
        storedAllActiveMedicineByEmail =medicineDao.getAllActiveMedicineByEmail(email,user);

        return storedAllActiveMedicineByEmail;
    }

    @Override
    public LiveData<List<Medicine>> getAllInactiveMedicineByEmail(String email, String user) {
        if(this.email.equals(email) && this.medicine.equals(user)){
            return storedAllInactiveMedicineByEmail;
        }

        this.email=email;
        this.user =user;
//        this.medicine =medicine;
        storedAllInactiveMedicineByEmail =medicineDao.getAllInactiveMedicineByEmail(email,user);

        return storedAllInactiveMedicineByEmail;
    }

    @Override
    public List<Medicine> getActiveMedicineNeedsRefill() { return storedActiveMedicineNeedsRefill; }
    @Override
    public LiveData<List<Medicine>> getInactiveMedicineNeedsRefill() { return storedInactiveMedicineNeedsRefill; }
    @Override
    public LiveData<List<Medicine>> getEmptyActiveMedicine() { return storedEmptyActiveMedicine; }
    @Override
    public LiveData<List<Medicine>> getEmptyInactiveMedicine() { return storedEmptyInactiveMedicine; }

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
    public LiveData<List<Dose>> getDosesByMedicine(String email, String medicine) {
        if(this.email.equals(email) && this.medicine.equals(medicine)){
            return storedDoseByMedicine;
        }

       this.email=email;
//       this.user =user;
       this.medicine =medicine;
        storedDoseByMedicine =doseDao.getDoseByMedicine(email,medicine);

        return storedDoseByMedicine;
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


