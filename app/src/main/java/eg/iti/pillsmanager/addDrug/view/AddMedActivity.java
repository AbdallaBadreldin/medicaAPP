package eg.iti.pillsmanager.addDrug.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.medicinces.view.MediciationsFragment;


public class AddMedActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drug);
        fragmentManager = getSupportFragmentManager();
        showFragmentone();
    }

    public static void showFragmentone(){
        AddMedicationFragment addMedicationFragment = new AddMedicationFragment();
        showFragment(addMedicationFragment);
    }

    public static void showFragmentSecond(){
        AddMedFragmentSecond addMedFragmentSecond = new AddMedFragmentSecond();
        showFragment(addMedFragmentSecond);
    }

    public static void showFragmentThree(){
        AddMedFragmentThree addMedFragmentThree = new AddMedFragmentThree();
        showFragment(addMedFragmentThree);
    }

    public static void showFragmentMedication(){
        MediciationsFragment mediciationsFragment = new MediciationsFragment();
        showFragment(mediciationsFragment);
    }

    private static void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, fragment);
        fragmentTransaction.commit();
    }

}