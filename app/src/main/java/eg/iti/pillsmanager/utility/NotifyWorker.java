package eg.iti.pillsmanager.utility;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import androidx.work.Worker;
import androidx.work.WorkerParameters;


import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.database.ConcreteLocalClass;

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

        //we need to check database here
        if(new ConcreteLocalClass(context).getActiveMedicineNeedsRefill().getValue()==null)
        {/*then ther's not refill reminders*/}
        else {
            if (new ConcreteLocalClass(context).getActiveMedicineNeedsRefill().getValue().isEmpty())
            { /*still empty*/ }
                else
            sendNotification(context.getString(R.string.app_name), context.getString(R.string.notification_description));
        }

        return Result.success();
        // (Returning RETRY tells WorkManager to try this task again
        // later; FAILURE says not to try again.)
    }


    public void sendNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        //If on Oreo then notification required a notification channel.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(context.getString(R.string.notification_channel_id), context.getString(R.string.notification_channel_id), NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), context.getString(R.string.notification_channel_id))
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(counter++, notification.build());
    }
}