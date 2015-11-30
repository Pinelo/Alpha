package com.example.rogelio.saludtec;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hugo on 11/30/15.
 */
public class SleepOneToFiveFragment extends Fragment {

    TextView questionTV;
    Button oneBT;
    Button twoBT;
    Button threeBT;
    Button fourBT;
    Button fiveBT;
    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sleep_1to5, container, false);

        questionTV = (TextView) v.findViewById(R.id.sleepQuestionTV);
        oneBT = (Button)v.findViewById(R.id.oneSleepBT);
        twoBT = (Button)v.findViewById(R.id.twoSleepBT);
        threeBT = (Button)v.findViewById(R.id.threeSleepBT);
        fourBT = (Button)v.findViewById(R.id.fourSleepBT);
        fiveBT = (Button)v.findViewById(R.id.fiveSleepBT);

        questionTV.setText(getArguments().getString("msg"));

        pos = getArguments().getInt("pos");
        oneBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (pos) {
                            case 4:
                                saludCorporal.report.setSleepQuality(1);
                                break;
                            case 13:
                                saludCorporal.report.setEnergy(1);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        int item = vp.getCurrentItem();
                        if (item + 1< vp.getAdapter().getCount()) {
                            vp.setCurrentItem(item + 1, true);
                        }
                        if (pos == 13) {
                            saludCorporal.makeReport();
                        }
                    }
                }
        );
        twoBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (pos) {
                            case 4:
                                saludCorporal.report.setSleepQuality(2);
                                break;
                            case 13:
                                saludCorporal.report.setEnergy(2);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        int item = vp.getCurrentItem();
                        if (item + 1< vp.getAdapter().getCount()) {
                            vp.setCurrentItem(item + 1, true);
                        }
                        if (pos == 13) {
                            saludCorporal.makeReport();
                        }
                    }
                }
        );

        threeBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (pos) {
                            case 4:
                                saludCorporal.report.setSleepQuality(3);
                                break;
                            case 13:
                                saludCorporal.report.setEnergy(3);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        int item = vp.getCurrentItem();
                        if (item + 1< vp.getAdapter().getCount()) {
                            vp.setCurrentItem(item + 1, true);
                        }
                        if (pos == 13) {
                            saludCorporal.makeReport();
                        }
                    }
                }
        );

        fourBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (pos) {
                            case 4:
                                saludCorporal.report.setSleepQuality(4);
                                break;
                            case 13:
                                saludCorporal.report.setEnergy(4);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        int item = vp.getCurrentItem();
                        if (item + 1< vp.getAdapter().getCount()) {
                            vp.setCurrentItem(item + 1, true);
                        }
                        if (pos == 13) {
                            saludCorporal.makeReport();
                        }
                    }
                }
        );

        fiveBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (pos) {
                            case 4:
                                saludCorporal.report.setSleepQuality(5);
                                break;
                            case 13:
                                saludCorporal.report.setEnergy(5);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        int item = vp.getCurrentItem();
                        if (item + 1< vp.getAdapter().getCount()) {

                            vp.setCurrentItem(vp.getCurrentItem()+1, true);
                        }
                        if (pos == 13) {
                            saludCorporal.makeReport();
                        }
                    }
                }
        );








        return v;
    }

    public static SleepOneToFiveFragment newInstance(String question, int pos) {

        SleepOneToFiveFragment f = new SleepOneToFiveFragment();
        Bundle b = new Bundle();
        b.putString("msg", question);
        b.putInt("pos", pos);

        f.setArguments(b);

        return f;
    }
}
