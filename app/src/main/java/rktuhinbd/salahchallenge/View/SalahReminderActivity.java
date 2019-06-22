package rktuhinbd.salahchallenge.View;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Objects;

import rktuhinbd.salahchallenge.R;
import rktuhinbd.salahchallenge.ViewController.AlertReceiverAsr;
import rktuhinbd.salahchallenge.ViewController.AlertReceiverFajr;
import rktuhinbd.salahchallenge.ViewController.AlertReceiverIsha;
import rktuhinbd.salahchallenge.ViewController.AlertReceiverMaghrib;
import rktuhinbd.salahchallenge.ViewController.AlertReceiverZuhr;
import rktuhinbd.salahchallenge.ViewController.TimePickerFragment;

public class SalahReminderActivity extends AppCompatActivity implements android.app.TimePickerDialog.OnTimeSetListener {
    private TextView txtAlarmTimeFajr, txtAlarmTimeZuhr, txtAlarmTimeAsr, txtAlarmTimeMaghrib, txtAlarmTimeIsha;
    private String alarmTime, alarmTimeInMillis, fajrText = "4:00 AM", zuhrText = "1:00 PM", asrText = "5:00 PM", maghribText = "6:20 PM", ishaText = "8:15 PM";
    private Boolean fajrFlag, zuhrFlag, asrFlag, maghribFlag, ishaFlag;
    private Switch aSwitch;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah_reminder);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Salah Reminder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editor = getSharedPreferences("Shared Preference", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("Shared Preference", MODE_PRIVATE);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RelativeLayout layoutFajr, layoutZuhr, layoutAsr, layoutMaghrib, layoutIsha;

        txtAlarmTimeFajr = findViewById(R.id.txt_alarm_time_fajr);
        txtAlarmTimeZuhr = findViewById(R.id.txt_alarm_time_zuhr);
        txtAlarmTimeAsr = findViewById(R.id.txt_alarm_time_asr);
        txtAlarmTimeMaghrib = findViewById(R.id.txt_alarm_time_maghrib);
        txtAlarmTimeIsha = findViewById(R.id.txt_alarm_time_isha);
        aSwitch = findViewById(R.id.switch_alarm_on_or_off);

        if (prefs.getString("aSwitch", "").equals("on")) {
            aSwitch.setChecked(true);
        } else {
            aSwitch.setChecked(false);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putString("aSwitch", "on");
                    editor.apply();
                    editor.commit();
                } else {
                    stopAlarm();
                    editor.putString("aSwitch", "off");
                    editor.apply();
                    editor.commit();
                }
            }
        });

        if (prefs != null) {
            fajrText = prefs.getString("fajr", "");
            zuhrText = prefs.getString("zuhr", "");
            asrText = prefs.getString("asr", "");
            maghribText = prefs.getString("maghrib", "");
            ishaText = prefs.getString("isha", "");

            txtAlarmTimeFajr.setText(fajrText);
            txtAlarmTimeZuhr.setText(zuhrText);
            txtAlarmTimeAsr.setText(asrText);
            txtAlarmTimeMaghrib.setText(maghribText);
            txtAlarmTimeIsha.setText(ishaText);
        } else {
            txtAlarmTimeFajr.setText(fajrText);
            txtAlarmTimeZuhr.setText(zuhrText);
            txtAlarmTimeAsr.setText(asrText);
            txtAlarmTimeMaghrib.setText(maghribText);
            txtAlarmTimeIsha.setText(ishaText);
        }

        layoutFajr = findViewById(R.id.layout_fajr);
        layoutFajr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFajrLayoutAction();
            }
        });

        layoutZuhr = findViewById(R.id.layout_zuhr);
        layoutZuhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setZuhrLayoutAction();
            }
        });

        layoutAsr = findViewById(R.id.layout_asr);
        layoutAsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAsrLayoutAction();
            }
        });

        layoutMaghrib = findViewById(R.id.layout_maghrib);
        layoutMaghrib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMaghribLayoutAction();
            }
        });

        layoutIsha = findViewById(R.id.layout_isha);
        layoutIsha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIshaLayoutAction();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setFajrLayoutAction() {
        fajrFlag = true;
        zuhrFlag = false;
        asrFlag = false;
        maghribFlag = false;
        ishaFlag = false;
        openTimePicker();
    }

    private void setZuhrLayoutAction() {
        fajrFlag = false;
        zuhrFlag = true;
        asrFlag = false;
        maghribFlag = false;
        ishaFlag = false;
        openTimePicker();
    }

    private void setAsrLayoutAction() {
        fajrFlag = false;
        zuhrFlag = false;
        asrFlag = true;
        maghribFlag = false;
        ishaFlag = false;
        openTimePicker();
    }

    private void setMaghribLayoutAction() {
        fajrFlag = false;
        zuhrFlag = false;
        asrFlag = false;
        maghribFlag = true;
        ishaFlag = false;
        openTimePicker();
    }

    private void setIshaLayoutAction() {
        fajrFlag = false;
        zuhrFlag = false;
        asrFlag = false;
        maghribFlag = false;
        ishaFlag = true;
        openTimePicker();
    }

    public void openTimePicker() {
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(getSupportFragmentManager(), "time picker");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        alarmTimeInMillis = c.getTimeInMillis() + "";

        if (hourOfDay > 12) {
            hourOfDay -= 12;
            alarmTime = hourOfDay + ":" + minute + " PM";
        } else if (hourOfDay == 12) {
            alarmTime = hourOfDay + ":" + minute + " PM";
        } else if (hourOfDay == 0) {
            alarmTime = 12 + ":" + minute + " AM";
        } else {
            alarmTime = hourOfDay + ":" + minute + " AM";
        }
        setTimeInAlarmText();
        setAlarm(c);
    }

    private void setTimeInAlarmText() {
        if (fajrFlag) {
            editor.putString("fajr", alarmTime);
            editor.putString("fajr_at", alarmTimeInMillis);
            editor.apply();
            txtAlarmTimeFajr.setText(alarmTime);
        }
        if (zuhrFlag) {
            editor.putString("zuhr", alarmTime);
            editor.putString("zuhr_at", alarmTimeInMillis);
            editor.apply();
            txtAlarmTimeZuhr.setText(alarmTime);
        }
        if (asrFlag) {
            editor.putString("asr", alarmTime);
            editor.putString("asr_at", alarmTimeInMillis);
            editor.apply();
            txtAlarmTimeAsr.setText(alarmTime);
        }
        if (maghribFlag) {
            editor.putString("maghrib", alarmTime);
            editor.putString("maghrib_at", alarmTimeInMillis);
            editor.apply();
            txtAlarmTimeMaghrib.setText(alarmTime);
        }
        if (ishaFlag) {
            editor.putString("isha", alarmTime);
            editor.putString("isha_at", alarmTimeInMillis);
            editor.apply();
            txtAlarmTimeIsha.setText(alarmTime);
        }
    }

    private void setAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = null;

        if (fajrFlag) {
            Intent intent = new Intent(this, AlertReceiverFajr.class);
            intent.putExtra("flag", "fajr");
            pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        } else if (zuhrFlag) {
            Intent intent = new Intent(this, AlertReceiverZuhr.class);
            intent.putExtra("flag", "zuhr");
            pendingIntent = PendingIntent.getBroadcast(this, 2, intent, 0);
        } else if (asrFlag) {
            Intent intent = new Intent(this, AlertReceiverAsr.class);
            intent.putExtra("flag", "asr");
            pendingIntent = PendingIntent.getBroadcast(this, 3, intent, 0);
        } else if (maghribFlag) {
            Intent intent = new Intent(this, AlertReceiverMaghrib.class);
            intent.putExtra("flag", "maghrib");
            pendingIntent = PendingIntent.getBroadcast(this, 4, intent, 0);
        } else if (ishaFlag) {
            Intent intent = new Intent(this, AlertReceiverIsha.class);
            intent.putExtra("flag", "isha");
            pendingIntent = PendingIntent.getBroadcast(this, 5, intent, 0);
        }


        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void stopAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        SharedPreferences prefs = getSharedPreferences("Shared Preference", MODE_PRIVATE);
        if (!prefs.getString("fajr", "").equals("")) {
            Intent intent = new Intent(this, AlertReceiverFajr.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

            alarmManager.cancel(pendingIntent);
        }
        if (!prefs.getString("zuhr", "").equals("")) {
            Intent intent = new Intent(this, AlertReceiverZuhr.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 2, intent, 0);

            alarmManager.cancel(pendingIntent);

        }
        if (!prefs.getString("asr", "").equals("")) {
            Intent intent = new Intent(this, AlertReceiverAsr.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 3, intent, 0);

            alarmManager.cancel(pendingIntent);

        }
        if (!prefs.getString("maghrib", "").equals("")) {
            Intent intent = new Intent(this, AlertReceiverMaghrib.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 4, intent, 0);

            alarmManager.cancel(pendingIntent);

        }
        if (!prefs.getString("isha", "").equals("")) {
            Intent intent = new Intent(this, AlertReceiverIsha.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 5, intent, 0);

            alarmManager.cancel(pendingIntent);
        }
    }
}