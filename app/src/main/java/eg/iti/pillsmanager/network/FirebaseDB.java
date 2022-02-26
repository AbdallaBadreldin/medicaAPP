package eg.iti.pillsmanager.network;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import eg.iti.pillsmanager.model.User;

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
        getInstance();
        initialize();
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

