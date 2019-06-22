package rktuhinbd.salahchallenge.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rktuhinbd.salahchallenge.R;
import rktuhinbd.salahchallenge.ViewController.MediaController;

public class AlarmActivity extends AppCompatActivity {
    private MediaPlayer player;
    private Button btn_off;
    private TextView textView_title, textView_desc;
    private Intent getIntent;
    private String title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        StartAlarm();

        textView_title = findViewById(R.id.txt_title);
        textView_desc = findViewById(R.id.txt_salahName);

        getIntent = getIntent();

        if (getIntent != null) {
            title = getIntent.getStringExtra("Title");
            desc = getIntent.getStringExtra("Desc");
            textView_title.setText(title);
            textView_desc.setText(desc);
        }


        btn_off = findViewById(R.id.btn_off);
        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OffAlarm();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void StartAlarm() {
        player = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_ALARM_ALERT_URI);
        player.setLooping(true);
        player.start();
    }

    public void OffAlarm() {
        MediaController.getInstance(getApplicationContext()).stopMusic();
        player.stop();
    }
}
