package com.example.rogelio.saludtec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    static String LOG_TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        final Button perfil = (Button) findViewById(R.id.perfil);

        View.OnClickListener next = new View.OnClickListener(){

            @Override
            public void onClick(View v){
                try{
                    Intent intent = new Intent(Principal.this, CreandoPerfil.class);
                    startActivity(intent);
                }
                catch(Exception e){
                    Log.e(LOG_TAG, "Failed to display message", e);
                }
            }
        };perfil.setOnClickListener(next);
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
