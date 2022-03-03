package eg.iti.pillsmanager.EditDrug;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedFragmentSecond;
import eg.iti.pillsmanager.addDrug.view.AddMedFragmentThree;
import eg.iti.pillsmanager.addDrug.view.AddMedicationFragment;
import eg.iti.pillsmanager.model.Medicine;

public class Edit_medActivity extends AppCompatActivity {
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_med);
        fragmentManager = getSupportFragmentManager();
       // showFragmentone();
        Intent intent = getIntent();
        Medicine medicine = (Medicine) intent.getSerializableExtra("med");

        Log.v("MEDICINE_DATA : ", medicine.toString());

        EditMedFragmentOne editMedicationFragment = new EditMedFragmentOne();
        editMedicationFragment.bundle = new Bundle();
        editMedicationFragment.bundle.putSerializable("med",medicine);
        showFragment(editMedicationFragment,null);


    }
    public static void showFragmentone(){
        EditMedFragmentOne editMedicationFragment = new EditMedFragmentOne();
        showFragment(editMedicationFragment,null);
    }

    public static void showFragmentSecond(Bundle bundle){
        EditMedFragmentSecond editMedFragmentSecond = new EditMedFragmentSecond();
        showFragment(editMedFragmentSecond,bundle);
    }

    public static void showFragmentThree(Bundle bundle){
        EditMedFragmentThree editMedFragmentThree = new EditMedFragmentThree();
        showFragment(editMedFragmentThree,bundle);
    }


    private static void showFragment(Fragment fragment,Bundle bundle){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.main_activity_container, fragment);
        fragmentTransaction.commit();
    }

}