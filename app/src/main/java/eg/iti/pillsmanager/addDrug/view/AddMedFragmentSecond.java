package eg.iti.pillsmanager.addDrug.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.User;


public class AddMedFragmentSecond extends Fragment {

    Button  next;
    RadioButton select_every_day, select_days_from_week, select_month;
    CheckBox sat_day, sun_day, mon_day, tue_day, wen_day, thu_day, fri_day;
    EditText time_of_med, date_of_med;
    TextView dose_quantity;
    Spinner dose_value;
    RadioGroup select_days;
    int timerHour, timerMinute;
    int days;
    ArrayList<String> days_chosed = new ArrayList<>();
    ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public  View onCreateView(LayoutInflater inflater, ViewGroup container,
                                           Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_med_second, container, false);


        next = view.findViewById(R.id.btn_next_add_second);
        ///////////////////////////////////////////////////////////
        select_days = view.findViewById(R.id.select_days);
        select_every_day = view.findViewById(R.id.every_day);
        select_month = view.findViewById(R.id.select_month);
        select_days_from_week = view.findViewById(R.id.select_days_from_week);
////////////////////////////////////////////////////////
        time_of_med = view.findViewById(R.id.time_of_med);
        sat_day = view.findViewById(R.id.sat_day);
        sun_day = view.findViewById(R.id.sun_day);
        mon_day = view.findViewById(R.id.mon_day);
        tue_day = view.findViewById(R.id.tue_day);
        wen_day = view.findViewById(R.id.wed_day);
        thu_day = view.findViewById(R.id.thu_day);
        fri_day = view.findViewById(R.id.fri_day);
        ///////////////////////////////////////////////////////////////
        date_of_med = view.findViewById(R.id.day_of_month);
        //////////////////////////////////////////////////
        dose_quantity = view.findViewById(R.id.dose_quantity);
        dose_value = view.findViewById(R.id.dose_num);
        String[] arraySpinner = new String[]{
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
                switch (i) {

                    case R.id.every_day:
                        date_of_med.setVisibility(View.INVISIBLE);
                        sat_day.setVisibility(View.INVISIBLE);
                        sun_day.setVisibility(View.INVISIBLE);
                        mon_day.setVisibility(View.INVISIBLE);
                        tue_day.setVisibility(View.INVISIBLE);
                        wen_day.setVisibility(View.INVISIBLE);
                        thu_day.setVisibility(View.INVISIBLE);
                        fri_day.setVisibility(View.INVISIBLE);
                        days = 0;
                        break;
                    case R.id.select_days_from_week:

                        date_of_med.setVisibility(View.INVISIBLE);
                        sat_day.setVisibility(View.VISIBLE);
                        sun_day.setVisibility(View.VISIBLE);
                        mon_day.setVisibility(View.VISIBLE);
                        tue_day.setVisibility(View.VISIBLE);
                        wen_day.setVisibility(View.VISIBLE);
                        thu_day.setVisibility(View.VISIBLE);
                        fri_day.setVisibility(View.VISIBLE);
                        time_of_med.setVisibility(View.VISIBLE);
                        days = 1;
                        break;
                    case R.id.select_month:
                        sat_day.setVisibility(View.INVISIBLE);
                        sun_day.setVisibility(View.INVISIBLE);
                        mon_day.setVisibility(View.INVISIBLE);
                        tue_day.setVisibility(View.INVISIBLE);
                        wen_day.setVisibility(View.INVISIBLE);
                        thu_day.setVisibility(View.INVISIBLE);
                        fri_day.setVisibility(View.INVISIBLE);
                        date_of_med.setVisibility(View.VISIBLE);
                        time_of_med.setVisibility(View.VISIBLE);
                        days = 2;
                        break;


                }
            }
        });

        date_of_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });
        time_of_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int timerHour = calendar.get(Calendar.HOUR_OF_DAY);
                int timerMinute = calendar.get(Calendar.MINUTE);
                openRefillTimePicker();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(sat_day.isChecked()){
                   days_chosed.add("saturday");

                }
                 if(sun_day.isChecked()){
                    days_chosed.add("sunday");
               }
                if(mon_day.isChecked()){
                   days_chosed.add("monday");

               }
                if(tue_day.isChecked()){
                   days_chosed.add("tuesday");

               }
                if(wen_day.isChecked()){
                   days_chosed.add("wednesday");


               }
                if(thu_day.isChecked()){
                   days_chosed.add("thursday");


               }
                if(fri_day.isChecked()){
                   days_chosed.add("friday");

               }


                Bundle bundle = getArguments();
                Medicine medicine = (Medicine) bundle.getSerializable("med1");
               // medicine.setFirstName("esraa");
               // medicine.setSecondName("khaled");
                medicine.setDays(days);
                medicine.setDose_quantity(Integer.parseInt(dose_value.getSelectedItem().toString()));
                medicine.setTimeOfMed(time_of_med.getText().toString());
                medicine.setDateOfMed(date_of_med.getText().toString());
                medicine.setDays_of_week(days_chosed);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("med2", medicine);
                Log.d("myname", medicine.getMedicineName());
                System.out.println("sssssssssssssssssssssssssssssssssssssss" + medicine.getMedicineName());
                AddMedActivity.showFragmentThree(bundle2);
            }
        });


        return view;
    }

    public void openDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                date_of_med.setText(date);
            }
        }, '1', 2, 5);

        datePickerDialog.show();
    }

    public void openRefillTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                timerHour = hourOfDay;
                timerMinute = minute;
                String time = timerHour + ":" + timerMinute;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                try {
                    Date date = simpleDateFormat.parse(time);
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:aa");
                    time_of_med.setText(simpleDateFormat1.format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, 12, 0, false);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timePickerDialog.updateTime(timerHour, timerMinute);
        timePickerDialog.show();
    }


}