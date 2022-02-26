package eg.iti.pillsmanager.adddependent.view;

import android.app.ActionBar;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.adddependent.presenter.AddDependentPresenter;
import eg.iti.pillsmanager.adddependent.presenter.AddDependentPresenterInterface;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.medicinces.presenter.MedicinePresenter;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.model.User;
import eg.iti.pillsmanager.network.MedicineClient;

public class AddDependentFragment extends Fragment implements AddDependentInterface {
    TextView firstNameTxt;
    TextView secondNameTxt;
    RadioGroup gender;
    Button savebtn;
    String genderStr;

    ConcreteLocalClass concreteLocalClass;
    Repository repository;
    AddDependentPresenterInterface addDependentPresenterInterface;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_add_dependent, container, false);
        firstNameTxt = in.findViewById(R.id.editTextTextPersonFirstName);
        secondNameTxt = in.findViewById(R.id.editTextTextPersonLastName);
                gender =in.findViewById(R.id.radioButtonGender);
              savebtn = in.findViewById(R.id.add_delete_button);


        concreteLocalClass = ConcreteLocalClass.getConcreteLocalClassInstance(in.getContext());

        repository = Repository.getInstance( MedicineClient.getMedicineClientInstance(), concreteLocalClass,getContext());

        addDependentPresenterInterface = new AddDependentPresenter(this, repository);
                savebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String fName= firstNameTxt.getText().toString().trim();
                        String sName= secondNameTxt.getText().toString().trim();
                        int id = gender.getCheckedRadioButtonId();
                        if (fName.isEmpty()||sName.isEmpty()|| id==-1)
                            Toast.makeText(in.getContext(), getString(R.string.please_enter_valid_data), Toast.LENGTH_SHORT).show();
                            else {
                            switch (id) {
                                case 0:
                                    genderStr = "male";
                                    break;
                                case 1:
                                    genderStr = "female";
                                    break;
                                default:
                                    genderStr = "other";
                            }
                            User use = new User(fName,sName , 0, "", "", "", genderStr);
                            addDependentPresenterInterface.addUserToDataBase(use);

                        }                    }
                });

//        System.out.println(gender.toString());
          return in;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.add_dependent_menu_bar, menu);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu_done: {

                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    @Override
    public void showFeedBack() {
        Toast.makeText(getView().getContext(), getString(R.string.done), Toast.LENGTH_SHORT).show();
    }
}
