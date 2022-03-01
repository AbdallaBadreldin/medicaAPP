package eg.iti.pillsmanager.addDrug.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.User;


public class AddMedicationFragment extends Fragment  {
   Button next;
   TextView name_of_med,form_of_med,reason_of_med,strength_of_med;
   EditText name_med_value,reason_med_value;
   Spinner strength_num,strength_unit,form_med_value;
   Medicine med;
   Bundle bundle;
    SharedPreferences sharedPreferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_medication, container, false);
        next = v.findViewById(R.id.btn_go_to_fragment_two);
/////////////////////////////////////////////////////////////
        name_of_med = v.findViewById(R.id.name_of_med);
        form_of_med = v.findViewById(R.id.form_of_med);
        reason_of_med = v.findViewById(R.id.reason_of_med);
        strength_of_med = v.findViewById(R.id.strength_of_med);
        /////////////////////////////////////////////////////////////////////////
        name_med_value=v.findViewById(R.id.value_of_name_med);
        reason_med_value=v.findViewById(R.id.value_of_reason_med);
        form_med_value=v.findViewById(R.id.form_of_med_value);
        ///////////////////////////////////////////////////////////
        strength_num=v.findViewById(R.id.med_concentration_num);
        String[] arraySpinner = new String[] {
                "100", "200", "300", "400", "500", "600", "700"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strength_num.setAdapter(adapter);
        /////////////////////////////////////
        strength_unit=v.findViewById(R.id.med_concentration_symbol);
        String[] arraySpinner2 = new String[] {
                "g", "IU", "mcg"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strength_unit.setAdapter(adapter2);
        String[] arraySpinner3 = new String[] {
                "pills", "solution", "injection","powder","drops","Inhaler"
        };
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arraySpinner3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        form_med_value.setAdapter(adapter3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 med = new Medicine();
                bundle = new Bundle();
                /* SharedPreferences  sharedPreferences = getActivity().getSharedPreferences(getString(R.string.signup_shared_pre), Context.MODE_PRIVATE);

               String name= sharedPreferences.getString(getString(R.string.name_shared_pre),"name is null");
                Log.i("TAG", "onClick: "+name);
               med.setUser(new User(name,"khaled",0,"","","",""));*/

                sharedPreferences = getActivity().getSharedPreferences(getString(R.string.signup_shared_pre), Context.MODE_PRIVATE);
                String name= sharedPreferences.getString(getString(R.string.name_shared_pre),"name is null");
                System.out.println("nameeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+name);
                Log.i("TAG", "onClick: "+name);
                // med.setUser(new User(name,"farag",23,"esraa@gmail.com","123","4","female"));
                 med.setFirstName(name);
                //med.setSecondName("khaled");
                med.setMedicineName(name_med_value.getText().toString());
                med.setForm(form_med_value.getSelectedItem().toString());
                med.setReason(reason_med_value.getText().toString());
                med.setStrengthValue(Integer.parseInt(strength_num.getSelectedItem().toString()));
                med.setStrength(strength_unit.getSelectedItem().toString());
                med.setActive(true);
               // med.setDose(new Dose());
                bundle.putSerializable("med1",med);
                AddMedActivity.showFragmentSecond(bundle);

            }
        });



        return v;
    }
}