package com.example.rogelio.saludtec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity {

    ImageButton editProfileIB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
}
