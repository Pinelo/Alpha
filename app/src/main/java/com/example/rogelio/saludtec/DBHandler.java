package com.example.rogelio.saludtec;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hugo on 11/25/15.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "saludTec";

    public static final String TABLE_NUTRITION = "tableNutrition";
    public static final String COLUMN_NUTRITION_ID = "nutrition_id";
    public  static final String COLUMN_NUTRITION_ONE = "criteria_one";
    public static final String COLUMN_NUTRITION_TWO = "criteria_two";
    public static final String COLUMN_NUTRITION_THREE = "criteria_three";
    public static final String COLUMN_NUTRITION_FOUR = "criteria_four";
    public static final String COLUMN_NUTRITION_FIVE= "criteria_five";
    public static final String COLUMN_NUTRITION_SIX = "criteria_six";
    public static final String COLUMN_NUTRITION_SEVEN = "criteria_seven";
    public static final String COLUMN_NUTRITION_EIGHT = "criteria_eight";
    public static final String COLUMN_NUTRITION_NINE = "criteria_nine";
    public static final String COLUMN_NUTRITION_TEN = "criteria_ten";
    public static final String COLUMN_NUTRITION_DATE = "date";
    public static final String COLUMN_NUTRITION_TIME = "time";

    private static DBHandler dbHandlerInstance;

    public static synchronized DBHandler getInstance(Context context) {
        if (dbHandlerInstance == null) {
            dbHandlerInstance = new DBHandler(context.getApplicationContext());
        }
        return dbHandlerInstance;
    }

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_NUTRITION +
                                        "(" + COLUMN_NUTRITION_ID + " INTEGER PRIMARY KEY, " +
                                        COLUMN_NUTRITION_ONE + " INTEGER, " +
                                        COLUMN_NUTRITION_TWO + " INTEGER, " +
                                        COLUMN_NUTRITION_THREE + " INTEGER, " +
                                        COLUMN_NUTRITION_FOUR + " INTEGER, " +
                                        COLUMN_NUTRITION_FIVE + " INTEGER, " +
                                        COLUMN_NUTRITION_SIX + " INTEGER, " +
                                        COLUMN_NUTRITION_SEVEN + " INTEGER, " +
                                        COLUMN_NUTRITION_EIGHT + " INTEGER, " +
                                        COLUMN_NUTRITION_NINE + " INTEGER, " +
                                        COLUMN_NUTRITION_TEN + " INTEGER, " +
                                        COLUMN_NUTRITION_DATE + " TEXT, " +
                                        COLUMN_NUTRITION_TIME + " TEXT " + ")";

        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DRP[ TABLE IF EXISTS " + TABLE_NUTRITION);
            Log.d("db", "updated database");
            onCreate(db);
        }
    }
}
