package eg.iti.pillsmanager.auth.resetPassword.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import eg.iti.pillsmanager.auth.AuthAsyncCallBackI;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.auth.resetPassword.presenter.ResetPasswordPresenter;
import eg.iti.pillsmanager.auth.singnIn.view.SignInActivity;

public class ResetPasswordFragment extends Fragment implements AuthAsyncCallBackI {
    EditText forgetPasswordEmail;
    Button resetPasswordBtn;
    TextView goToSingintxt;
    ResetPasswordPresenter resetPasswordPresenter;
    ResetPasswordFragment resetPasswordFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        resetPasswordFragment = this;
        resetPasswordPresenter = new ResetPasswordPresenter();
        View view = inflater.inflate(R.layout.fragment_forget_password, container, false);
        forgetPasswordEmail = view.findViewById(R.id.forget_password_email);
        resetPasswordBtn = view.findViewById(R.id.reset_password_btn);
        goToSingintxt = view.findViewById(R.id.go_to_singintxt);

        goToSingintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignInActivity.showFragmentSignIn();
            }
        });

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = forgetPasswordEmail.getText().toString().trim();
                resetPasswordPresenter.resetPassword(resetPasswordFragment, email);
            }
        });

        return view;
    }

    @Override
    public void onSuccess(String actionType) {
        Toast.makeText(getActivity(), "check your mail to reset password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String erorrMessage) {
        Toast.makeText(getActivity(), erorrMessage, Toast.LENGTH_SHORT).show();
    }
}