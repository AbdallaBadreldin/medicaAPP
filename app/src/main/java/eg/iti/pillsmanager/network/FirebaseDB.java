package com.example.test.network;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.test.AsyncCallBackI;
import com.example.test.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDB {
    private static FirebaseDB firebaseDB;
    FirebaseDatabase database;
    DatabaseReference mDatabase;

    private FirebaseDB(){

    }

    public static FirebaseDB getInstance(){
        if(firebaseDB == null)
            firebaseDB = new FirebaseDB();
        return firebaseDB;
    }

    public void initialize(){
         database = FirebaseDatabase.getInstance();
    }

    public void addUser(User user){
        mDatabase = database.getReference();
        mDatabase.child("users").child(user.getUserID()).setValue(user);
    }

   /* public void loadData(AsyncCallBackI asyncCallBack){
        mDatabase = database.getReference();
        System.out.println("id"+ FirebaseAuthentication.getInstance().getCurrentUserUID());
        Log.e(TAG, "loadData id: "+FirebaseAuthentication.getInstance().getCurrentUserUID());

        mDatabase.child("users").child(FirebaseAuthentication.getInstance().getCurrentUserUID()).get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
               User user = (User) dataSnapshot.getValue();
                Log.e(TAG, "loadData id: "+user.getEmail() +"   "+user.getFullname());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }*/

}

