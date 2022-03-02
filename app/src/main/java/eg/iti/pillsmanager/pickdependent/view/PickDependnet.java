package eg.iti.pillsmanager.pickdependent.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.User;
import eg.iti.pillsmanager.network.MedicineClient;
import eg.iti.pillsmanager.pickdependent.presenter.PickDependentPresenterInterface;
import eg.iti.pillsmanager.pickdependent.presenter.PickDependetPresenter;


public class PickDependnet extends Fragment implements PickDependentInterface ,OnPickUserClickListener{

    RecyclerView recyclerViewPickDependent;
    PickDependentAdapter pickDependentAdapter;
    PickDependentPresenterInterface pickDependentPresenterInterface;
    Repository repository;
    ConcreteLocalClass concreteLocalClass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_pick_dependent, container, false);


        recyclerViewPickDependent = in.findViewById(R.id.pick_user_recycle);
        recyclerViewPickDependent.setHasFixedSize(true);

        pickDependentAdapter = new PickDependentAdapter(in.getContext(), this);

        LinearLayoutManager activeRefillLayout = new LinearLayoutManager(in.getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewPickDependent.setLayoutManager(activeRefillLayout);
        recyclerViewPickDependent.setAdapter(pickDependentAdapter);

        concreteLocalClass = ConcreteLocalClass.getConcreteLocalClassInstance(in.getContext());

        repository = Repository.getInstance(MedicineClient.getMedicineClientInstance(), concreteLocalClass,getContext());

        pickDependentPresenterInterface = new PickDependetPresenter(this, repository);
        pickDependentPresenterInterface.getAllUsers(getActivity());

        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    @Override
    public void pickUser(User user) {

    }

    @Override
    public void showList(List<User> users) {
        pickDependentAdapter.setActiveUsersList(users);
        pickDependentAdapter.notifyDataSetChanged();
    }
}
