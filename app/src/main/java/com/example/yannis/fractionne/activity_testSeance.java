package com.example.yannis.fractionne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class activity_testSeance extends AppCompatActivity {

    private TextView Ninterval,duration,distance,averageFast,averageSlow;

    private final int TIME_FAST_INTERVAL=30*1000;
    private final int TIME_SLOW_INTERVAL=30*1000;
    private final int TIME_REST=90*1000;
    private final int NCYCLE = 8;
    private final int Nrepetition=2;
    private Timer timeFast,timeSlow;
    private ArrayList<Interval> programme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testSeance);

        //On recupere les Texte View
        Ninterval = findViewById(R.id.testSinProInterval);
        duration = findViewById(R.id.testSinProDuration);
        distance= findViewById(R.id.testSinProDistance);
        averageFast=findViewById(R.id.testSinProVFast);
        averageSlow=findViewById(R.id.testSinProVSlow);


        //Create timer

        timeFast = new Timer();
        timeFast.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },0,TIME_FAST_INTERVAL);





    }




}
