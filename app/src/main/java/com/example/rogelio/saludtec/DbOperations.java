package com.example.rogelio.saludtec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugo on 11/26/15.
 */
public class DbOperations {

    private SQLiteDatabase db;
    private DBHandler dbHandler;

    public DbOperations(Context context) {
        dbHandler = DBHandler.getInstance(context);
    }

    public void cleanDb() {
        db =dbHandler.getWritableDatabase();
        String query = "DELETE FROM " + DBHandler.TABLE_NUTRITION + " WHERE 1";
        db.execSQL(query);
    }

    public void  addWeightReport(int val) {
        db = dbHandler.getWritableDatabase();
        SimpleDateFormat timeFormat  = new SimpleDateFormat("hh:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String time = timeFormat.format(System.currentTimeMillis());
        String date = dateFormat.format(System.currentTimeMillis());

        try{
            ContentValues values = new ContentValues();
            values.put(DBHandler.COLUMN_WEIGHT, val);
            values.put(DBHandler.COLUMN_WEIGHT_DATE, date);
            values.put(DBHandler.COLUMN_WEIGHT_TIME, time);

            db.insert(DBHandler.TABLE_WEIGHT, null, values);

        }catch (SQLiteException e) {
            Log.d("db", "Error saving weight");
        }
    }



    public void addReport(NutritionReport report) {
        db = dbHandler.getWritableDatabase();

        if (checkIfReportHasBeenMade(report)) {
            try{
                ContentValues values = new ContentValues();
                values.put(DBHandler.COLUMN_NUTRITION_ONE, report.getCriteriaOne());
                values.put(DBHandler.COLUMN_NUTRITION_TWO, report.getCriteriaTwo());
                values.put(DBHandler.COLUMN_NUTRITION_THREE, report.getCriteriaThree());
                values.put(DBHandler.COLUMN_NUTRITION_FOUR, report.getCriteriaFour());
                values.put(DBHandler.COLUMN_NUTRITION_FIVE, report.getCriteriaFive());
                values.put(DBHandler.COLUMN_NUTRITION_SIX, report.getCriteriaSix());
                values.put(DBHandler.COLUMN_NUTRITION_SEVEN, report.getCriteriaSeven());
                values.put(DBHandler.COLUMN_NUTRITION_EIGHT, report.getCriteriaEight());
                values.put(DBHandler.COLUMN_NUTRITION_NINE, report.getCriteriaNine());
                values.put(DBHandler.COLUMN_NUTRITION_TEN, report.getCriteriaTen());
                values.put(DBHandler.COLUMN_NUTRITION_DATE, report.getDate());
                values.put(DBHandler.COLUMN_NUTRITION_TIME, report.getTime());

                db.insert(DBHandler.TABLE_NUTRITION, null, values);
                Log.d("db", "Nutrition Report added");

            } catch (SQLiteException e) {
                Log.d("tag", "Error while trying to add product to database");
            }
        }
    }

    public void addReport(SleepReport report) {
        db = dbHandler.getWritableDatabase();

        if (checkIfReportHasBeenMade(report)) {
            try{
                ContentValues values = new ContentValues();
                values.put(DBHandler.COLUMN_LIGHTS_OUT_TIME, report.getLightsOut());
                values.put(DBHandler.COLUMN_WAKE_UP_TIME, report.getWakeUpTime());
                values.put(DBHandler.COLUMN_SLEEP_AMMOUNT, report.getSleepAmmount());
                values.put(DBHandler.COLUMN_NIGHT_WAKE_UPS, report.getNightWakeUps());
                values.put(DBHandler.COLUMN_SLEEP_QUALITY, report.getSleepQuality());
                values.put(DBHandler.COLUMN_SIESTA, report.getSiesta());
                values.put(DBHandler.COLUMN_CAFFEINE_AFTER_SIX, report.getCaffeineAfterSix());
                values.put(DBHandler.COLUMN_ALCOHOL_AFTER_SIX, report.getAlcoholAfterSix());
                values.put(DBHandler.COLUMN_STRESS, report.getStress());
                values.put(DBHandler.COLUMN_SLEEP_MEDICINE, report.getSleepMedicine());
                values.put(DBHandler.COLUMN_RELAX, report.getRelax());
                values.put(DBHandler.COLUMN_DIET, report.getDiet());
                values.put(DBHandler.COLUMN_EXCERCISE, report.getExcercise());
                values.put(DBHandler.COLUMN_ENERGY, report.getEnergy());
                values.put(DBHandler.COLUMN_SLEEP_DATE, report.getDate());
                values.put(DBHandler.COLUMN_SLEEP_TIME, report.getTime());

                db.insert(DBHandler.TABLE_SLEEP, null, values);
                Log.d("db", "Sleep Report added");

            } catch (SQLiteException e) {
                Log.d("tag", "Error while trying to add product to database");
            }
        }
    }

    public int getLastWeight() {
        db = dbHandler.getReadableDatabase();
        String query = " SELECT " + DBHandler.COLUMN_WEIGHT + " FROM " + DBHandler.TABLE_WEIGHT +
                " ORDER BY " + DBHandler.COLUMN_WEIGHT_ID + " DESC LIMIT 1";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            int newestW = cursor.getInt(cursor.getColumnIndex(DBHandler.COLUMN_WEIGHT));
            return newestW;
        } else {
            return 0;
        }
    }

