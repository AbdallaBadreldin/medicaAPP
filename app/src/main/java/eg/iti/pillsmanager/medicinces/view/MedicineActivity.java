package eg.iti.pillsmanager.medicinces.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenter;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenterInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.network.MedicineClient;
import eg.iti.pillsmanager.network.NetworkDelegate;


//todo create adapter view
//todo create two on click listeners

//todo create presenter
//todo create interfaces
public class MedicineActivity extends Fragment implements MedicineViewInterface,OnMedicineClickListener {

    RecyclerView recyclerView;
    MedicineAdapter medicineAdapter;
    MedicinePresenterInterface medicinePresenterInterface;
    Repository repository;
//     movieClient;
    ConcreteLocalClass concreteLocalClass;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View in =inflater.inflate(R.layout.fragment_medicine, container, false);

        recyclerView = in.findViewById(R.id.medicine_recycler_view_active);
        recyclerView.setHasFixedSize(true);


        medicineAdapter = new MedicineAdapter(in.getContext(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(in.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(medicineAdapter);


        concreteLocalClass = ConcreteLocalClass.getConcreteLocalClassInstance(in.getContext());


        repository = Repository.getRepositoryInstance(new MedicineClient.getMovieClientInstance(), concreteLocalClass);

        medicinePresenterInterface = new MedicinePresenter(this, repository);
        medicinePresenterInterface.getActiveMedication(this);

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

    @Override
    public void openAlarms(Medicine medicine) {

    }

    @Override
    public void openEdit(Medicine medicine) {

    }

    @Override
    public void openMedicine(Medicine medicine) {

    }
}
