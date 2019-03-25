package com.example.yannis.fractionne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonSeance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSeance = findViewById(R.id.BMainTraining);
        buttonSeance.setOnClickListener(listenerBouton);
    }

    private View.OnClickListener listenerBouton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,activity_testSeance.class);
            startActivity(intent);
        }
    };

}
