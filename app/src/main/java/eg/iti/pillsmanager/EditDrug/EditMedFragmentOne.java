package eg.iti.pillsmanager.EditDrug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;


public class EditMedFragmentOne extends Fragment {

    TextView name_of_med,form_of_med,reason_of_med,strength_of_med;
    EditText name_med_value,reason_med_value,form_med_value;
    Spinner strength_num,strength_unit;
   Button next_btn,back_btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_edit_med_first, container, false);
        next_btn = view.findViewById(R.id.btn_next_add_second);
        back_btn = view.findViewById(R.id.btn_back_add_first);
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

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_medActivity.showFragmentSecond();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }
}