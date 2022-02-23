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

  /*  @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText date;
        date = view.findViewById(R.id.start_date);

        TextWatcher tw = new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day = Integer.parseInt(clean.substring(0, 2));
                        int mon = Integer.parseInt(clean.substring(2, 4));
                        int year = Integer.parseInt(clean.substring(4, 8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon - 1);
                        year = (year < 1900) ? 1900 : (year > 2100) ? 2100 : year;
                        cal.set(Calendar.YEAR, year);


                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
                        clean = String.format("%02d%02d%02d", day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    date.setText(current);
                    date.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        date.addTextChangedListener(tw);


    }
*/}