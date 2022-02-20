package com.example.test.model;

import androidx.annotation.NonNull;

import com.example.test.AsyncCallBackI;
import com.example.test.network.FirebaseDB;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Repository implements RepositoryI{
    private static Repository repository;
    private static FirebaseAuth firebaseAuth;

    public Repository(){
    }

    public static Repository getInstance(){
        if(repository == null)
            repository = new Repository();
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

/*
    @Override
    public String getCurrentUserUID(){
        if(firebaseAuth != null && firebaseAuth.getCurrentUser() != null)
            return firebaseAuth.getCurrentUser().getUid();
        return null;
    }
 */
}
