package eg.iti.pillsmanager.EditDrug;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedActivity;
import eg.iti.pillsmanager.model.Medicine;


public class EditMedFragmentSecond extends Fragment {
    Button back,next,add_alarm;
    RadioButton select_every_day,select_days_from_week,select_month;
    TimePicker time_of_med;
    CheckBox sat_day,sun_day,mon_day,tue_day,wen_day,thu_day,fri_day;
    DatePicker date_of_med;
    TextView dose_quantity;
    Spinner dose_value;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_med_second, container, false);
        back = view.findViewById(R.id.btn_back_add_two);
        next =view.findViewById(R.id.btn_next_add_second);
       // add_alarm =view.findViewById(R.id.btn_alarm_add_second);
        ///////////////////////////////////////////////////////////
        select_every_day =view.findViewById(R.id.every_day);
        select_month =view.findViewById(R.id.select_month);
        select_days_from_week=view.findViewById(R.id.select_days_from_week);
////////////////////////////////////////////////////////
        time_of_med=view.findViewById(R.id.time_of_med);
        sat_day=view.findViewById(R.id.select_days_from_week);
        sun_day=view.findViewById(R.id.select_days_from_week);
        mon_day=view.findViewById(R.id.select_days_from_week);
        tue_day=view.findViewById(R.id.select_days_from_week);
        wen_day=view.findViewById(R.id.select_days_from_week);
        thu_day=view.findViewById(R.id.select_days_from_week);
        fri_day=view.findViewById(R.id.select_days_from_week);
        ///////////////////////////////////////////////////////////////
        date_of_med=view.findViewById(R.id.day_of_month);
        //////////////////////////////////////////////////
        dose_quantity= view.findViewById(R.id.dose_quantity);
        dose_value=view.findViewById(R.id.dose_num);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Edit_medActivity.showFragmentone();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                Medicine medicine = bundle.getParcelable("med1");

                medicine.setLastdoseQuantity( dose_value.getSelectedItem().toString());
              //  medicine.setTimeOfMed(time_of_med.ge);
              //  medicine.setDateOfMed(date_of_med.);
                Bundle bundle2 = new Bundle();
              //  bundle2.putParcelable("med2",medicine);
                Log.d("myname",medicine.getMedicineName());
                System.out.println("sssssssssssssssssssssssssssssssssssssss"+medicine.getMedicineName());
                AddMedActivity.showFragmentThree(bundle2);
            }
        });
        return view;
    }
}