package eg.iti.pillsmanager.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.AsyncCallBackI;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.database.medicineTable.MedicineDao;
import eg.iti.pillsmanager.network.FirebaseDB;

public class Repository implements RepositoryI{
    private static Repository repository;
    private static FirebaseAuth firebaseAuth;
    LocalSource localSource;//db room
    private Context context;
    MedicineDao medicineDao;
    //////////////////////////////////
    private Repository( LocalSource localSource, Context context){
        this.localSource = localSource;
        this.context=context;
    }
    public static Repository getInstance(LocalSource localSource,Context context) {
        if (repository == null) {
            repository =new Repository(localSource,context);

        }
        return repository;
    }

    public static FirebaseAuth getInstanceOfFirebase(){
        if( firebaseAuth== null)
            firebaseAuth = FirebaseAuth.getInstance();
        return firebaseAuth;
    }

    @Override
    public void signIn(String email, String password, AsyncCallBackI asyncCallBack) {
        getInstanceOfFirebase();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        asyncCallBack.onSuccess("signIn");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                asyncCallBack.onFailure(e.getMessage());
            }
        });
    }

    @Override
    public void signUp(User user, AsyncCallBackI asyncCallBack) {
        getInstanceOfFirebase();
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                user.setUserID(FirebaseAuth.getInstance().getCurrentUser().getUid());
                FirebaseDB.getInstance().addUser(user);
                asyncCallBack.onSuccess("signUp");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                asyncCallBack.onFailure(e.getMessage());
            }
        });
    }

    @Override
    public void resetPassword(AsyncCallBackI asyncCallBack, String email) {
        getInstanceOfFirebase();
        firebaseAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                asyncCallBack.onSuccess("resetPassword");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                asyncCallBack.onFailure(e.getLocalizedMessage());
            }
        });
    }

    @Override
    public  void signOut(AsyncCallBackI asyncCallBack) {
        getInstanceOfFirebase();
        firebaseAuth.signOut();
        asyncCallBack.onSuccess("SIGN_OUT_ACTION");
    }

    @Override
    public LiveData<List<Dose>> getAllDoses() {
        return localSource.getAllDoses();
    }

    @Override
    public void insertDose(Dose dose) {
      localSource.insertDose(dose);
    }

    @Override
    public void deleteDose(Dose dose) {
      localSource.deleteDose(dose);
    }

    @Override
    public void updateDose(Dose dose) {
        localSource.updateDose(dose);
    }


    @Override
    public LiveData<List<Medicine>> getAllMedicine() {
        return localSource.getAllMedicine();
    }

    @Override
    public void insertMedicine(Medicine medicine) {
         localSource.insertMedicine(medicine);
    }

    @Override
    public void deleteMedicine(Medicine medicine) {
          localSource.deleteMedicine(medicine);
    }

    @Override
    public void updateMedicine(Medicine medicine) {
      localSource.updateMedicine(medicine);
    }




/*
    @Override
    public String getCurrentUserUID(){
        if(firebaseAuth != null && firebaseAuth.getCurrentUser() != null)
            return firebaseAuth.getCurrentUser().getUid();
        return null;
    }
 */
}
