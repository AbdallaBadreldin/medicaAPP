package eg.iti.pillsmanager;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import eg.iti.pillsmanager.auth.singnIn.view.SignInActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash();
    }

    private void splash(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
                if(sharedPreferences.getString("email",null)==null)
                    startActivity(new Intent(SplashActivity.this, SignInActivity.class).addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT));
                    else
                startActivity(new Intent(SplashActivity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT));
            }
        }, 500);
    }
}