package com.example.test.singnIn.view;

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
import com.example.test.singnIn.MainActivity2;
import com.example.test.singnIn.presenter.SignInPresenter;

public class SigninFragment extends Fragment implements AsyncCallBackI {
    EditText signInEmail, signInPassword;
    TextView signInForgetPasswordTxt, signInRegisterTxt;
    Button signInBtn;
    SigninFragment signinFragment;
    SignInPresenter signInPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        signInPresenter = new SignInPresenter();
        signinFragment = this;
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        signInEmail = view.findViewById(R.id.signin_email);
        signInPassword = view.findViewById(R.id.signin_password);
        signInForgetPasswordTxt = view.findViewById(R.id.signin_forgetpasswordtxt);
        signInRegisterTxt = view.findViewById(R.id.signin_registertxt);
        signInBtn = view.findViewById(R.id.signin_btn);

        signInRegisterTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showFragmentSignUp();
            }
        });

        signInForgetPasswordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showFragmentForgetPassword();
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signInEmail.getText().toString().isEmpty()){
                    signInEmail.setError(getString(R.string.email_is_missing));
                    return;
                }

                if(signInPassword.getText().toString().isEmpty()){
                    signInPassword.setError(getString(R.string.password_is_missing));
                    return;
                }
                signInPresenter.signIn(signInEmail.getText().toString().trim(),
                                        signInPassword.getText().toString().trim(),
                                       signinFragment);
                signInEmail.setText(getString(R.string.empty_string));
                signInPassword.setText(getString(R.string.empty_string));
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