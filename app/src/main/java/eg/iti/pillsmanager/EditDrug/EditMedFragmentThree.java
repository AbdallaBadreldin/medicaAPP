package eg.iti.pillsmanager.EditDrug;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.DatePickerFragment;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.model.RepositoryInterface;
import eg.iti.pillsmanager.network.RemoteSource;


public class EditMedFragmentThree extends Fragment {
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

        View view = inflater.inflate(R.layout.fragment_edit_med_three, container, false);
        start_date=view.findViewById(R.id.start_date);
        end_date=view.findViewById(R.id.end_date);
        //////////////////////////////////////////////////
        save_btn=view.findViewById(R.id.btn_save_add_three);
        back_btn=view.findViewById(R.id.btn_back_add_two);
///////////////////////////////////////////////////////////////////
        treatment_duration=view.findViewById(R.id.treatment_duration);
        quantity_of_med=view.findViewById(R.id.Quantity_of_med);
        med_value=view.findViewById(R.id.Quantity_of_med_value);
        doses_left=view.findViewById(R.id.total_doses);

        end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showDatePickerDialog(view);
                openDatePickerdate2();
            }
        });
        start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // showDatePickerDialog(view);
                openDatePicker();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Edit_medActivity.showFragmentSecond(bundle);
            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
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