package rktuhinbd.salahchallenge.ViewController;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.preference.RingtonePreference;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import rktuhinbd.salahchallenge.R;
import rktuhinbd.salahchallenge.View.MainActivity;

public class NotificationHelperAsr extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private MediaPlayer player;
    private NotificationManager mManager;

    public NotificationHelperAsr(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel(base);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel(Context context) {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
//        Intent i = new Intent(context, AlarmActivity.class);
//        i.putExtra("Title","Salah Reminder");
//        i.putExtra("Desc","Its time for Asr");
//        context.startActivity(i);
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
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 3, mIntent, 0);

        MediaController.getInstance(getApplicationContext()).playMusic();

        //MediaController mediaController = new MediaController(getApplicationContext());
        //mediaController.playMusic();


        Intent repeating_intent = new Intent(getApplicationContext(), MainActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent_asr = PendingIntent.getActivity(getApplicationContext(), 3, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentIntent(pendingIntent_asr)
                .setContentTitle("Salah Reminder!")
                .setContentText("It's time to pray Asr")
                .setDefaults(RingtonePreference.DEFAULT_ORDER)
                .addAction(R.drawable.alarm_clock, charSequence, pendingIntent)
                .setAutoCancel(true)
                .setVibrate(new long[]{0, 200, 100, 200})
                .setSmallIcon(R.drawable.ic_launcher_foreground);
    }
}

