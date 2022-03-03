package eg.iti.pillsmanager.auth.singnIn.view;

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
import eg.iti.pillsmanager.auth.singnIn.presenter.SignInPresenter;

public class SigninFragment extends Fragment implements AuthAsyncCallBackI {
    EditText signInEmail, signInPassword;
    TextView signInForgetPasswordTxt, signInRegisterTxt;
    Button signInBtn;
    SigninFragment signinFragment;
    SignInPresenter signInPresenter;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        sharedPreferences = getActivity().getSharedPreferences("sh", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        if(sharedPreferences.getString("email",null)==null){}
//            startActivity(new Intent(getContext(), SignInActivity.class).addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT));
        else
            startActivity(new Intent(getContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT));


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
                SignInActivity.showFragmentSignUp();
            }
        });

        signInForgetPasswordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignInActivity.showFragmentForgetPassword();
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
               signInEmail.setText(getString(R.string.empty));
               signInPassword.setText(getString(R.string.empty));
            }
        });

        return view;
    }

    @Override
    public void onSuccess(String actionType) {
       sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email",signInEmail.getText().toString().trim());
        editor.putString("user","default");
        editor.apply();
        startActivity(new Intent(getActivity(), MainActivity.class ).addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT));
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