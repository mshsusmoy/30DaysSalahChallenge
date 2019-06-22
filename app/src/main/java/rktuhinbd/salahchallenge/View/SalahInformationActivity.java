package rktuhinbd.salahchallenge.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.Objects;

import rktuhinbd.salahchallenge.Data.DatabaseHelper;
import rktuhinbd.salahchallenge.R;

public class SalahInformationActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    private int date;
    private RelativeLayout layoutFajr, layoutZuhr, layoutAsr, layoutMaghrib, layoutIsha;
    private ExpandableRelativeLayout fajr, zuhr, asr, maghrib, isha;
    private TextView tvHeading;

    private EditText etFarzFajr, etSunnahFajr;
    private EditText etFarzZuhr, etSunnahZuhr, etNaflZuhr;
    private EditText etFarzAsr, etSunnahAsr;
    private EditText etFarzMaghrib, etSunnahMaghrib, etNaflMaghrib;
    private EditText etFarzIsha, etSunnahIsha, etNaflIsha;

    private Button btSaveFajr, btSaveZuhr, btSaveAsr, btSaveMaghrib, btSaveIsha;

    private String farz, sunnah, nafl, day, salahName;
    private int salahCounter = 1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah_info);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Salah Information");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        date = intent.getIntExtra("day", 0);
        day = String.valueOf(date);

        tvHeading = findViewById(R.id.txt_heading);
        tvHeading.setText("How many times and rakahs have you completed your salah at " + "Day " + day + "?");

        layoutFajr = findViewById(R.id.layout_fajr);
        layoutZuhr = findViewById(R.id.layout_zuhr);
        layoutAsr = findViewById(R.id.layout_asr);
        layoutMaghrib = findViewById(R.id.layout_maghrib);
        layoutIsha = findViewById(R.id.layout_isha);

        fajr = findViewById(R.id.expandableLayout_fajr);
        zuhr = findViewById(R.id.expandableLayout_zuhr);
        asr = findViewById(R.id.expandableLayout_asr);
        maghrib = findViewById(R.id.expandableLayout_maghrib);
        isha = findViewById(R.id.expandableLayout_isha);

        etFarzFajr = findViewById(R.id.et_farz_fajr);
        etSunnahFajr = findViewById(R.id.et_sunnah_fajr);

        etFarzZuhr = findViewById(R.id.et_farz_zuhr);
        etSunnahZuhr = findViewById(R.id.et_sunnah_zuhr);
        etNaflZuhr = findViewById(R.id.et_nafl_zuhr);

        etFarzAsr = findViewById(R.id.et_farz_asr);
        etSunnahAsr = findViewById(R.id.et_sunnah_asr);

        etFarzMaghrib = findViewById(R.id.et_farz_maghrib);
        etSunnahMaghrib = findViewById(R.id.et_sunnah_maghrib);
        etNaflMaghrib = findViewById(R.id.et_nafl_maghrib);

        etFarzIsha = findViewById(R.id.et_farz_isha);
        etSunnahIsha = findViewById(R.id.et_sunnah_isha);
        etNaflIsha = findViewById(R.id.et_nafl_isha);

        btSaveFajr = findViewById(R.id.btn_save_fajr);
        btSaveZuhr = findViewById(R.id.btn_save_zuhr);
        btSaveAsr = findViewById(R.id.btn_save_asr);
        btSaveMaghrib = findViewById(R.id.btn_save_maghrib);

        fajr.collapse();
        zuhr.collapse();
        asr.collapse();
        maghrib.collapse();
        isha.collapse();
        btSaveIsha = findViewById(R.id.btn_save_isha);

        getSalahInformation();

        layoutFajr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fajr.toggle();
                zuhr.collapse();
                asr.collapse();
                maghrib.collapse();
                isha.collapse();
            }
        });

        layoutZuhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zuhr.toggle();
                fajr.collapse();
                asr.collapse();
                maghrib.collapse();
                isha.collapse();
            }
        });

        layoutAsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asr.toggle();
                fajr.collapse();
                zuhr.collapse();
                maghrib.collapse();
                isha.collapse();
            }
        });

        layoutMaghrib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maghrib.toggle();
                fajr.collapse();
                zuhr.collapse();
                asr.collapse();
                isha.collapse();
            }
        });

        layoutIsha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isha.toggle();
                fajr.collapse();
                zuhr.collapse();
                asr.collapse();
                maghrib.collapse();
            }
        });

        btSaveFajr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformationFazr();
            }
        });

        btSaveZuhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformationZuhr();
            }
        });

        btSaveAsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformationAsr();
            }
        });

        btSaveMaghrib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformationMaghrib();
            }
        });

        btSaveIsha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformationIsha();
            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), SalahChallengeActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void saveInformationFazr() {
        salahName = "Fajr";
        farz = etFarzFajr.getText().toString();
        sunnah = etSunnahFajr.getText().toString();
        nafl = "";

        if (farz.equals("")) {
            Toast.makeText(getApplicationContext(), "Please check your input!", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.insertSalahInformation(day, salahName, farz, sunnah, nafl, salahCounter);
            Toast.makeText(getApplicationContext(), "Your salah information is saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInformationZuhr() {
        salahName = "Zuhr";
        farz = etFarzZuhr.getText().toString();
        sunnah = etSunnahZuhr.getText().toString();
        nafl = etNaflZuhr.getText().toString();

        if (farz.equals("")) {
            Toast.makeText(getApplicationContext(), "Please check your input!", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.insertSalahInformation(day, salahName, farz, sunnah, nafl, salahCounter);
            Toast.makeText(getApplicationContext(), "Your salah information is saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInformationAsr() {
        salahName = "Asr";
        farz = etFarzAsr.getText().toString();
        sunnah = etSunnahAsr.getText().toString();
        nafl = "";

        if (farz.equals("")) {
            Toast.makeText(getApplicationContext(), "Please check your input!", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.insertSalahInformation(day, salahName, farz, sunnah, nafl, salahCounter);
            Toast.makeText(getApplicationContext(), "Your salah information is saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInformationMaghrib() {
        salahName = "Maghrib";
        farz = etFarzMaghrib.getText().toString();
        sunnah = etSunnahMaghrib.getText().toString();
        nafl = etNaflMaghrib.getText().toString();

        if (farz.equals("")) {
            Toast.makeText(getApplicationContext(), "Please check your input!", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.insertSalahInformation(day, salahName, farz, sunnah, nafl, salahCounter);
            Toast.makeText(getApplicationContext(), "Your salah information is saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInformationIsha() {
        salahName = "Isha";
        farz = etFarzIsha.getText().toString();
        sunnah = etSunnahIsha.getText().toString();
        nafl = etNaflIsha.getText().toString();

        if (farz.equals("")) {
            Toast.makeText(getApplicationContext(), "Please check your input!", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.insertSalahInformation(day, salahName, farz, sunnah, nafl, salahCounter);
            Toast.makeText(getApplicationContext(), "Your salah information is saved!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getSalahInformation() {
        //Fetch Database Values
        Cursor cursor = databaseHelper.getSalahInformation(day);

        while (cursor.moveToNext()) {
            salahName = cursor.getString(2);
            farz = cursor.getString(3);
            sunnah = cursor.getString(4);
            nafl = cursor.getString(5);

            if (salahName.equals("Fajr")) {
                etFarzFajr.setText(farz);
                etSunnahFajr.setText(sunnah);

                etFarzFajr.setEnabled(false);
                etSunnahFajr.setEnabled(false);

                btSaveFajr.setVisibility(View.GONE);
            }

            if (salahName.equals("Zuhr")) {
                etFarzZuhr.setText(farz);
                etSunnahZuhr.setText(sunnah);
                etNaflZuhr.setText(nafl);

                etFarzZuhr.setEnabled(false);
                etSunnahZuhr.setEnabled(false);
                etNaflZuhr.setEnabled(false);

                btSaveZuhr.setVisibility(View.GONE);
            }

            if (salahName.equals("Asr")) {
                etFarzAsr.setText(farz);
                etSunnahAsr.setText(sunnah);

                etFarzAsr.setEnabled(false);
                etSunnahAsr.setEnabled(false);

                btSaveAsr.setVisibility(View.GONE);
            }

            if (salahName.equals("Maghrib")) {
                etFarzMaghrib.setText(farz);
                etSunnahMaghrib.setText(sunnah);
                etNaflMaghrib.setText(nafl);

                etFarzMaghrib.setEnabled(false);
                etSunnahMaghrib.setEnabled(false);
                etNaflMaghrib.setEnabled(false);

                btSaveMaghrib.setVisibility(View.GONE);
            }

            if (salahName.equals("Isha")) {
                etFarzIsha.setText(farz);
                etSunnahIsha.setText(sunnah);
                etNaflIsha.setText(nafl);

                etFarzIsha.setEnabled(false);
                etSunnahIsha.setEnabled(false);
                etNaflIsha.setEnabled(false);
                btSaveIsha.setVisibility(View.GONE);
            }
        }
    }
}