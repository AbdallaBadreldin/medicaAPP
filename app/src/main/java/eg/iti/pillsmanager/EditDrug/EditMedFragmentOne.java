

package eg.iti.pillsmanager.EditDrug;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedActivity;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.model.Dose;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.RepositoryInterface;
import eg.iti.pillsmanager.network.RemoteSource;


public class EditMedFragmentOne extends Fragment {

    TextView name_of_med,form_of_med,reason_of_med,strength_of_med;
    EditText name_med_value,reason_med_value;
    Spinner strength_num,strength_unit,form_med_value;
    Button next_btn;
    Bundle bundle;
    Medicine medicine;
    RepositoryInterface repo;
    RemoteSource remoteSource;
    Medicine med;
    LocalSource localSource;
    SharedPreferences  sharedPreferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_edit_med_first, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        next_btn = view.findViewById(R.id.btn_next_add_second);
        //////////////////////////////////////////////////////////////
        name_of_med = view.findViewById(R.id.name_of_med);
        form_of_med = view.findViewById(R.id.form_of_med);
        reason_of_med = view.findViewById(R.id.reason_of_med);
        strength_of_med = view.findViewById(R.id.strength_of_med);
        /////////////////////////////////////////////////////////////////////////
        name_med_value=view.findViewById(R.id.value_of_name_med);
        reason_med_value=view.findViewById(R.id.value_of_reason_med);
        form_med_value=view.findViewById(R.id.form_of_med_value);
        ///////////////////////////////////////////////////////////
        strength_num=view.findViewById(R.id.med_concentration_num);
        strength_unit=view.findViewById(R.id.med_concentration_symbol);
        String[] arraySpinner = new String[] {
                "100", "200", "300", "400", "500", "600", "700"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strength_num.setAdapter(adapter);
        /*TextView textView = (TextView)strength_num.getSelectedView();
        String result = textView.getText().toString();*/
        /////////////////////////////////////
        strength_unit=view.findViewById(R.id.med_concentration_symbol);
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

         medicine = (Medicine) bundle.getSerializable("med"); /////////////////////////////

        Log.v("MEDICENE_FROM_EDIT_MED",medicine.getMedicineName());
        medicine.getFirstName();
        medicine.getEmail();
        name_med_value.setVisibility(View.INVISIBLE);
        //name_med_value.setText(medicine.getMedicineName());
        reason_med_value.setText(medicine.getReason());
        medicine.setForm(form_med_value.getSelectedItem().toString());
        medicine.setStrengthValue(Integer.parseInt(strength_num.getSelectedItem().toString()));
        medicine.getFirstName();
        medicine.getEmail();
        medicine.setStrength(strength_unit.getSelectedItem().toString());
        medicine.setActive(true);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Bundle bun = new Bundle();
           bun.putSerializable("med",medicine);      // new code
                medicine.setReason(reason_med_value.getText().toString());
                //medicine.setMedicineName(name_med_value.getText().toString());
                bundle.putSerializable("med",medicine);      // older code
                Edit_medActivity.showFragmentSecond(bun);
            }
        });



















    }
}