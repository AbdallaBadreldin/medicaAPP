package eg.iti.pillsmanager.addDrug.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;


public class AddMedicationFragment extends Fragment {
   Button next,back;
   TextView name_of_med,form_of_med,reason_of_med,strength_of_med;
   EditText name_med_value,reason_med_value,form_med_value;
   Spinner strength_num,strength_unit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_medication, container, false);
        next = v.findViewById(R.id.btn_go_to_fragment_two);
        back = v.findViewById(R.id.btn_go_to_madication_activity);
/////////////////////////////////////////////////////////////\
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
        strength_unit=v.findViewById(R.id.med_concentration_symbol);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddMedActivity.showFragmentSecond();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MainActivity.class));
                AddMedActivity.showFragmentMedication();
            }
        });
        return v;
    }
}