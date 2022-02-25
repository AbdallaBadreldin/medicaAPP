package eg.iti.pillsmanager.refill.view;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.Fragment;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.utility.NotifyWorker;

public class RefillFragment extends Fragment {
    //we set a tag to be able to cancel all work of this type if needed
    public static final String workTag = "notificationWork";

    final String CHANNEL_ID = "Important_medicine_channel";
    Button mBtnSimpleNotification, mBtnBigTextNotification, mBtnBigPictureNotification, mBtnInboxNotification, mBtnActionNotification;
    NotificationManagerCompat mNotificationManagerCompat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View in =inflater.inflate(R.layout.fragment_refill, container, false);
        triggerNotifyWork();

        return in;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        final Intent emptyIntent = new Intent();
//        PendingIntent pendingIntent = PendingIntent.getActivity(getContext(), 955, emptyIntent, PendingIntent.FLAG_IMMUTABLE);


//        createNotificationChannel();
//        mNotificationManagerCompat = NotificationManagerCompat.from(getContext());
//
//        Notification notification = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
//                .setSmallIcon(R.mipmap.ic_launcher_round)
//                .setContentTitle("title")
//                .setContentText("text")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                Set the intent that will fire when the user taps the notification
//                .setContentIntent( pendingIntent)
//                .setAutoCancel(true)
//                .build();

        // notificationId is a unique int for each notification that you must define
//        mNotificationManagerCompat.notify(955, notification);

    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getContext())
                        .setSmallIcon(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark) //set icon for notification
                        .setContentTitle("Notifications Example") //set title of notification
                        .setContentText("This is a notification message")//this is notification message
                        .setAutoCancel(true) // makes auto cancel of notification
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification


//        Intent notificationIntent = new Intent(this, NotificationView.class);
//        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
//        notificationIntent.putExtra("message", "This is a notification message");

//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(pendingIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    public void triggerNotifyWork(){
        Constraints constraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(NotifyWorker.class, 900000, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
                .build();

        WorkManager workManager = WorkManager.getInstance(getContext());
        workManager.enqueueUniquePeriodicWork("Counter", ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest);
//        Toast.makeText(getActivity(), "🎉 Scheduled job!", Toast.LENGTH_SHORT).show();

    }

    public void RetriggerWorkManager() {
        WorkManager.getInstance(getContext()).cancelAllWork();
        //store DBEventID to pass it to the PendingIntent and open the appropriate event page on notification click
        Data inputData = new Data.Builder().putInt(getString(R.string.db_event_id_tag), Integer.parseInt(getString(R.string.db_Event_id))).build();
         // we then retrieve it inside the NotifyWorker with:
        // final int DBEventID = getInputData().getInt(DBEventIDTag, ERROR_VALUE);

        OneTimeWorkRequest notificationWork = new OneTimeWorkRequest.Builder(NotifyWorker.class)
                .setInitialDelay(5000 , TimeUnit.MILLISECONDS)
                .setInputData(inputData)
                .addTag(workTag)
                .build();
        WorkManager.getInstance(getActivity().getApplicationContext()).enqueue(notificationWork);


    }

    public void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "CHANNEL_ID")
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("hello and welcome guys")
                .setContentText("here we have refill")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.build();
        // Create an explicit intent for an Activity in your app
//        Intent intent = new Intent(getActivity(), AlertDetails.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
//
//        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(getActivity(), "CHANNEL_ID")
//                .setSmallIcon(devs.mulham.horizontalcalendar.R.drawable.ic_circle_white_8dp)
//                .setContentTitle("My notification")
//                .setContentText("Hello World!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                 Set the intent that will fire when the user taps the notification
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
    }
    private void createNotificationChannel() {

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Channel name
            CharSequence name = "Important_mail_channel";

            //Channel description
            String description = "This channel will show notification only to important people";

            //The importance level you assign to a channel applies to all notifications that you post to it.
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            //Create the NotificationChannel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            //Set channel description
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = null;

            notificationManager = getContext().getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(channel);
        }
    }

}
