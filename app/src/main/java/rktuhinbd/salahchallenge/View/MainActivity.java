package rktuhinbd.salahchallenge.View;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

import rktuhinbd.salahchallenge.Data.DatabaseHelper;
import rktuhinbd.salahchallenge.R;
import rktuhinbd.salahchallenge.ViewController.AlertReceiverDefault;
import rktuhinbd.salahchallenge.ViewController.MediaController;

public class MainActivity extends AppCompatActivity {

    private long backPressTime;
    private Toast backToast;

    private ImageView ivQuran, ivHadith, ivSalatChallenge, ivAlarm, ivDeliverance, ivReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaController.getInstance(getApplicationContext()).stopMusic();

        ivQuran = findViewById(R.id.iv_quran);
        ivHadith = findViewById(R.id.iv_hadith);
        ivSalatChallenge = findViewById(R.id.iv_salat);
        ivAlarm = findViewById(R.id.iv_alarm);
        ivDeliverance = findViewById(R.id.iv_deliverance);
        ivReset = findViewById(R.id.iv_reset);

        SetDefaultNotification();

        ivQuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuranActivity.class));
            }
        });

        ivHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HadithActivity.class));
            }
        });

        ivSalatChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SalahChallengeActivity.class));
            }
        });

        ivAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SalahReminderActivity.class));
            }
        });

        ivDeliverance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), deliverance.class));
            }
        });

        ivReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                databaseHelper.clearSalahInformation();
                Toast.makeText(getApplicationContext(), "Salah Record Cleared!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void SetDefaultNotification() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 10);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiverDefault.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 9, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), AlarmManager.INTERVAL_HALF_DAY, pendingIntent);
    }

    @Override
    public void onBackPressed() {

        if (backPressTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        } else {
            backToast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressTime = System.currentTimeMillis();
    }
}