package eg.iti.pillsmanager.addDrug.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Medicine;


public class AddMedFragmentSecond extends Fragment {

Button back,next;
FloatingActionButton floatingActionButton;
RadioButton select_every_day,select_days_from_week,select_month;
TimePicker time_of_med;
CheckBox sat_day,sun_day,mon_day,tue_day,wen_day,thu_day,fri_day;
DatePicker date_of_med;
TextView dose_quantity;
Spinner dose_value;
RadioGroup select_days;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_med_second, container, false);





         back = view.findViewById(R.id.btn_back_add_two);
        next =view.findViewById(R.id.btn_next_add_second);
        floatingActionButton =view.findViewById(R.id.btn_alarm_add_second);
        ///////////////////////////////////////////////////////////
        select_days = view.findViewById(R.id.select_days);
        select_every_day =view.findViewById(R.id.every_day);
        select_month =view.findViewById(R.id.select_month);
        select_days_from_week=view.findViewById(R.id.select_days_from_week);
////////////////////////////////////////////////////////
        time_of_med=view.findViewById(R.id.time_of_med);
        sat_day=view.findViewById(R.id.sat_day);
        sun_day=view.findViewById(R.id.sun_day);
        mon_day=view.findViewById(R.id.mon_day);
        tue_day=view.findViewById(R.id.tue_day);
        wen_day=view.findViewById(R.id.wed_day);
        thu_day=view.findViewById(R.id.thu_day);
        fri_day=view.findViewById(R.id.fri_day);
        ///////////////////////////////////////////////////////////////
        date_of_med=view.findViewById(R.id.day_of_month);
        //////////////////////////////////////////////////
        dose_quantity= view.findViewById(R.id.dose_quantity);
        dose_value=view.findViewById(R.id.dose_num);
        String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dose_value.setAdapter(adapter);
        //////////////////////////////////////////////
       select_days.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                                      if (select_every_day.isChecked()) {
                                                          date_of_med.setVisibility(View.INVISIBLE);
                                                          sat_day.setVisibility(View.INVISIBLE);
                                                          sun_day.setVisibility(View.INVISIBLE);
                                                          mon_day.setVisibility(View.INVISIBLE);
                                                          tue_day.setVisibility(View.INVISIBLE);
                                                          wen_day.setVisibility(View.INVISIBLE);
                                                          thu_day.setVisibility(View.INVISIBLE);
                                                          fri_day.setVisibility(View.INVISIBLE);


                                                      }
                                                      else if(select_month.isChecked()){
                                                          sat_day.setVisibility(View.INVISIBLE);
                                                          sun_day.setVisibility(View.INVISIBLE);
                                                          mon_day.setVisibility(View.INVISIBLE);
                                                          tue_day.setVisibility(View.INVISIBLE);
                                                          wen_day.setVisibility(View.INVISIBLE);
                                                          thu_day.setVisibility(View.INVISIBLE);
                                                          fri_day.setVisibility(View.INVISIBLE);
                                                          date_of_med.setVisibility(View.VISIBLE);
                                                          time_of_med.setVisibility(View.VISIBLE);

                                                      }
                                                      else{
                                                          date_of_med.setVisibility(View.INVISIBLE);
                                                          sat_day.setVisibility(View.VISIBLE);
                                                          sun_day.setVisibility(View.VISIBLE);
                                                          mon_day.setVisibility(View.VISIBLE);
                                                          tue_day.setVisibility(View.VISIBLE);
                                                          wen_day.setVisibility(View.VISIBLE);
                                                          thu_day.setVisibility(View.VISIBLE);
                                                          fri_day.setVisibility(View.VISIBLE);
                                                          time_of_med.setVisibility(View.VISIBLE);

                                                      }

                                                  }
                                              } );
        back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              AddMedActivity.showFragmentone();

             }
         });

         next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Bundle bundle = getArguments();
                 Medicine medicine = bundle.getParcelable("med1");

                 medicine.setLastdoseQuantity( dose_value.getSelectedItem().toString());
                 medicine.setTimeOfMed(time_of_med.getHour());
                 medicine.setDateOfMed(date_of_med.getDayOfMonth());
                 Bundle bundle2 = new Bundle();
                 bundle2.putParcelable("med2",medicine);
                 Log.d("myname",medicine.getMedicineName());
                 System.out.println("sssssssssssssssssssssssssssssssssssssss"+medicine.getMedicineName());
                 AddMedActivity.showFragmentThree(bundle2);
             }
         });






        return view;
    }


}