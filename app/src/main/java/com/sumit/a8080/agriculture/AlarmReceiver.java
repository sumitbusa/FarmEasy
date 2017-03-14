package com.sumit.a8080.agriculture;

/**
 * Created by Vivek Vora on 29-Jan-17.
 */
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String subjectName ="Vivek";
        String startTime = "Vivek";
        showNotification(context, subjectName, startTime);
    }

    public void showNotification(Context context, String subjectName, String startTime) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_forward_white_36dp)
                .setContentTitle(subjectName)
                .setContentText("at " + startTime)
                .setColor(Color.argb(255, 67, 133, 244));
        mBuilder.setContentIntent(pi);
        mBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancelAll();
        mNotificationManager.notify(7, mBuilder.build());
    }
}
