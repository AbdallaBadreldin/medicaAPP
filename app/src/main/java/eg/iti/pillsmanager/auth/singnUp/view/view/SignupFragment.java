package eg.iti.pillsmanager.auth.singnUp.view.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.auth.singnIn.view.SignInActivity;
import eg.iti.pillsmanager.auth.singnUp.presenter.SignUpPresenter;
import eg.iti.pillsmanager.model.User;


public class SignupFragment extends Fragment implements AuthAsyncCallBackI {
    EditText signUpFullName,signUpEmail,signUpPassword,signUpConfirmPassword;
    Button buttonRegister;
    TextView goToLoginRegister;
    SignupFragment signupFragment;
    SignUpPresenter signUpPresenter;

    /////////
    SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       signUpPresenter = new SignUpPresenter();
       signupFragment = this;
       View view = inflater.inflate(R.layout.fragment_signup, container, false);
        signUpFullName = view.findViewById(R.id.signup_fullname);
        signUpEmail = view.findViewById(R.id.signup_email);
        signUpPassword = view.findViewById(R.id.signup_password);
        signUpConfirmPassword = view.findViewById(R.id.signup_confirmpassword);
        buttonRegister = view.findViewById(R.id.button_register);
        goToLoginRegister = view.findViewById(R.id.button_gotologin_register);

        //////////
        sharedPreferences = getActivity().getSharedPreferences(getString(R.string.signup_shared_pre), Context.MODE_PRIVATE);

        goToLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignInActivity.showFragmentSignIn();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signUpFullName.getText().toString().isEmpty()){
                    signUpFullName.setError(getString(R.string.fullname_is_missing));
                    return;
                }

                if(signUpEmail.getText().toString().isEmpty()){
                    signUpEmail.setError(getString(R.string.email_is_missing));
                    return;
                }

                if(signUpPassword.getText().toString().isEmpty()){
                    signUpPassword.setError(getString(R.string.password_is_missing));
                    return;
                }

                if(!signUpPassword.getText().toString().trim().equals(signUpConfirmPassword.getText().toString().trim())){
                    signUpConfirmPassword.setError(getString(R.string.password_donot_match));
                    return;
                }

                String firstName = signUpFullName.getText().toString().trim();
                String email = signUpEmail.getText().toString().trim();
                String password = signUpPassword.getText().toString().trim();
                User user = new User(firstName,getString(R.string.empty) ,0, email, password, getString(R.string.empty),"male");  //todo needs attention from ali

                signUpPresenter.signUp(user, signupFragment);

            }
        });

        return view;
    }

    @Override
    public void onSuccess(String actionType) {
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getActivity().getString(R.string.name_shared_pre), signUpFullName.getText().toString());
        editor.putString("email",signUpEmail.getText().toString());
        editor.apply();
//        System.out.println("dddddddddddddddddddddddddddddddd"+signUpFullName.getText());
        signUpFullName.setText(getString(R.string.empty));
        signUpEmail.setText(getString(R.string.empty));
        signUpPassword.setText(getString(R.string.empty));
        signUpConfirmPassword.setText(getString(R.string.empty));


        startActivity(new Intent(getActivity(),  MainActivity.class).addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT));
    }

    @Override
    public void onFailure(String erorrMessage) {
        Toast.makeText(getActivity(), erorrMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences = getActivity().getSharedPreferences("sh", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        if(sharedPreferences.getString("email",null)==null){}
//            startActivity(new Intent(getContext(), SignInActivity.class).addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT));
        else
            getActivity().finish();
    }
}