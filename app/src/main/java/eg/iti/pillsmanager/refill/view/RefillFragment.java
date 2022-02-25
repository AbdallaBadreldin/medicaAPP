package eg.iti.pillsmanager.refill.view;


import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenterInterface;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.network.MedicineClient;
import eg.iti.pillsmanager.refill.presenter.RefillPresenter;
import eg.iti.pillsmanager.refill.presenter.RefillPresenterInterface;
import eg.iti.pillsmanager.utility.NotifyWorker;
@SuppressLint("NotifyDataSetChanged")
public class RefillFragment extends Fragment implements RefillFragmentInterface ,OnRefillClickListenerInterface{
    //we set a tag to be able to cancel all work of this type if needed
    public static final String workTag = "notificationWork";

    RecyclerView recyclerViewActiveMedicines;
    RefillAdapter activeRefillAdapter;
    RefillPresenterInterface refillPresenterInterface;
    Repository repository;
    ConcreteLocalClass concreteLocalClass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_refill, container, false);
        triggerNotifyWork();


        recyclerViewActiveMedicines = in.findViewById(R.id.refill_recycle);
        recyclerViewActiveMedicines.setHasFixedSize(true);

        activeRefillAdapter = new RefillAdapter(in.getContext(), this);

        LinearLayoutManager activeRefillLayout = new LinearLayoutManager(in.getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewActiveMedicines.setLayoutManager(activeRefillLayout);
        recyclerViewActiveMedicines.setAdapter(activeRefillAdapter);

        concreteLocalClass = ConcreteLocalClass.getConcreteLocalClassInstance(in.getContext());

        repository = Repository.getInstance(MedicineClient.getMedicineClientInstance(), concreteLocalClass,getContext());

        refillPresenterInterface = new RefillPresenter(this, repository);
        refillPresenterInterface.getActiveMedication(getActivity());

        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    //binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    public void triggerNotifyWork(){
        Constraints constraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(NotifyWorker.class, 900000, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
                .build();

        WorkManager workManager = WorkManager.getInstance(getContext());
        workManager.enqueueUniquePeriodicWork("Counter", ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest);
//        Toast.makeText(getActivity(), "🎉 Scheduled job!", Toast.LENGTH_SHORT).show();

    }

    public void RetriggerWorkManager() {
        WorkManager.getInstance(getContext()).cancelAllWork();
        //store DBEventID to pass it to the PendingIntent and open the appropriate event page on notification click
        Data inputData = new Data.Builder().putInt(getString(R.string.db_event_id_tag), Integer.parseInt(getString(R.string.db_Event_id))).build();
         // we then retrieve it inside the NotifyWorker with:
        // final int DBEventID = getInputData().getInt(DBEventIDTag, ERROR_VALUE);

        OneTimeWorkRequest notificationWork = new OneTimeWorkRequest.Builder(NotifyWorker.class)
                .setInitialDelay(5000 , TimeUnit.MILLISECONDS)
                .setInputData(inputData)
                .addTag(workTag)
                .build();
        WorkManager.getInstance(getActivity().getApplicationContext()).enqueue(notificationWork);


    }


    @Override
    public void changeRefillReminderStatus(Medicine medicine ) {
    //here 'm gonna change status of check button

        if(medicine.isActiveRefillReminder())
        {
            medicine.setActiveRefillReminder(false);
            Toast.makeText(getContext(), medicine.getMedicineName(), Toast.LENGTH_SHORT).show();

           updateMedicine(medicine);
        }
        else { Toast.makeText(getContext(), medicine.getMedicineName()+ "FALSE", Toast.LENGTH_SHORT).show();
            medicine.setActiveRefillReminder(true);
            updateMedicine(medicine);    }
    }

    @Override
    public void refillMedicine(Medicine medicine) {

    }

    @Override
    public void showList(List<Medicine> medicines) {

        activeRefillAdapter.setRefillMedicinesList((ArrayList<Medicine>)medicines);
        activeRefillAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateMedicine(Medicine medicine) {
    refillPresenterInterface.updateRefillActiveStatue(medicine);
    }
}
