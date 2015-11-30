package com.example.rogelio.saludtec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugo on 11/30/15.
 */


public class SleepHourFragment extends Fragment{

    TextView questionTV;
    NumberPicker hourNP;
    String[] values;
    Button finishedBT;
    String hourValue;
    int timeValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sleep_hour, container, false);
        boolean def = getArguments().getBoolean("default");

        finishedBT = (Button)v.findViewById(R.id.hourFinishedBT);

        questionTV = (TextView) v.findViewById(R.id.mainSleepTV);
        questionTV.setText(getArguments().getString("msg"));


        hourNP = (NumberPicker)v.findViewById(R.id.sleepNP);
        hourNP.setMaxValue(12);
        hourNP.setMinValue(0);
        hourNP.setWrapSelectorWheel(false);

        if (!def) {
            values = getArguments().getStringArray("values");
            hourNP.setMaxValue(values.length-1);
            hourNP.setValue(0);
            hourNP.setFormatter(new NumberPicker.Formatter() {

                @Override
                public String format(int value) {
                    return values[value];
                }
            });
        }

        finishedBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (getArguments().getInt("pos")) {
                            case 0:
                                hourValue = values[hourNP.getValue()];
                                saludCorporal.report.setLightsOut(hourValue);
                                break;
                            case 1:
                                hourValue = values[hourNP.getValue()];
                                saludCorporal.report.setWakeUpTime(hourValue);
                                break;
                            case 2:
                                timeValue = hourNP.getValue();
                                saludCorporal.report.setSleepAmmount(timeValue);
                                break;
                            case 3:
                                timeValue = hourNP.getValue();
                                saludCorporal.report.setNightWakeUps(timeValue);
                                break;
                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        vp.setCurrentItem(vp.getCurrentItem() + 1);

                    }
                }
        );

        return v;
    }



    public static SleepHourFragment newInstance(String question, String[] values, boolean def, int pos) {

        SleepHourFragment f = new SleepHourFragment();
        Bundle b = new Bundle();
        b.putString("msg", question);
        b.putBoolean("default", def);
        b.putInt("pos", pos);
        if (!def) {
            b.putStringArray("values", values);
        }

        f.setArguments(b);

        return f;
    }
}
