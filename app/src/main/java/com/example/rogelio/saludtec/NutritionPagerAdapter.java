package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hugo on 11/15/15.
 */
public class NutritionPagerAdapter extends FragmentStatePagerAdapter {
//    String[] titles;
    String[] texts;
    String[] subTexts;

    public NutritionPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        Resources resources = context.getResources();
        texts = resources.getStringArray(R.array.texts);
        subTexts = resources.getStringArray(R.array.subTexts);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new NutritionFormFragment();
        Bundle args = new Bundle();
//        args.putInt(MenuFragment.ARG_IMAGE_ID, getImageId(position));
        args.putString(NutritionFormFragment.ARG_MAIN, texts[position]);
        args.putString(NutritionFormFragment.ARG_SUB, subTexts[position]);
        fragment.setArguments(args);
        return fragment;

    }

    //    indica cuantas opciones habra para el menu (la cantidad de titulos)
    @Override
    public int getCount() {
        return texts.length;
    }

    //    funcion que liga a cada view con un titulo
    @Override
    public CharSequence getPageTitle(int position) {
//        return "OBJECT " + (position + 1);
        return position + "/" + texts.length;
    }
}

