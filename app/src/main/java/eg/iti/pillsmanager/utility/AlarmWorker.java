package eg.iti.pillsmanager.utility;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.TimeUnit;
public class AlarmWorker extends Worker {
    Context context;
    public AlarmWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
        this.context =context;
    }

    @NonNull
    @Override
    public Result doWork() {
        WorkManager workManager = WorkManager.getInstance(context);
        workManager.cancelAllWork();


        Constraints constraints = new Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(NotifyWorker.class, 900000, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
                .build();


        workManager.enqueueUniquePeriodicWork("Counter", ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest);

        return Result.success();
        // (Returning RETRY tells WorkManager to try this task again
        // later; FAILURE says not to try again.)
    }
}