package rktuhinbd.salahchallenge.ViewController;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import rktuhinbd.salahchallenge.View.MainActivity;


public class AlarmStopper extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            MediaController.getInstance(context).stopMusic();
            context.startActivity(new Intent(context, MainActivity.class));
        }
    }

