package eg.iti.pillsmanager.medicinces.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.EditDrug.Edit_medActivity;
import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedActivity;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.dosemanager.view.DoseManagerActivity;
import eg.iti.pillsmanager.displaydrug.view.DisplayDrug;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenter;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenterInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.network.MedicineClient;



public class MediciationsFragment extends Fragment implements AllMedicineViewInterface,OnMedicineClickListener {
    FloatingActionButton add_alarm;
    RecyclerView recyclerViewActiveMedicines;
    RecyclerView recyclerViewInactiveMedicines;
    ActiveMedicineAdapter activeMedicineAdapter;
    InactiveMedicineAdapter inactiveActiveMedicineAdapter;
     Medicine medicine;
    MedicinePresenterInterface medicinePresenterInterface;
    Repository repository;
    ConcreteLocalClass concreteLocalClass;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_medicine, container, false);


        add_alarm = in.findViewById(R.id.btn_add_medication);
        Medicine med = new Medicine();
        add_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddMedActivity.class);
                intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT );
                startActivity(intent);
            }
        });

        recyclerViewActiveMedicines = in.findViewById(R.id.medicine_recycler_view_active);
        recyclerViewActiveMedicines.setHasFixedSize(true);

        recyclerViewInactiveMedicines = in.findViewById(R.id.medicine_recycler_view_inactive);
        recyclerViewInactiveMedicines.setHasFixedSize(true);

        activeMedicineAdapter = new ActiveMedicineAdapter(in.getContext(), this);
        inactiveActiveMedicineAdapter = new InactiveMedicineAdapter(in.getContext().getApplicationContext(), this);


        LinearLayoutManager activeMedicinesLayout = new LinearLayoutManager(in.getContext(), LinearLayoutManager.VERTICAL, false);
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

        repository = Repository.getInstance(MedicineClient.getMedicineClientInstance(), concreteLocalClass,getContext());

        medicinePresenterInterface = new MedicinePresenter(this, repository);
        medicinePresenterInterface.getActiveMedication(this);
        medicinePresenterInterface.getInactiveMedication(this);

        //shared pereference  String firstName =
        medicinePresenterInterface.addMedicineToDataBase(new Medicine("email.com","boda1","cong",true,"test porposel","form",5,"HIFIVE","6564688","684646",565,57,564,true,"64465546","safdsafasdf",5,45,5,new ArrayList<String>()));
        medicinePresenterInterface.addMedicineToDataBase(new Medicine("emsadail.com","boda2","congestal",false,"test porposel","form",5,"HIFIVE","6564688","684646",565,57,564,true,"64465546","safdsafasdf",5,45,5,new ArrayList<String>()));
        medicinePresenterInterface.addMedicineToDataBase(new Medicine("email.com","boda3","cong",false,"test porposel","form",5,"HIFour","6564688","684646",565,57,564,true,"64465546","safdsafasdf",5,45,5,new ArrayList<String>()));
//        medicinePresenterInterface.addMedicineToDataBase(new Medicine("boda","badr","revo",false ,"for testing only","pills",500,"power",2555,65,554,65,true));

        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void openAlarms(Medicine medicine) {
        //startActivity(in alarms);

        //start activity or fragment or what ever you want to add doses      //thankx

//        lma ydos 3la el alarm yft7
        /*
        in three ways
                1 in add medication
                2 create new activity
            3 use old fragment*/



        
        
        
        
        /////////   m4 mogpda enty aly htwGDEHA
//        or WHATEVER YOU WANT
//        JUST PLEASE DO IT IN TIME
        //todo esraa    //alarm shape


        Intent intent = new Intent(getActivity(), DoseManagerActivity.class);
        startActivity(intent);
    }

    @Override
    public void openEdit(Medicine medicine) {
        //todo esraa     //   pen -- edit shape
        Intent intent = new Intent(getActivity(),  Edit_medActivity.class);
        intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT );
        intent.putExtra("med",medicine);
        startActivity(intent);



    }

    @Override
    public void openMedicine(Medicine medicine) {

        Intent intent = new Intent(getActivity(),  DisplayDrug.class);
        intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT );
        intent.putExtra("med",medicine);
        startActivity(intent);





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
