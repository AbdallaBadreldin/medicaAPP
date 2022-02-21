package eg.iti.pillsmanager.medicinces.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Medicine;


//todo create adapter view
//todo create two on click listeners

//todo create presenter
//todo create interfaces
public class MedicineActivity extends Fragment implements MedicineViewInterface {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_medicine, container, false);

        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }


    @Override
    public void showData(List<Medicine> medicines) {

    }
}
