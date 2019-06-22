package rktuhinbd.salahchallenge.ViewController;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlertReceiverAsr extends BroadcastReceiver {
    public static final String channelID = "channelID";
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelperAsr notificationHelper = new NotificationHelperAsr(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(3, nb.build());
    }
}
