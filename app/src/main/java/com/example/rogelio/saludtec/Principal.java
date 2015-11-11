package com.example.rogelio.saludtec;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Principal extends FragmentActivity {

    static String LOG_TAG = "Main Activity";
    Button menuEnterBt;
    CollectionPagerAdapter menuCollectionAdapter;
    ViewPager menuViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        menuCollectionAdapter =
                new CollectionPagerAdapter(
                        getSupportFragmentManager(), getApplicationContext());
        menuViewPager = (ViewPager) findViewById(R.id.pager);
        menuViewPager.setAdapter(menuCollectionAdapter);


//        View.OnClickListener next = new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                if (perfil.isPressed()) {
//                    Intent mapaintent = new Intent(Principal.this, CreandoPerfil.class);
//                    startActivity(mapaintent);
//                } else if (saludAlimenticia.isPressed()) {
//                    Intent mapaintent2 = new Intent(Principal.this, SaludAlimenticia.class);
//                    startActivity(mapaintent2);
//                } else if (saludCorporal.isPressed()) {
//                    Intent telintent = new Intent(Principal.this, saludCorporal.class);
//                    startActivity(telintent);
//                } else if (reportesSemaforo.isPressed()) {
//                    Intent fotointent = new Intent(Principal.this, reporteSemaforo.class);
//                    startActivity(fotointent);
//                }
//            }
//        };
//    perfil.setOnClickListener(next);
//        saludAlimenticia.setOnClickListener(next);
//        saludCorporal.setOnClickListener(next);
//        reportesSemaforo.setOnClickListener(next);
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
