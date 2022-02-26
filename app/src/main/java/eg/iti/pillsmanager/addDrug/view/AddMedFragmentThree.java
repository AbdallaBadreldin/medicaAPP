package eg.iti.pillsmanager.addDrug.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.SplashActivity;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.RepositoryInterface;
import eg.iti.pillsmanager.network.RemoteSource;


public class AddMedFragmentThree extends Fragment {
    TextView treatment_duration,quantity_of_med,med_value,additional_dose,refill_at_dose,last_dose_quantity;
    Button save_btn,back_btn,med_btn;
    EditText  total_doses,add_dose_quantity,start_date,end_date,refill_at_dose_num,last_dose_num;
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
        total_doses=view.findViewById(R.id.total_doses);
        additional_dose = view.findViewById(R.id.btn_add_additional_dose);
        add_dose_quantity = view.findViewById(R.id.additional_dose);
        med_btn = view.findViewById(R.id.btn_display_all_med);
        ///////////////////////////////////////////
        refill_at_dose=view.findViewById(R.id.txt_refill_reminder_At);
        refill_at_dose_num=view.findViewById(R.id.refill_at_dose_no);
        last_dose_quantity=view.findViewById(R.id.txt_last_dose_quantity);
        last_dose_num= view.findViewById(R.id.last_dose_num);
        back_btn=view.findViewById(R.id.btn_back_to_home);
        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //showDatePickerDialog(view);
                openDatePicker();

            }
        });

        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //showDatePickerDialog(view);
                openDatePickerdate2();            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                Medicine medicine = (Medicine) bundle.getSerializable("med2");
                medicine.setStart_date(start_date.getText().toString());
                medicine.setEnd_date(end_date.getText().toString());
                medicine.setTotalQuantity(total_doses.getText().toString());
                medicine.setAdd_dose_quantity(add_dose_quantity.getText().toString());
                medicine.setQuantityRemindAt(refill_at_dose_num.getText().toString());
                medicine.setLastdoseQuantity(last_dose_num.getText().toString());
                Toast.makeText(getContext(),"ssssssssssssss",Toast.LENGTH_LONG).show();

               if((medicine.getQuantityRemindAt()==medicine.getLastdoseQuantity())||(medicine.getQuantityRemindAt()==medicine.getTotalQuantity()))
               {
                   medicine.setActiveRefillReminder(true);
               }


                repo= Repository.getInstance(remoteSource,localSource,getContext());
                repo.insertMedicine(medicine);

            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT );
                startActivity(intent);
            }
        });
        med_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                AddMedActivity.showFragmentAllMed(bundle);
            }
        });
        return view;
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

    }
    public void openDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
              start_date.setText(date);
            }
        }, '1', 2, 5);

        datePickerDialog.show();
    }


    public void openDatePickerdate2() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                end_date.setText(date);
            }
        }, '1', 2, 5);

        datePickerDialog.show();
    }

}