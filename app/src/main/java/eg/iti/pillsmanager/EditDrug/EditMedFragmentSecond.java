package eg.iti.pillsmanager.EditDrug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;


public class EditMedFragmentSecond extends Fragment {
  Button back_btn,next_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_med_second, container, false);
        back_btn = view.findViewById(R.id.btn_back_add_two);
        next_btn = view.findViewById(R.id.btn_next_add_second);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Edit_medActivity.showFragmentone();
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Edit_medActivity.showFragmentThree();
            }
        });
        return view;
    }
}