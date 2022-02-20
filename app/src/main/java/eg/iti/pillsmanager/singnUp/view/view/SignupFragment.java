package com.example.test.singnUp.view.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.AsyncCallBackI;
import com.example.test.R;
import com.example.test.model.User;
import com.example.test.singnIn.view.MainActivity;
import com.example.test.singnIn.MainActivity2;
import com.example.test.singnUp.presenter.SignUpPresenter;


public class SignupFragment extends Fragment implements AsyncCallBackI {
    EditText signUpFullName,signUpEmail,signUpPassword,signUpConfirmPassword;
    Button buttonRegister;
    TextView goToLoginRegister;
    SignupFragment signupFragment;
    SignUpPresenter signUpPresenter;
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

        goToLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showFragmentSignIn();
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

                String fullName = signUpFullName.getText().toString().trim();
                String email = signUpEmail.getText().toString().trim();
                String password = signUpPassword.getText().toString().trim();
                User user = new User(fullName, email, password, "");
                signUpPresenter.signUp(user, signupFragment);
                signUpFullName.setText(getString(R.string.empty_string));
                signUpEmail.setText(getString(R.string.empty_string));
                signUpPassword.setText(getString(R.string.empty_string));
                signUpConfirmPassword.setText(getString(R.string.empty_string));
            }
        });

        return view;
    }

    @Override
    public void onSuccess(String actionType) {
        startActivity(new Intent(getActivity(), MainActivity2.class ));
    }

    @Override
    public void onFailure(String erorrMessage) {
        Toast.makeText(getActivity(), erorrMessage, Toast.LENGTH_LONG).show();
    }
}