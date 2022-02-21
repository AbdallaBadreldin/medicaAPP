package eg.iti.pillsmanager.addDrug.view;

import android.os.Bundle;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import eg.iti.pillsmanager.R;


public class AddMedFragmentSecond extends Fragment {

Button back,next;
FloatingActionButton floatingActionButton;
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
         View view=inflater.inflate(R.layout.fragment_add_med_second, container, false);
         back = view.findViewById(R.id.btn_back_add_two);
        next =view.findViewById(R.id.btn_next_add_second);
        floatingActionButton =view.findViewById(R.id.btn_alarm_add_second);
        ///////////////////////////////////////////////////////////
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
        //////////////////////////////////////////////

        back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              AddMedActivity.showFragmentone();
             }
         });

         next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AddMedActivity.showFragmentThree();
             }
         });

        return view;
    }
}