    public int getWeightChange() {
        db = dbHandler.getReadableDatabase();
        String query = " SELECT " + DBHandler.COLUMN_WEIGHT + " FROM " + DBHandler.TABLE_WEIGHT +
                " ORDER BY " + DBHandler.COLUMN_WEIGHT_ID + " ASC LIMIT 1";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() == 0) {
            return 0;
        } else {
            cursor.moveToFirst();
            int originalW = cursor.getInt(cursor.getColumnIndex(DBHandler.COLUMN_WEIGHT));

            query = " SELECT " + DBHandler.COLUMN_WEIGHT + " FROM " + DBHandler.TABLE_WEIGHT +
                    " ORDER BY " + DBHandler.COLUMN_WEIGHT_ID + " DESC LIMIT 1";

            cursor = db.rawQuery(query, null);
            cursor.moveToFirst();
            int newestW = cursor.getInt(cursor.getColumnIndex(DBHandler.COLUMN_WEIGHT));

            return originalW - newestW;
        }


    }

//    returns false if a report has been made for the provided day
    private boolean checkIfReportHasBeenMade(NutritionReport report) {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String date = report.getDate();


//        Calendar cal = Calendar.getInstance();
//        cal.setTime(TODAY);
//        cal.add(Calendar.DAY_OF_MONTH, 1); //Adds a day
//        cal.add(Calendar.DAY_OF_MONTH, -1); //Goes to previous day
//        yourDate = cal.getTime();

        String query = "SELECT * FROM " + DBHandler.TABLE_NUTRITION + " WHERE " +
                DBHandler.COLUMN_NUTRITION_DATE + " = " + date;

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() == 0) {return true;} else {return false;}

    }

    private boolean checkIfReportHasBeenMade(SleepReport report) {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String date = report.getDate();


//        Calendar cal = Calendar.getInstance();
//        cal.setTime(TODAY);
//        cal.add(Calendar.DAY_OF_MONTH, 1); //Adds a day
//        cal.add(Calendar.DAY_OF_MONTH, -1); //Goes to previous day
//        yourDate = cal.getTime();

        String query = "SELECT * FROM " + DBHandler.TABLE_SLEEP + " WHERE " +
                DBHandler.COLUMN_SLEEP_DATE + " = " + date;

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() == 0) {return true;} else {return false;}

    }

    public List<NutritionReport> getNutritionReportsSince(String date) {
        List<NutritionReport> reports = new ArrayList<>();
        NutritionReport report;
        db =dbHandler.getReadableDatabase();

//        Obtiene las ultimas 3
        String query = "SELECT * FROM " + DBHandler.TABLE_NUTRITION + " ORDER BY " +
                DBHandler.COLUMN_NUTRITION_ID + " DESC LIMIT 3";
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext()) {
            report = new NutritionReport(
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_ONE)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_TWO)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_THREE)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_FOUR)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_FIVE)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_SIX)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_SEVEN)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_EIGHT)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_NINE)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_TEN)),
                    cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_DATE)),
                    cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_TIME))
            );
            reports.add(report);
        }
        return reports;
    }

    public List<SleepReport> getSleepReportsSince(String date) {
        List<SleepReport> reports = new ArrayList<>();
        SleepReport report;
        db =dbHandler.getReadableDatabase();

//        Obtiene las ultimas 3
        String query = "SELECT * FROM " + DBHandler.TABLE_SLEEP + " ORDER BY " +
                DBHandler.COLUMN_SLEEP_ID + " DESC LIMIT 3";
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext()) {
            report = new SleepReport(

                    cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_LIGHTS_OUT_TIME)),
                    cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_WAKE_UP_TIME)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_SLEEP_AMMOUNT)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NIGHT_WAKE_UPS)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_SLEEP_QUALITY)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_SIESTA)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_CAFFEINE_AFTER_SIX)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_ALCOHOL_AFTER_SIX)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_STRESS)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_SLEEP_MEDICINE)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_RELAX)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_DIET)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_EXCERCISE)),
                    cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_ENERGY)),
                    cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_SLEEP_DATE)),
                    cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_SLEEP_TIME))
            );
            reports.add(report);
        }
        return reports;
    }

    public NutritionReport findNutritionReportByDate(String date) {
        NutritionReport report;
        db = dbHandler.getReadableDatabase();
//        int i;
        String query = "SELECT * FROM " + DBHandler.TABLE_NUTRITION + " WHERE " +
                DBHandler.COLUMN_NUTRITION_DATE + " = " + date + " LIMIT 1";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        report = new NutritionReport(
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_ONE)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_TWO)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_THREE)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_FOUR)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_FIVE)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_SIX)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_SEVEN)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_EIGHT)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_NINE)),
                cursor.getInt(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_TEN)),
                cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_DATE)),
                cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_NUTRITION_TIME))
        );
        return report;
    }

    public int getNutritionScore() {
        List<NutritionReport> nutritionReports = getNutritionReportsSince("not finished");
        int i;
        float sum = 0, tempS;

        for (i = 0; i < nutritionReports.size(); i++) {
            tempS = nutritionReports.get(i).getGrade();
            sum += tempS;
        }
        if (sum == 0) {
            return  0;
        } else {
            return (int) sum/nutritionReports.size();
        }
    }

    public int getSleepScore() {
        List<SleepReport> sleepReports = getSleepReportsSince("not finished");
        int i;
        float sum = 0, tempS;

        for (i = 0; i < sleepReports.size(); i++) {
            tempS = sleepReports.get(i).getGrade();
            sum += tempS;
        }
        if (sum == 0) {
            return  0;
        } else {
            return (int) sum/sleepReports.size();
        }
    }

    public int[] getNutritionAverages() {
        List<NutritionReport> nutritionReports = getNutritionReportsSince("not finished");

        int criteria;
        int[] criteriaAverages = new int[10];
        int i, j;
        float sum = 0, tempS;
        for (j = 0; j < 10; j++) {

            int[] criteriaList = new int[nutritionReports.size()];
            for (i = 0; i < nutritionReports.size(); i++) {
                criteria = nutritionReports.get(i).getCriteria(j+1);
                criteriaList[i] = criteria;
            }

            criteriaAverages[j] = findAverage(criteriaList);

        }
        return criteriaAverages;
    }

    public int findAverage(int[] list) {
        float average, sum = 0;
        int i, top = list.length*5;

        for (i = 0; i < list.length; i++ ) {
            sum += list[i];
        }
        average = sum/top*100;
        return (int ) average;
    }

    public int getMostRecentSleepScore() {
        List<SleepReport> list = getSleepReportsSince("");
        if (list.size() == 0) {
            return 0;
        } else {
            return (int)list.get(0).getGrade();
        }
    }

    public int getMostRecentFoodScore() {
        List<NutritionReport> list = getNutritionReportsSince("");
        if (list.size() == 0) {
            return 0;
        } else {
            return (int)list.get(0).getGrade();
        }
    }
}
