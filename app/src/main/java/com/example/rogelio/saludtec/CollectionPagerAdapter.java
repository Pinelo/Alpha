package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by hugo on 11/11/15.
 */
public class CollectionPagerAdapter extends FragmentStatePagerAdapter {
    String[] options;

    public CollectionPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        Resources resources = context.getResources();
        options = resources.getStringArray(R.array.options);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putInt(MenuFragment.ARG_IMAGE_ID, getImageId(position));
        fragment.setArguments(args);
        return fragment;

    }


//    recibe una imagen dependiendo del indice
    private int getImageId(int position) {
        int id = R.mipmap.ic_launcher;
        switch (position) {
            case 0: id = R.mipmap.one;
                break;
            case 1: id = R.mipmap.two;
                break;
            case 2: id = R.mipmap.three;
                break;
        }
        return id;
    }

//    indica cuantas opciones habra para el menu (la cantidad de titulos)
    @Override
    public int getCount() {
        return options.length;
    }

//    funcion que liga a cada view con un titulo
    @Override
    public CharSequence getPageTitle(int position) {
//        return "OBJECT " + (position + 1);
        return options[position];
    }
}
