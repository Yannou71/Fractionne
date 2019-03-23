package com.example.yannis.fractionne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button test;
    Button training;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.MainTestLocalisation);
        test.setOnClickListener(listenerTestLocalissation);

        training = findViewById(R.id.BMainTraining);
        training.setOnClickListener(listenerTestTraining);


    }


    private View.OnClickListener listenerTestLocalissation = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,activity_TestLocalisation.class);
            Log.d("test","appuie sur test");
            startActivity(intent);
        }
    };

    private View.OnClickListener listenerTestTraining = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MainActivity.this,testCalculDistance.class);
            Log.d("test","appui sur ");
            startActivity(intent1);
        }
    };

}
