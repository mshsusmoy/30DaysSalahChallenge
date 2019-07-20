package rktuhinbd.salahchallenge.ViewController;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.preference.RingtonePreference;
import android.support.v4.app.NotificationCompat;

import rktuhinbd.salahchallenge.R;
import rktuhinbd.salahchallenge.View.MainActivity;

public class NotificationHelperDefault extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private NotificationManager mManager;

    public NotificationHelperDefault(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        CharSequence charSequence = "Dismiss";
        Intent mIntent = new Intent(getApplicationContext(), AlarmStopper.class);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, mIntent, 0);

        MediaController.getInstance(getApplicationContext()).playMusic();

        //MediaController mediaController = new MediaController(getApplicationContext());
        //mediaController.playMusic();


        Intent repeating_intent = new Intent(getApplicationContext(), MainActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent_isha = PendingIntent.getActivity(getApplicationContext(), 0, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentIntent(pendingIntent_isha)
                .setContentTitle("Assalamu Alaikum")
                .setContentText("Read verse from Quran or read any Hadith")
                .setDefaults(RingtonePreference.DEFAULT_ORDER)
                .addAction(R.drawable.alarm_clock, charSequence, pendingIntent)
                .setAutoCancel(true)
                .setVibrate(new long[]{0, 200, 100, 200})
                .setSmallIcon(R.drawable.ic_launcher_foreground);
    }
}
