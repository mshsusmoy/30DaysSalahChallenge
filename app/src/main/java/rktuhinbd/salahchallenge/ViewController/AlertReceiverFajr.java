package rktuhinbd.salahchallenge.ViewController;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;


public class AlertReceiverFajr extends BroadcastReceiver {

    public static final String channelID = "channelID";
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelperFajr notificationHelper = new NotificationHelperFajr(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}