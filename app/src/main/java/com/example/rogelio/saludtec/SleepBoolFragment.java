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
public class SleepBoolFragment extends Fragment {

    TextView questionTV;
    Button trueBT;
    Button falseBT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sleep_boolean, container, false);

        questionTV = (TextView) v.findViewById(R.id.mainSleepTV);
        trueBT = (Button)v.findViewById(R.id.trueSleepBT);
        falseBT = (Button)v.findViewById(R.id.falseSleepBT);

        trueBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (getArguments().getInt("pos")) {
                            case 5:
                                saludCorporal.report.setSiesta(true);
                                break;
                            case 6:
                                saludCorporal.report.setCaffeineAfterSix(true);
                                break;
                            case 7:
                                saludCorporal.report.setAcoholAfterSix(true);
                                break;
                            case 8:
                                saludCorporal.report.setStress(true);
                                break;
                            case 9:
                                saludCorporal.report.setSleepMedicine(true);
                                break;
                            case 10:
                                saludCorporal.report.setRelax(true);
                                break;
                            case 11:
                                saludCorporal.report.setDiet(true);
                                break;
                            case 12:
                                saludCorporal.report.setExcercise(true);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        vp.setCurrentItem(vp.getCurrentItem() + 1);
                    }
                }
        );

        falseBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (getArguments().getInt("pos")) {
                            case 5:
                                saludCorporal.report.setSiesta(false);
                                break;
                            case 6:
                                saludCorporal.report.setCaffeineAfterSix(false);
                                break;
                            case 7:
                                saludCorporal.report.setAcoholAfterSix(false);
                                break;
                            case 8:
                                saludCorporal.report.setStress(false);
                                break;
                            case 9:
                                saludCorporal.report.setSleepMedicine(false);
                                break;
                            case 10:
                                saludCorporal.report.setRelax(false);
                                break;
                            case 11:
                                saludCorporal.report.setDiet(false);
                                break;
                            case 12:
                                saludCorporal.report.setExcercise(false);
                                break;

                        }
                        ViewPager vp=(ViewPager) getActivity().findViewById(R.id.sleepVP);
                        vp.setCurrentItem(vp.getCurrentItem() + 1);
                    }
                }
        );

        questionTV.setText(getArguments().getString("msg"));



        return v;
    }

    public static SleepBoolFragment newInstance(String question, int pos) {

        SleepBoolFragment f = new SleepBoolFragment();
        Bundle b = new Bundle();
        b.putString("msg", question);
        b.putInt("pos", pos);

        f.setArguments(b);

        return f;
    }
}
