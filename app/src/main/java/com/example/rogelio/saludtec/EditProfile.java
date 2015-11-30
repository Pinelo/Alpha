package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class EditProfile extends AppCompatActivity {

    public static final String USER_NAME = "userName";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_HEIGHT = "userHeight";
    public static final String FIRST_TIME = "firstTime";
    public static final String USER_PROFILE = "userProfile";
    public static final String USER_GENDER = "userGender";
    static final int REQUEST_IMAGE_CAPTURE= 1;

    Button editProfileSaveBT;
    EditText userNameET;
    EditText userEmailET;
    NumberPicker userWeightET;
    EditText userHeightET;
    ImageButton userProfileIV;
    RadioGroup userGenderRG;
    RadioButton maleRB;
    RadioButton femaleRB;

    Bitmap photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        userNameET = (EditText)findViewById(R.id.userNameET);
        userEmailET = (EditText)findViewById(R.id.userEmailET);
        userWeightET = (NumberPicker)findViewById(R.id.userWeightNP);
        userHeightET = (EditText)findViewById(R.id.userHeightET);
        userProfileIV = (ImageButton)findViewById(R.id.userProfileIV);
        userGenderRG = (RadioGroup)findViewById(R.id.userGenderRG);
        maleRB = (RadioButton)findViewById(R.id.maleRB);
        femaleRB = (RadioButton)findViewById(R.id.femaleRB);

//      minimo para el peso de usuario
        userWeightET.setMinValue(30);
//        user.setMaxValue(1000);
        userWeightET.setWrapSelectorWheel(false);

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
                        editor.putString(USER_PROFILE, encodeTobase64(photo));

                        int id = userGenderRG.indexOfChild(findViewById(
                                userGenderRG.getCheckedRadioButtonId()));

                        String userGender;
                        if (id == 0) {
                            userGender = "Masculino";
                        } else {
                            userGender = "Femenino";
                        }


                        editor.putString(USER_GENDER, userGender);
//                        code for user weight, and image
                        editor.putBoolean(FIRST_TIME, false);


//                        save image on sdCard and save path of image to shared preferences
                        editor.putString("imagepath", "/sdcard/imh.jpeg");

                        editor.commit();

                        Toast.makeText(getApplicationContext(), "Se han guardado los datos",
                                Toast.LENGTH_LONG).show();
                        finish();

                    }
                }
        );

        userProfileIV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        launchCamera(v);
                    }
                }
        );
    }

    //    toma foto
    public void launchCamera(View view) {
        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            photo = (Bitmap)extras.get("data");
            userProfileIV.setImageBitmap(photo);
        }

    }

    private void updateTextViews() {
        SharedPreferences sharedPreferences = getSharedPreferences(EditProfile.USER_PROFILE,
                Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(USER_NAME, "");
        String userEmail = sharedPreferences.getString(USER_EMAIL, "");
        String userHeight = sharedPreferences.getString(USER_HEIGHT, "");
        String gender = sharedPreferences.getString(USER_GENDER, "");
        String userProfile = sharedPreferences.getString(USER_PROFILE, "");
        Bitmap profile = Profile.decodeBase64(userProfile);

        if (gender.equals("Masculino")) {
            maleRB.setChecked(true);
        } else {
            femaleRB.setChecked(true);
        }

        userNameET.setText(userName);
        userEmailET.setText(userEmail);
        userHeightET.setText(userHeight);
        userProfileIV.setImageBitmap(profile);


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

    // method for bitmap to base64
    public static String encodeTobase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }
}
