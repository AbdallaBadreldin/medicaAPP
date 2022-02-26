package eg.iti.pillsmanager.auth.singnIn.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.auth.resetPassword.view.ResetPasswordFragment;
import eg.iti.pillsmanager.auth.singnUp.view.view.SignupFragment;

public class SignInActivity extends AppCompatActivity {
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singnin_container);
        fragmentManager = getSupportFragmentManager();
        showFragmentSignIn();
    }

    public static void showFragmentSignIn(){
        SigninFragment signinFragment = new SigninFragment();
        showFragment(signinFragment);
    }

    public static void showFragmentSignUp(){
        SignupFragment signupFragment = new SignupFragment();
        showFragment(signupFragment);
    }

    public static void showFragmentForgetPassword(){
        ResetPasswordFragment resetPasswordFragment = new ResetPasswordFragment();
        showFragment(resetPasswordFragment);
    }

    private static void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, fragment);
        fragmentTransaction.commit();
    }

}