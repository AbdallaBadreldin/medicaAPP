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

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenter;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenterInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.network.MedicineClient;



public class AllMedicineActivity extends Fragment implements AllMedicineViewInterface,OnMedicineClickListener {

    RecyclerView recyclerViewActiveMedicines;
    RecyclerView recyclerViewInactiveMedicines;
    ActiveMedicineAdapter activeMedicineAdapter;
    InactiveMedicineAdapter inactiveActiveMedicineAdapter;
    MedicinePresenterInterface medicinePresenterInterface;
    Repository repository;
//     movieClient;
    ConcreteLocalClass concreteLocalClass;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_medicine, container, false);

        recyclerViewActiveMedicines = in.findViewById(R.id.medicine_recycler_view_active);
        recyclerViewActiveMedicines.setHasFixedSize(true);

        recyclerViewInactiveMedicines = in.findViewById(R.id.medicine_recycler_view_inactive);
        recyclerViewInactiveMedicines.setHasFixedSize(true);

        activeMedicineAdapter = new ActiveMedicineAdapter(in.getContext(), this);
        inactiveActiveMedicineAdapter = new InactiveMedicineAdapter(in.getContext().getApplicationContext(), this);



        LinearLayoutManager activeMedicinesLayout = new LinearLayoutManager(in.getContext(), LinearLayoutManager.HORIZONTAL, false);
//        arrayListUser.setLayoutManager(activeMedicinesLayout);

        LinearLayoutManager inactiveMedicinesLayout = new LinearLayoutManager(in.getContext(), LinearLayoutManager.VERTICAL, false);
//        arrayList.setLayoutManager(listManager);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(in.getContext());
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);


        //active list
        recyclerViewActiveMedicines.setLayoutManager(activeMedicinesLayout);
        recyclerViewActiveMedicines.setAdapter(activeMedicineAdapter);

        //in active list
        recyclerViewInactiveMedicines.setLayoutManager(inactiveMedicinesLayout);
        recyclerViewInactiveMedicines.setAdapter(inactiveActiveMedicineAdapter);

        concreteLocalClass = ConcreteLocalClass.getConcreteLocalClassInstance(in.getContext());

        repository = Repository.getRepositoryInstance(new MedicineClient.getMovieClientInstance(), concreteLocalClass);

        medicinePresenterInterface = new MedicinePresenter(this, repository);
        medicinePresenterInterface.getActiveMedication(this);
        medicinePresenterInterface.getInactiveMedication(this);

        //shared pereference  String firstName =
//        medicinePresenterInterface.addMedicineToDataBase(new Medicine("boda","badr","congestal",true ,"for testing only","pills",500,"power",2555,65,554,65,true));
//        medicinePresenterInterface.addMedicineToDataBase(new Medicine("boda","badr","revo",false ,"for testing only","pills",500,"power",2555,65,554,65,true));

        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }




    @Override
    public void openAlarms(Medicine medicine) {
        //startActivity(in alarms);
    }

    @Override
    public void openEdit(Medicine medicine) {
        //startactivity(intent edit);
    }

    @Override
    public void openMedicine(Medicine medicine) {
        //todo ersaa's tasks
    }

    @Override
    public void showActiveMedicines(List<Medicine> medicines) {
        activeMedicineAdapter.setActiveMedicinesList(medicines);
        activeMedicineAdapter.notifyDataSetChanged();
    }

    @Override
    public void showInactiveMedicines(List<Medicine> medicines) {
        inactiveActiveMedicineAdapter.setInactiveMedicinesList(medicines);
        inactiveActiveMedicineAdapter.notifyDataSetChanged();
    }

}
