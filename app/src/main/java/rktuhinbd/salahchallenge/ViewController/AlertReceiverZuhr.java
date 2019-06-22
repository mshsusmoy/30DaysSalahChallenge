package rktuhinbd.salahchallenge.ViewController;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlertReceiverZuhr extends BroadcastReceiver {
    public static final String channelID = "channelID";
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelperZuhr notificationHelper = new NotificationHelperZuhr(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(2, nb.build());
    }
}
