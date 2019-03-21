package com.example.yannis.fractionne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_TestLocalisation extends AppCompatActivity {

    private TextView tLocalisationX, tLocalisationY,tDistance,tTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__test_localisation);

        //On recupere les Texte View
        tLocalisationX = findViewById(R.id.TestX);
        tLocalisationY = findViewById(R.id.TestY);
        tDistance = findViewById(R.id.TestDistance);
        tTime = findViewById(R.id.TestTime);


    }




}
