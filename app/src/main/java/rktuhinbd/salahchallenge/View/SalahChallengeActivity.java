package rktuhinbd.salahchallenge.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import rktuhinbd.salahchallenge.Data.DatabaseHelper;
import rktuhinbd.salahchallenge.R;

public class SalahChallengeActivity extends AppCompatActivity {

    private Button btDay1, btDay2, btDay3, btDay4, btDay5, btDay6, btDay7, btDay8, btDay9, btDay10, btDay11, btDay12, btDay13, btDay14, btDay15, btDay16, btDay17, btDay18, btDay19, btDay20, btDay21, btDay22, btDay23, btDay24, btDay25, btDay26, btDay27, btDay28, btDay29, btDay30;
    private DatabaseHelper databaseHelper;
    private String counterString;
    public int counter = 0, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah_challenge);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Salah Challenge");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        databaseHelper = new DatabaseHelper(this);

        btDay1 = findViewById(R.id.btn_one);
        btDay2 = findViewById(R.id.btn_two);
        btDay3 = findViewById(R.id.btn_three);
        btDay4 = findViewById(R.id.btn_four);
        btDay5 = findViewById(R.id.btn_five);
        btDay6 = findViewById(R.id.btn_six);
        btDay7 = findViewById(R.id.btn_seven);
        btDay8 = findViewById(R.id.btn_eight);
        btDay9 = findViewById(R.id.btn_nine);
        btDay10 = findViewById(R.id.btn_ten);
        btDay11 = findViewById(R.id.btn_eleven);
        btDay12 = findViewById(R.id.btn_twelve);
        btDay13 = findViewById(R.id.btn_thirteen);
        btDay14 = findViewById(R.id.btn_fourteen);
        btDay15 = findViewById(R.id.btn_fifteen);
        btDay16 = findViewById(R.id.btn_sixteen);
        btDay17 = findViewById(R.id.btn_seventeen);
        btDay18 = findViewById(R.id.btn_eighteen);
        btDay19 = findViewById(R.id.btn_nineteen);
        btDay20 = findViewById(R.id.btn_twenty);
        btDay21 = findViewById(R.id.btn_twenty_one);
        btDay22 = findViewById(R.id.btn_twenty_two);
        btDay23 = findViewById(R.id.btn_twenty_three);
        btDay24 = findViewById(R.id.btn_twenty_four);
        btDay25 = findViewById(R.id.btn_twenty_five);
        btDay26 = findViewById(R.id.btn_twenty_six);
        btDay27 = findViewById(R.id.btn_twenty_seven);
        btDay28 = findViewById(R.id.btn_twenty_eight);
        btDay29 = findViewById(R.id.btn_twenty_nine);
        btDay30 = findViewById(R.id.btn_thirty);

        getSalahInformation();

        btDay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 1);
                startActivity(intent);
            }
        });

        btDay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 2);
                startActivity(intent);
            }
        });

        btDay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 3);
                startActivity(intent);
            }
        });

        btDay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 4);
                startActivity(intent);
            }
        });

        btDay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 5);
                startActivity(intent);
            }
        });

        btDay6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 6);
                startActivity(intent);
            }
        });

        btDay7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 7);
                startActivity(intent);
            }
        });

        btDay8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 8);
                startActivity(intent);
            }
        });

        btDay9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 9);
                startActivity(intent);
            }
        });

        btDay10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 10);
                startActivity(intent);
            }
        });

        btDay11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 11);
                startActivity(intent);
            }
        });

        btDay12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 12);
                startActivity(intent);
            }
        });

        btDay13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 13);
                startActivity(intent);
            }
        });

        btDay14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 14);
                startActivity(intent);
            }
        });

        btDay15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 15);
                startActivity(intent);
            }
        });

        btDay16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 16);
                startActivity(intent);
            }
        });

        btDay17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 17);
                startActivity(intent);
            }
        });

        btDay18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 18);
                startActivity(intent);
            }
        });

        btDay19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 19);
                startActivity(intent);
            }
        });

        btDay20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 20);
                startActivity(intent);
            }
        });

        btDay21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 21);
                startActivity(intent);
            }
        });

        btDay22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 22);
                startActivity(intent);
            }
        });

        btDay23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 23);
                startActivity(intent);
            }
        });

        btDay24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 24);
                startActivity(intent);
            }
        });

        btDay25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 25);
                startActivity(intent);
            }
        });

        btDay26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 26);
                startActivity(intent);
            }
        });

        btDay27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 27);
                startActivity(intent);
            }
        });

        btDay28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 28);
                startActivity(intent);
            }
        });

        btDay29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 29);
                startActivity(intent);
            }
        });

        btDay30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalahInformationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("day", 30);
                startActivity(intent);
            }
        });

    }

    @SuppressLint("ResourceAsColor")
    private void getSalahInformation() {

        for (day = 1; day < 31; day++) {
//        Fetch Database Values
            Cursor cursor = databaseHelper.getSalahInformation(String.valueOf(day));

            while (cursor.moveToNext()) {
                counterString = cursor.getString(6);

                if (day == 1) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay1.setBackgroundResource(R.drawable.circular_button_green);
                        btDay1.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 2) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay2.setBackgroundResource(R.drawable.circular_button_green);
                        btDay2.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 3) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay3.setBackgroundResource(R.drawable.circular_button_green);
                        btDay3.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 4) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay4.setBackgroundResource(R.drawable.circular_button_green);
                        btDay4.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 5) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay5.setBackgroundResource(R.drawable.circular_button_green);
                        btDay5.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 6) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay6.setBackgroundResource(R.drawable.circular_button_green);
                        btDay6.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 7) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay7.setBackgroundResource(R.drawable.circular_button_green);
                        btDay7.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 8) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay8.setBackgroundResource(R.drawable.circular_button_green);
                        btDay8.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 9) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay9.setBackgroundResource(R.drawable.circular_button_green);
                        btDay9.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 10) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay10.setBackgroundResource(R.drawable.circular_button_green);
                        btDay10.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 11) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay11.setBackgroundResource(R.drawable.circular_button_green);
                        btDay11.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 12) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay12.setBackgroundResource(R.drawable.circular_button_green);
                        btDay12.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 13) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay13.setBackgroundResource(R.drawable.circular_button_green);
                        btDay13.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 14) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay14.setBackgroundResource(R.drawable.circular_button_green);
                        btDay14.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 15) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay15.setBackgroundResource(R.drawable.circular_button_green);
                        btDay15.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 16) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay16.setBackgroundResource(R.drawable.circular_button_green);
                        btDay16.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 17) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay17.setBackgroundResource(R.drawable.circular_button_green);
                        btDay17.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 18) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay18.setBackgroundResource(R.drawable.circular_button_green);
                        btDay18.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 19) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay19.setBackgroundResource(R.drawable.circular_button_green);
                        btDay19.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 20) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay20.setBackgroundResource(R.drawable.circular_button_green);
                        btDay20.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 21) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay21.setBackgroundResource(R.drawable.circular_button_green);
                        btDay21.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 22) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay22.setBackgroundResource(R.drawable.circular_button_green);
                        btDay22.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 23) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay23.setBackgroundResource(R.drawable.circular_button_green);
                        btDay23.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 24) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay24.setBackgroundResource(R.drawable.circular_button_green);
                        btDay24.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 25) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay25.setBackgroundResource(R.drawable.circular_button_green);
                        btDay25.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 26) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay26.setBackgroundResource(R.drawable.circular_button_green);
                        btDay26.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 27) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay27.setBackgroundResource(R.drawable.circular_button_green);
                        btDay27.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 28) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay28.setBackgroundResource(R.drawable.circular_button_green);
                        btDay28.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 29) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay29.setBackgroundResource(R.drawable.circular_button_green);
                        btDay29.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                } else if (day == 30) {
                    if (counterString.equals("1")) {
                        counter++;
                    }
                    if (counter == 5) {
                        btDay30.setBackgroundResource(R.drawable.circular_button_green);
                        btDay30.setTextColor(R.color.colorWhite);
                        counter = 0;
                    }
                }
            }
        }
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}