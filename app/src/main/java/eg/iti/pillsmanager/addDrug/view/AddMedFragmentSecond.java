package eg.iti.pillsmanager.addDrug.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;


public class AddMedFragmentSecond extends Fragment {

Button back,next;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_add_med_second, container, false);
         back = view.findViewById(R.id.btn_back_add_two);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              AddMedActivity.showFragmentone();
             }
         });
         next =view.findViewById(R.id.btn_next_add_second);
         next.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AddMedActivity.showFragmentThree();
             }
         });

        return view;
    }
}