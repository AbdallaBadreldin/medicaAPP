package eg.iti.pillsmanager.dosemanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.databinding.ActivityDoseManagerBinding;
import eg.iti.pillsmanager.dosemanager.presenter.DoseManagerPresenter;
import eg.iti.pillsmanager.dosemanager.presenter.DoseManagerPresenterInterface;
import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.network.MedicineClient;

public class DoseManagerActivity extends AppCompatActivity implements DoseManagerInterface , OnDoseClickListener {

    RecyclerView recyclerViewDose;
    DoseAdapter doseAdapter;
    DoseManagerPresenterInterface doseManagerPresenterInterface;
    Repository repository;
    ConcreteLocalClass concreteLocalClass;

    private ActivityDoseManagerBinding binding;
    private RadioGroup radioGroupPeriod;
    private RadioGroup radioGroupDays;

//    private RadioButton radioButtonEveryDay;
//    private RadioButton radioButtonSelectDays;
//    private RadioButton radioButtonEveryMonth;
//    private RadioButton radioButtonOnceYear;

    LinearLayoutCompat layoutOnceMonth;
    LinearLayoutCompat doseLinearYearly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDoseManagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        View myLayout = findViewById( R.id.dose_container_view ); // root View id from that link
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        radioGroupPeriod = myLayout.findViewById(R.id.dose_repeat_period);


//                radioButtonEveryDay =myLayout.findViewById(R.id.dose_every_day);
//                radioButtonSelectDays =myLayout.findViewById(R.id.dose_pick_days);
//                radioButtonEveryMonth =myLayout.findViewById(R.id.dose_every_month);
//                radioButtonOnceYear=myLayout.findViewById(R.id.dose_once_year);

        radioGroupPeriod.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                switch (checkedId){
                    case R.id.dose_every_day:
                        radioGroupDays.setVisibility(View.GONE);
                        layoutOnceMonth.setVisibility(View.GONE);
                        doseLinearYearly.setVisibility(View.GONE);
                        break;
                    case R.id.dose_pick_days :
                        radioGroupDays.setVisibility(View.VISIBLE);
                        layoutOnceMonth.setVisibility(View.GONE);
                        doseLinearYearly.setVisibility(View.GONE);
                        break;

                    case R.id.dose_every_month :
                        radioGroupDays.setVisibility(View.GONE);
                        layoutOnceMonth.setVisibility(View.VISIBLE);
                        doseLinearYearly.setVisibility(View.GONE);
                        break;

                    case R.id.dose_once_year :
                        radioGroupDays.setVisibility(View.GONE);
                        layoutOnceMonth.setVisibility(View.GONE);
                        doseLinearYearly.setVisibility(View.VISIBLE);
                        break;

                    default:
                        radioGroupDays.setVisibility(View.GONE);
                        layoutOnceMonth.setVisibility(View.GONE);
                        doseLinearYearly.setVisibility(View.GONE);
                }
            }
        });

        radioGroupDays = myLayout.findViewById(R.id.dose_days);
        radioGroupDays.setVisibility(View.GONE);
        layoutOnceMonth = myLayout.findViewById(R.id.dose_layout_once_month);
        layoutOnceMonth.setVisibility(View.GONE);
        doseLinearYearly=myLayout.findViewById(R.id.dose_linear_yearly);
        doseLinearYearly.setVisibility(View.GONE);




        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroupPeriod.getCheckedRadioButtonId()){
                    case R.id.dose_every_day:

                        break;
                    case R.id.dose_pick_days :

                        break;

                    case R.id.dose_every_month :

                        break;

                    case R.id.dose_once_year :

                        break;

                    default:

                }

                Snackbar.make(view, "add dose to medicine", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerViewDose = myLayout.findViewById(R.id.dose_management_recycler);
        recyclerViewDose.setHasFixedSize(true);

        doseAdapter = new DoseAdapter(this, this);

        LinearLayoutManager activeRefillLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewDose.setLayoutManager(activeRefillLayout);
        recyclerViewDose.setAdapter(doseAdapter);

        concreteLocalClass = ConcreteLocalClass.getConcreteLocalClassInstance(this);

        repository = Repository.getInstance(MedicineClient.getMedicineClientInstance(), concreteLocalClass,this);

        doseManagerPresenterInterface = new DoseManagerPresenter(this, repository);
        Intent i = getIntent();
        Medicine med = (Medicine) i.getSerializableExtra(getString(R.string.dose_manager_pass_data_id));
//        Toast.makeText(this,med.getEmail(),Toast.LENGTH_LONG).show();
        doseManagerPresenterInterface.getDosesByMedicine(med.getEmail(), med.getFirstName(),med.getMedicineName(),this);

    }


    @Override
    public void updateRecycler(List<Dose> doses) {
        doseAdapter.setDoseList(doses);
        doseAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}