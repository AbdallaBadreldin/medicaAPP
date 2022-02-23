package eg.iti.pillsmanager.addDrug.view;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenter;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.RepositoryInterface;
import eg.iti.pillsmanager.network.RemoteSource;


public class AddMedFragmentThree extends Fragment {
    TextView start_date,end_date,treatment_duration,quantity_of_med,med_value;
    Button save_btn,back_btn;
    EditText doses_left;
    RepositoryInterface repo;
    RemoteSource remoteSource;
    LocalSource localSource;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_add_med_three, container, false);
        start_date=view.findViewById(R.id.start_date);
        end_date=view.findViewById(R.id.end_date);
        //////////////////////////////////////////////////
        save_btn=view.findViewById(R.id.btn_save_add_three);
        back_btn=view.findViewById(R.id.btn_back_add_two);
///////////////////////////////////////////////////////////////////
        treatment_duration=view.findViewById(R.id.treatment_duration);
        quantity_of_med=view.findViewById(R.id.Quantity_of_med);
        med_value=view.findViewById(R.id.Quantity_of_med_value);
        doses_left=view.findViewById(R.id.doses_left);

        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePickerDialog(view);
                start_date.setText(start_date.getText());
            }
        });

        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(view);
            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                Medicine medicine = bundle.getParcelable("med2");
                medicine.setFirstName("esraa");
                medicine.setSecondName("khaled");
                medicine.setStart_date(start_date.getText().toString());
                medicine.setEnd_date(end_date.getText().toString());
                medicine.setLastdoseQuantity( doses_left.getText().toString());
                Toast.makeText(getContext(),"ssssssssssssss",Toast.LENGTH_LONG).show();


               // Medicine m =new Medicine("string","secondname","nsadas",true,"because iam sick","form","weak","strong","5547791","986486",456,"56",1000,true,212598,2272022);


               /* new ConcreteLocalClass(getContext()).insertMedicine(m);

                ConcreteLocalClass.getConcreteLocalClassInstance(getActivity()).insertMedicine(m);
                Toast.makeText(getContext(),"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr",Toast.LENGTH_LONG).show();*/

                repo= Repository.getInstance(remoteSource,localSource,getContext());
                repo.insertMedicine(medicine);


//                medicinePresenterInterface.addMedicineToDataBase(medicine);

            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AddMedActivity.showFragmentSecond();
            }
        });
        return view;
    }
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

    }
}