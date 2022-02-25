package eg.iti.pillsmanager.auth.singnUp.view.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.MainActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.User;
import eg.iti.pillsmanager.auth.singnIn.view.SignInActivity;
import eg.iti.pillsmanager.auth.singnUp.presenter.SignUpPresenter;


public class SignupFragment extends Fragment implements AuthAsyncCallBackI {
    EditText signUpFullName,signUpEmail,signUpPassword,signUpConfirmPassword;
    Button buttonRegister;
    TextView goToLoginRegister;
    SignupFragment signupFragment;
    SignUpPresenter signUpPresenter;

    /////////
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public  final String MYNAME = getString(R.string.name_shared_pre);


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
        sharedPreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

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
                signUpFullName.setText(getString(R.string.empty));
                signUpEmail.setText(getString(R.string.empty));
                signUpPassword.setText(getString(R.string.empty));
                signUpConfirmPassword.setText(getString(R.string.empty));
            }
        });

        return view;
    }

    @Override
    public void onSuccess(String actionType) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MYNAME, signUpFullName.getText().toString());
        editor.commit();

        startActivity(new Intent(getActivity(),  MainActivity.class));
    }

    @Override
    public void onFailure(String erorrMessage) {
        Toast.makeText(getActivity(), erorrMessage, Toast.LENGTH_LONG).show();
    }

}