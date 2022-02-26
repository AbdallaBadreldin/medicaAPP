package eg.iti.pillsmanager.utility;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import androidx.lifecycle.LiveData;
import androidx.work.Worker;
import androidx.work.WorkerParameters;


import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.SplashActivity;
import eg.iti.pillsmanager.database.ConcreteLocalClass;
import eg.iti.pillsmanager.database.medicineTable.MedicineDataBase;
import eg.iti.pillsmanager.model.Medicine;

public class NotifyWorker extends Worker {
Context context;
int counter = 1;
    public NotifyWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        this.context=context;
    }

    @NonNull
    @Override
    public Result doWork() {
//        getWorkerFactory().createWorker()
//WorkManager.getInstance(context).cancelAllWork();
        // Method to trigger an instant notification
//        System.out.println("FROM WORKER WITH LOVE");
        new Thread(new Runnable() {
            @Override
            public void run() {

                List<Medicine> med =MedicineDataBase.getMedicineDataBaseInstance(context).getMedicineDao().getActiveMedicineNeedsRefill();
                //we need to check database here
                if(med==null)
                {/*then ther's not refill reminders*/ }  //System.out.println("FROM WORKER VALUE == NULL");
                else {
                    if (med.isEmpty())
                    { /*still empty*/ } //System.out.println("FROM WORKER VALUE ISEMPTY()");
                    else {
//                        System.out.println("FROM WORKER SEND NOTIFICATION");
                        sendNotification(context.getString(R.string.app_name), context.getString(R.string.notification_description));
                    }
                }
            }
        }).start();


        return Result.success();
        // (Returning RETRY tells WorkManager to try this task again
        // later; FAILURE says not to try again.)
    }


    public void sendNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

//        Intent intent = new Intent(context, SplashActivity.class);
//        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);

        Intent intent = new Intent(context, SplashActivity.class);
//
        PendingIntent pendingIntent = TaskStackBuilder.create(context)
                .addNextIntent(intent)
                .getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE);
//          context.startActivity(intent);

        //If on Oreo then notification required a notification channel.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(context.getString(R.string.notification_channel_id), context.getString(R.string.notification_channel_id), NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), context.getString(R.string.notification_channel_id))
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
//                .addAction(intent)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(counter++, notification.build());
    }
}