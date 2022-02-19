package eg.iti.pillsmanager.home.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import eg.iti.pillsmanager.R;

public class Home extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_home, container, false);

        return in;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        // on below line we are setting up our horizontal calendar view and passing id our calendar view to it.
        HorizontalCalendar horizontalCalendar  = new HorizontalCalendar.Builder(this.getView(), R.id.calendarView)
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
//                 on below line we are printing date
//                 in the logcat which is selected.
                Log.i("TAG", "CURRENT DATE IS " + date);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {

        super.onResume();

    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        return super.onGetLayoutInflater(savedInstanceState);

    }

    @Override
    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);

    }


}
