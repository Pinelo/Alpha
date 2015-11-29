package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class SaludAlimenticia extends AppCompatActivity {

    public static String LAST_UPDATE = "lastNutritionUpdate";

    NutritionPagerAdapter mViewPagerAdapter;
    NutritionViewPager mViewPager;
    Button oneBT;
    Button twoBT;
    Button threeBT;
    Button fourBT;
    Button fiveBT;
    int completedCriterias = 0;
    NutritionReport report = new NutritionReport();
    DbOperations dbo;

    SimpleDateFormat timeFormat  = new SimpleDateFormat("hh:mm");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud_alimenticia);
        dbo = new DbOperations(this);

        oneBT = (Button)findViewById(R.id.oneNutBT);
        twoBT = (Button)findViewById(R.id.twoNutBT);
        threeBT = (Button)findViewById(R.id.threeNutBT);
        fourBT = (Button)findViewById(R.id.fourNutBT);
        fiveBT = (Button)findViewById(R.id.fiveNutBT);

        Long time = System.currentTimeMillis();

        String currentTime = timeFormat.format(time);
        String currentDate = dateFormat.format(time);
        report.setTime(currentTime);
        report.setDate(currentDate);

//        Toast.makeText(getApplicationContext(), format, Toast.LENGTH_LONG).show();

        mViewPagerAdapter =
                new NutritionPagerAdapter(
                        getSupportFragmentManager(), getApplicationContext());
        mViewPager= (NutritionViewPager) findViewById(R.id.nutritionVP);
        mViewPager.setAdapter(mViewPagerAdapter);

       setButtonListeners();
    }

    private void setButtonListeners() {
        oneBT.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                oneBT.setBackgroundColor(Color.WHITE);
                                oneBT.setTextColor(Color.parseColor("#3A1952"));
                                int item = mViewPager.getCurrentItem();
                                report.setGrade(item, 1);
                                if (item + 1< mViewPagerAdapter.getCount()) {
                                    mViewPager.setCurrentItem(item + 1, true);
                                }
                                if (++completedCriterias == 10) {
                                    addReport(report);
                                }
                                break;
                            case MotionEvent.ACTION_UP:
                                oneBT.setBackgroundColor(Color.parseColor("#3A1952"));
                                oneBT.setTextColor(Color.WHITE);
                                break;
                        }

                        return true;

                    }
                }
        );

        twoBT.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                twoBT.setBackgroundColor(Color.WHITE);
                                twoBT.setTextColor(Color.parseColor("#3A1952"));
                                int item = mViewPager.getCurrentItem();
                                report.setGrade(item, 2);
                                if (item + 1< mViewPagerAdapter.getCount()) {
                                    mViewPager.setCurrentItem(item + 1, true);
                                }
                                if (++completedCriterias == 10) {
                                    addReport(report);
                                }
                                break;
                            case MotionEvent.ACTION_UP:
                                // PRESSED
                                twoBT.setBackgroundColor(Color.parseColor("#3A1952"));
                                twoBT.setTextColor(Color.WHITE);
                                break;
                        }
                        return true;
                    }
                }
        );

        threeBT.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                threeBT.setBackgroundColor(Color.WHITE);
                                threeBT.setTextColor(Color.parseColor("#3A1952"));
                                int item = mViewPager.getCurrentItem();
                                report.setGrade(item, 3);
                                if (item + 1< mViewPagerAdapter.getCount()) {
                                    mViewPager.setCurrentItem(item + 1, true);
                                }
                                if (++completedCriterias == 10) {
                                    addReport(report);
                                }
                                break;
                            case MotionEvent.ACTION_UP:
                                // PRESSED
                                threeBT.setBackgroundColor(Color.parseColor("#3A1952"));
                                threeBT.setTextColor(Color.WHITE);
                                break;
                        }
                        return true;
                    }
                }
        );

        fourBT.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                fourBT.setBackgroundColor(Color.WHITE);
                                fourBT.setTextColor(Color.parseColor("#3A1952"));
                                int item = mViewPager.getCurrentItem();
                                report.setGrade(item, 4);
                                if (item + 1< mViewPagerAdapter.getCount()) {
                                    mViewPager.setCurrentItem(item + 1, true);
                                }
                                if (++completedCriterias == 10) {
                                    addReport(report);
                                }
                                break;
//
                            case MotionEvent.ACTION_UP:
                                // PRESSED
                                fourBT.setBackgroundColor(Color.parseColor("#3A1952"));
                                fourBT.setTextColor(Color.WHITE);
                                break;
                        }
                        return true;
                    }
                }
        );

        fiveBT.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                fiveBT.setBackgroundColor(Color.WHITE);
                                fiveBT.setTextColor(Color.parseColor("#3A1952"));
                                int item = mViewPager.getCurrentItem();
                                report.setGrade(item, 5);
                                if (item + 1< mViewPagerAdapter.getCount()) {
                                    mViewPager.setCurrentItem(item + 1, true);
                                }
                                if (++completedCriterias == 10) {
                                    addReport(report);
                                }
                                break;
                            case MotionEvent.ACTION_UP:
                                // PRESSED
                                fiveBT.setBackgroundColor(Color.parseColor("#3A1952"));
                                fiveBT.setTextColor(Color.WHITE);
                                break;
                        }
                        return true;
                    }
                }
        );

    }

    private void addReport(NutritionReport report) {
        dbo.addReport(report);
        SharedPreferences sharedPreferences = getSharedPreferences(EditProfile.USER_PROFILE,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LAST_UPDATE, dateFormat.format(System.currentTimeMillis()));
        editor.commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salud_alimenticia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
