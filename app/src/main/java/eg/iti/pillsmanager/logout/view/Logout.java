package eg.iti.pillsmanager.logout.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import eg.iti.pillsmanager.R;

public class Logout extends Fragment  {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_logout, container, false);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
//        editor.putString(getActivity().getString(R.string.name_shared_pre), signUpFullName.getText().toString());
//        editor.putString("email",null);
        editor.apply();

        Fragment currentFragment = getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.main_activity_container);

        if(currentFragment instanceof Logout) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction().remove(currentFragment).commit();
        }
//        popBackStackImmediate();
        getActivity().finish();
        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }


}
