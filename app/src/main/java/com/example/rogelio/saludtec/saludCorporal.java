package com.example.rogelio.saludtec;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;

public class saludCorporal extends AppCompatActivity {

    public static String LAST_FITNESS_UPDATE = "lastFitnessUpdate";
    public static SleepReport report = new SleepReport();
    public String[] lightsOutValues;
//    public String[] sleepAmmountValues;
    public String[] wakeUpValues;

//    public String[] nightWakeUpValues;

//    public static void setLightsOutValues(String value) {
//        report.setLightsOut(value);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud_corporal);

        lightsOutValues = getResources().getStringArray(R.array.lightsOutValues);
        wakeUpValues = getResources().getStringArray(R.array.wakeUpValues);

        ViewPager pager = (ViewPager) findViewById(R.id.sleepVP);
        pager.setAdapter(new SleepPagerAdapter(getSupportFragmentManager()));
    }

    public static void makeReport() {
        SimpleDateFormat timeFormat  = new SimpleDateFormat("hh:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        report.setDate(dateFormat.format(System.currentTimeMillis()));
        report.setTime(timeFormat.format(System.currentTimeMillis()));


//        SleepReport sReport = report;
    }

    private class SleepPagerAdapter extends FragmentPagerAdapter {

        public SleepPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            Fragment fragment = new Fragment();
//            ArrayList<String> values = new ArrayList<>();

            switch(pos) {

                case 0:
                    fragment = SleepHourFragment.newInstance("¿A qué hora apagó la luz?", lightsOutValues, false, pos);
                    break;
                case 1:
                    fragment = SleepHourFragment.newInstance("¿A qué hora se levantó?", wakeUpValues, false, pos);
                    break;
                case 2: fragment = SleepHourFragment.newInstance("¿Cuántas horas durmió en total?", wakeUpValues, true, pos);
                    break;
                case 3: fragment = SleepHourFragment.newInstance("¿Cuántas veces se despertó en la noche?", wakeUpValues, true, pos);
                    break;
                case 4: fragment = SleepOneToFiveFragment.newInstance("Califique la calidad de sueño. \n(5 = mejor)", pos);
                    break;
                case 5: fragment = SleepBoolFragment.newInstance("¿Evitó tomar una siesta ayer?", pos);
                    break;
                case 6: fragment = SleepBoolFragment.newInstance("¿Evitó tomar cafeina después de las 6pm?", pos);
                    break;
                case 7: fragment = SleepBoolFragment.newInstance("¿Evitó tomar alcohol después de las 6pm?", pos);
                    break;
                case 8: fragment = SleepBoolFragment.newInstance("¿Hizo algo ayer para reducir el estrés?", pos);
                    break;
                case 9: fragment = SleepBoolFragment.newInstance("¿Evitó los medicamentos para dormir?", pos);
                    break;
                case 10: fragment = SleepBoolFragment.newInstance("¿Hizo algo para relajarse antes de dormir?", pos);
                    break;
                case 11: fragment = SleepBoolFragment.newInstance("¿Comió ayer una dieta balanceada?", pos);
                    break;
                case 12: fragment = SleepBoolFragment.newInstance("¿Hizo ejercicio ayer?", pos);
                    break;
                case 13: fragment = SleepOneToFiveFragment.newInstance("¿En que nivel de alerta y energia se sintió durante el día? \n (5 = mejor)", pos);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 14;
        }
    }

//    private ArrayList<String> fillListWithString(String[] stringArray) {
//        int i;
//        ArrayList<String> values = new ArrayList<>();
//        for(i = 0; i < stringArray.length; i++) {
//            values.add(stringArray[i]);
//        }
//        return values;
//    }
}
