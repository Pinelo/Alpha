package com.example.rogelio.saludtec;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


//Esta clase es el widget para le formulario de nutrición.

/**
 * Created by hugo on 11/15/15.
 */


public class NutritionViewPager extends ViewPager {

    private boolean isPagingEnabled = false;

    public NutritionViewPager(Context context) {
        super(context);
    }

    public NutritionViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }
}
