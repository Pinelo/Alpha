package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    ImageButton editProfileIB;
    TextView userNameTV;
    TextView userEmailTV;
    TextView userHeightTV;
    TextView userGenderTV;
    TextView userWeightTV;
    TextView profileWeightLabelTV;
    ImageView userProfileIV;
    DbOperations dbo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        dbo = new DbOperations(this);

        userNameTV = (TextView)findViewById(R.id.profileName);
        userEmailTV = (TextView)findViewById(R.id.profileEmail);
        userHeightTV = (TextView)findViewById(R.id.profileHeight);
        userGenderTV = (TextView)findViewById(R.id.userGenderTV);
        userWeightTV = (TextView)findViewById(R.id.profileWeightTV);
        profileWeightLabelTV = (TextView)findViewById(R.id.profileWeightLabelTV);
        userProfileIV = (ImageView)findViewById(R.id.userProfile);
//        actualiza los nombres
        updateTextViews();

        editProfileIB = (ImageButton)findViewById(R.id.editProfileBT);
        editProfileIB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent editProfileIntent = new Intent(Profile.this, EditProfile.class);
                        startActivity(editProfileIntent);
                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTextViews();
    }

    private void updateTextViews() {
        SharedPreferences sharedPreferences = getSharedPreferences(EditProfile.USER_PROFILE,
                Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(EditProfile.USER_NAME, "");
        String userEmail = sharedPreferences.getString(EditProfile.USER_EMAIL, "");
        String userHeight = sharedPreferences.getString(EditProfile.USER_HEIGHT, "");
        String userGender = sharedPreferences.getString(EditProfile.USER_GENDER, "");
        String userProfile = sharedPreferences.getString(EditProfile.USER_PROFILE, "");
        userHeight = userHeight + " Metros";
        Bitmap profilePic = decodeBase64(userProfile);

        int weightChange = dbo.getWeightChange();
        if (weightChange >= 0) {
            userWeightTV.setText(Integer.toString(weightChange));
            profileWeightLabelTV.setText("Kg Perdidos");

        } else {
            weightChange = weightChange * -1;
            userWeightTV.setText(Integer.toString(weightChange));
            profileWeightLabelTV.setText("Kg Ganados");

        }


        userNameTV.setText(userName);
        userEmailTV.setText(userEmail);
        userHeightTV.setText(userHeight);
        userGenderTV.setText(userGender);
//        userProfileIV.setImageBitmap(profilePic);


    }

    public static Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory
                .decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
