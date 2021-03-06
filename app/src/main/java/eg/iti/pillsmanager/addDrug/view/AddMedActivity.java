package eg.iti.pillsmanager.addDrug.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.medicinces.view.MediciationsFragment;


public class AddMedActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drug);
        fragmentManager = getSupportFragmentManager();
        showFragmentone(savedInstanceState);
    }

    public static void showFragmentone(Bundle bundle){
        AddMedicationFragment addMedicationFragment = new AddMedicationFragment();
        showFragment(addMedicationFragment,bundle);
    }

    public static void showFragmentSecond(Bundle bundle){
        AddMedFragmentSecond addMedFragmentSecond = new AddMedFragmentSecond();
        showFragment(addMedFragmentSecond,bundle);
    }

    public static void showFragmentThree(Bundle bundle){
        AddMedFragmentThree addMedFragmentThree = new AddMedFragmentThree();
        showFragment(addMedFragmentThree,bundle);
    }
    public static void showFragmentAllMed(Bundle bundle){
        Fragment_all_med addAllMedFragment = new  Fragment_all_med();
        showFragment(addAllMedFragment,bundle);
    }

    public static void showFragmentMedication(Bundle bundle){
        MediciationsFragment mediciationsFragment = new MediciationsFragment();
        showFragment(mediciationsFragment,bundle);
    }

    private static void showFragment(Fragment fragment,Bundle bundle){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.main_activity_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(AddMedActivity.this, MainActivity.class);
        intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT );
        startActivity(intent);
    }
}