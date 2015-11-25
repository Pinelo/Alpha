package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    public static final String USER_NAME = "userName";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_HEIGHT = "userHeight";
    public static final String FIRST_TIME = "firstTime";
    public static final String USER_PROFILE = "userProfile";
    Button editProfileSaveBT;
    EditText userNameET;
    EditText userEmailET;
    NumberPicker userWeightET;
    EditText userHeightET;
    ImageView userProfileIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        userNameET = (EditText)findViewById(R.id.userNameET);
        userEmailET = (EditText)findViewById(R.id.userEmailET);
        userWeightET = (NumberPicker)findViewById(R.id.userWeightNP);
        userHeightET = (EditText)findViewById(R.id.userHeightET);
        userProfileIV = (ImageView)findViewById(R.id.userProfileIV);

//      minimo para el peso de usuario
        userWeightET.setMinValue(30);

        updateTextViews();

        editProfileSaveBT = (Button)findViewById(R.id.editProfileSaveBT);
        editProfileSaveBT.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = getSharedPreferences(USER_PROFILE,
                                Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(USER_NAME, userNameET.getText().toString());
                        editor.putString(USER_EMAIL, userEmailET.getText().toString());
                        editor.putString(USER_HEIGHT, userHeightET.getText().toString());
//                        code for user weight, and image
                        editor.putBoolean(FIRST_TIME, false);
                        editor.commit();

                        Toast.makeText(getApplicationContext(), "Se han guardado los datos",
                                Toast.LENGTH_LONG).show();
                        finish();

                    }
                }
        );
    }

    private void updateTextViews() {
        SharedPreferences sharedPreferences = getSharedPreferences(EditProfile.USER_PROFILE,
                Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(USER_NAME, "");
        String userEmail = sharedPreferences.getString(USER_EMAIL, "");
        String userHeight = sharedPreferences.getString(USER_HEIGHT, "");

        userNameET.setText(userName);
        userEmailET.setText(userEmail);
        userHeightET.setText(userHeight);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_login, menu);
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
