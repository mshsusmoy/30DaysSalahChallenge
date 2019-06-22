package rktuhinbd.salahchallenge.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "salahinformation.db";
    private static final int VERSION = 1;

    private static final String SALAH_INFORMATION_TABLE = "salah_information";
    private static final String ID = "id";
    private static final String DAY = "day";
    private static final String SALAH_NAME = "salah_name";
    private static final String FARZ = "farz";
    private static final String SUNNAH = "sunnah";
    private static final String NAFL = "nafl";
    private static final String COUNTER = "counter";

    //SALAH INFORMATION TABLE CREATION QUERY
    private static final String CREATE_SALAH_INFORMATION_TABLE = "CREATE TABLE " + SALAH_INFORMATION_TABLE + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DAY + " VARCHAR(2) NOT NULL, "
            + SALAH_NAME + " VARCHAR(10) NOT NULL, "
            + FARZ + " VARCHAR(2) NOT NULL, "
            + SUNNAH + " VARCHAR(2), "
            + NAFL + " VARCHAR(2), "
            + COUNTER + " INTEGER(2))";
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_SALAH_INFORMATION_TABLE);
        } catch (Exception e) {
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SALAH_INFORMATION_TABLE);
        onCreate(db);
    }

    //Insert data into Salah Information Table
    public long insertSalahInformation(String day, String salahName, String farz, String sunnah, String nafl, int counter) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DAY, day);
        contentValues.put(SALAH_NAME, salahName);
        contentValues.put(FARZ, farz);
        contentValues.put(SUNNAH, sunnah);
        contentValues.put(NAFL, nafl);
        contentValues.put(COUNTER, counter);

        long input = sqLiteDatabase.insert(SALAH_INFORMATION_TABLE, null, contentValues);

        if (input == -1) {
            Toast.makeText(context, "Insertion Failure!", Toast.LENGTH_SHORT).show();
        }
        return input;
    }

    //Retrieve data from Salah Information Table
    public Cursor getSalahInformation(String day) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        final Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("Select * from " + SALAH_INFORMATION_TABLE + " WHERE " + DAY + "= '" + day + "'", null);
        return cursor;
    }

    //Clear all data from Salah Information Table
    public void clearSalahInformation() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + SALAH_INFORMATION_TABLE);
    }
}