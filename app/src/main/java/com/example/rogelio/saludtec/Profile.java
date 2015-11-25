package com.example.rogelio.saludtec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    ImageButton editProfileIB;
    TextView userNameTV;
    TextView userEmailTV;
    TextView userHeightTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userNameTV = (TextView)findViewById(R.id.profileName);
        userEmailTV = (TextView)findViewById(R.id.profileEmail);
        userHeightTV = (TextView)findViewById(R.id.profileHeight);

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

    private void updateTextViews() {
        SharedPreferences sharedPreferences = getSharedPreferences(EditProfile.USER_PROFILE,
                Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(EditProfile.USER_NAME, "");
        String userEmail = sharedPreferences.getString(EditProfile.USER_EMAIL, "");
        String userHeight = sharedPreferences.getString(EditProfile.USER_HEIGHT, "");

        userNameTV.setText(userName);
        userEmailTV.setText(userEmail);
        userHeightTV.setText(userHeight + " Metros");
    }
}
