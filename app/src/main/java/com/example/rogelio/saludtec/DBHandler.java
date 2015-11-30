package com.example.rogelio.saludtec;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hugo on 11/25/15.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
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

    public static final String TABLE_WEIGHT = "tableWeight";
    public static final String COLUMN_WEIGHT  = "weight";
    public static final String COLUMN_WEIGHT_ID = "weight_id";
    public static final String COLUMN_WEIGHT_DATE = "date";
    public static final String COLUMN_WEIGHT_TIME = "time";

    public static final String TABLE_SLEEP = "tableSleep";
    public static final String COLUMN_SLEEP_ID = "sleep_id";
    public static final String COLUMN_LIGHTS_OUT_TIME = "criteria_one";
    public static final String COLUMN_WAKE_UP_TIME = "criteria_two";
    public static final String COLUMN_SLEEP_AMMOUNT = "criteria_three";
    public static final String COLUMN_NIGHT_WAKE_UPS = "criteria_four";
    public static final String COLUMN_SLEEP_QUALITY = "criteria_five";
    public static final String COLUMN_SIESTA = "criteria_six";
    public static final String COLUMN_CAFFEINE_AFTER_SIX = "criteria_seven";
    public static final String COLUMN_ALCOHOL_AFTER_SIX = "criteria_eight";
    public static final String COLUMN_STRESS = "criteria_nine";
    public static final String COLUMN_SLEEP_MEDICINE = "criteria_ten";
    public static final String COLUMN_RELAX = "criteria_eleven";
    public static final String COLUMN_DIET = "criteria_twelve";
    public static final String COLUMN_EXCERCISE = "criteria_thirteen";
    public static final String COLUMN_ENERGY = "criteria_fourteen";
    public static final String COLUMN_SLEEP_DATE = "date";
    public static final String COLUMN_SLEEP_TIME = "time";



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
        Log.d("db", "created nutrition table");

        String CREATE_WEIGHTS_TABLE = "CREATE TABLE " + TABLE_WEIGHT +
                "(" + COLUMN_WEIGHT_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_WEIGHT + " INTEGER, " +
                COLUMN_WEIGHT_DATE + " TEXT, " +
                COLUMN_WEIGHT_TIME + " TEXT " + ")";

        db.execSQL(CREATE_WEIGHTS_TABLE);
        Log.d("db", "created weight table");

        String CREATE_SLEEP_TABLE = "CREATE TABLE " + TABLE_SLEEP +
                "(" + COLUMN_SLEEP_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_LIGHTS_OUT_TIME + " TEXT, " +
                COLUMN_WAKE_UP_TIME + " TEXT, " +
                COLUMN_SLEEP_AMMOUNT + " INTEGER, " +
                COLUMN_NIGHT_WAKE_UPS + " INTEGER, " +
                COLUMN_SLEEP_QUALITY + " INTEGER, " +
                COLUMN_SIESTA + " INTEGER, " +
                COLUMN_CAFFEINE_AFTER_SIX + " INTEGER, " +
                COLUMN_ALCOHOL_AFTER_SIX + " INTEGER, " +
                COLUMN_STRESS + " INTEGER, " +
                COLUMN_SLEEP_MEDICINE + " INTEGER, " +
                COLUMN_RELAX + " INTEGER, " +
                COLUMN_DIET + " INTEGER, " +
                COLUMN_EXCERCISE + " INTEGER, " +
                COLUMN_ENERGY + " INTEGER, "+
                COLUMN_SLEEP_DATE + " TEXT, " +
                COLUMN_SLEEP_TIME + " TEXT )";

        db.execSQL(CREATE_SLEEP_TABLE);
        Log.d("db", "created sleep table");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NUTRITION);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SLEEP);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEIGHT);

            Log.d("db", "updated database");
            onCreate(db);
        }
    }
}
