package eg.iti.pillsmanager;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import eg.iti.pillsmanager.databinding.ActivityMainBinding;
import eg.iti.pillsmanager.editdependent.view.EditDependentFragment;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
//    private  AppBarConfiguration mappBottomBarConfiguration;
    private ActivityMainBinding binding;
    private Calendar startDate;
    private Navigation nav;

    private HorizontalCalendar horizontalCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createNavigationSideBar();
        //createCalendar();
    }

    private void createCalendar() {

        /* starts before 1 month from now */
        startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        // on below line we are setting up our horizontal calendar view and passing id our calendar view to it.
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                // on below line we are adding a range
                // as start date and end date to our calendar.
                .range(startDate, endDate)
                // on below line we are providing a number of dates
                // which will be visible on the screen at a time.
                .datesNumberOnScreen(5)
                // at last we are calling a build method
                // to build our horizontal recycler view.
                .build();
        // on below line we are setting calendar listener to our calendar view.
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                // on below line we are printing date
                // in the logcat which is selected.
                Log.i("TAG", "CURRENT DATE IS " + date);
            }
        });
    }


    private void createNavigationSideBar(){

        setSupportActionBar(binding.appBarMain.toolbar);



//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        BottomNavigationView bottomNavView = findViewById(R.id.bottm_nav_view);
//        NavigationView bottomNavigationView = findViewById(R.id.bottm_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
/*
         mappBottomBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
//                 , R.id.navigation_refill, R.id.navigation_mediciation)
                .build();
*/
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_refill, R.id.navigation_mediciation)
//                , R.id.nav_gallery, R.id.nav_slideshow)   //it's about hiding back button
                .setOpenableLayout(drawer)

                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);


//        NavigationUI.setupActionBarWithNavController(this, navController, mappBottomBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavView, navController);  //bottom navigation view
        NavigationUI.setupWithNavController(navigationView, navController);  // navigation view


//        TextView txt = drawer.getRootView().requireViewById(R.id.userName);
//        txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navigateUpTo(new Intent(getApplicationContext(),EditDependentFragment.class));
//            }
//        });

      View headerView=  navigationView.getHeaderView(0);
//        ImageView image = headerView.findViewById(R.id.imageView);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                navigateUpTo(new Intent(getApplicationContext(),EditDependentFragment.class));
//                Toast.makeText(MainActivity.this, "Hi you pressed edit", Toast.LENGTH_SHORT).show();
//                NavDirections action =
//                        SpecifyAmountFragmentDirections
//                                .actionSpecifyAmountFragmentToConfirmationFragment();
//                Navigation.findNavController(view).navigate(action);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        createCalendar();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);

    }
}


