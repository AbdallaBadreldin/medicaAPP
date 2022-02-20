package eg.iti.pillsmanager.addDrug.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;


public class AddMedicationFragment extends Fragment {
   Button next,back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_medication, container, false);
        next = v.findViewById(R.id.btn_next_add_second);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddMedActivity.showFragmentSecond();
            }
        });
        back = v.findViewById(R.id.btn_back_add_first);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;
    }
}