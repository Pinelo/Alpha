package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Principal extends FragmentActivity {

    static String LOG_TAG = "Main Activity";
    Button menuEnterBt;
    CollectionPagerAdapter menuCollectionAdapter;
    ViewPager menuViewPager;
    View middleCircle;
    ViewGroup menuLayout;
    TextView scoreTV;
    TextView scoreLabelTV;
    ImageButton profileIB;

    private int scoreHealth = 87;
    private int scoreSleep = 40;
    private int[] scores = {scoreHealth, scoreSleep, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        firstTimeSetup();

        profileIB = (ImageButton)findViewById(R.id.enterProfileBT);
        scoreTV = (TextView)findViewById(R.id.scoreTV);
        scoreLabelTV = (TextView)findViewById(R.id.scoreLabelTV);

        middleCircle = findViewById(R.id.middleCircleV);
        menuCollectionAdapter =
                new CollectionPagerAdapter(
                        getSupportFragmentManager(), getApplicationContext());
        menuViewPager = (ViewPager) findViewById(R.id.pager);
        menuViewPager.setAdapter(menuCollectionAdapter);

        menuEnterBt = (Button)findViewById(R.id.menuEnterBT);
        menuEnterBt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int item = menuViewPager.getCurrentItem();
                        Intent intent;
                        switch (item) {
                            case 0:
                                intent = new Intent(Principal.this, SaludAlimenticia.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(Principal.this, saludCorporal.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(Principal.this, reporteSemaforo.class);
                                startActivity(intent);
                                break;
                        }
                    }
                }
        );

        menuViewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                        int item = menuViewPager.getCurrentItem();
                        if (item == 2) {
                            circleAnimationSmallHide();
                        } else {
                            circleAnimation(scores[item]);
                        }


                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                }
        );

        profileIB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent profileIntent = new Intent(Principal.this, Profile.class);
                        startActivity(profileIntent);
                    }
                }
        );
    }

//    crea un perfil si es la primera vez
    private void firstTimeSetup() {
        SharedPreferences sharedPreferences = getSharedPreferences("userProfile",
                Context.MODE_PRIVATE);
        Boolean firstTime = sharedPreferences.getBoolean(EditProfile.FIRST_TIME, true);

        if (firstTime) {
            Intent firstTimeEditProfile = new Intent(Principal.this, EditProfile.class);
            startActivity(firstTimeEditProfile);
        }
    }

    public void circleAnimation(int score) {


        int size;
        if ((score * 4)< 300) {
            size = 360;
        } else {
            size = score * 6;
        }
        scoreTV.setVisibility(View.VISIBLE);
        scoreLabelTV.setVisibility(View.VISIBLE);
        scoreTV.setText(Integer.toString(score));

        menuLayout = (ViewGroup)findViewById(R.id.menuSecLayout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(menuLayout);
        }
        ViewGroup.LayoutParams sizeRules = middleCircle.getLayoutParams();
//            sizeRules.width = ((int) getResources().getDimension(R.dimen.scoreCircleDim)) * scale;
        sizeRules.width = size;
        sizeRules.height = size;
        middleCircle.setLayoutParams(sizeRules);

    }

    public void circleAnimationSmallHide() {

        menuLayout = (ViewGroup)findViewById(R.id.menuSecLayout);
//        solo sirve en versiones 18+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(menuLayout);
        }

        ViewGroup.LayoutParams sizeRules = middleCircle.getLayoutParams();
        sizeRules.width = 0;
        sizeRules.height = 0;
        middleCircle.setLayoutParams(sizeRules);
        scoreTV.setVisibility(View.GONE);
        scoreLabelTV.setVisibility(View.GONE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
