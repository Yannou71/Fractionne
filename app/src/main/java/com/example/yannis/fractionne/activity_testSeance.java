package com.example.yannis.fractionne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class activity_testSeance extends AppCompatActivity {

    private TextView Ninterval,duration,distance,averageFast,averageSlow,currentDisplayTime;

    private final int TIME_FAST_INTERVAL=30*1000;
    private final int TIME_SLOW_INTERVAL=30*1000;
    private final int TIME_REST=90*1000; //Temps de pause entre 2 cycles
    private final int CYCLE = 2; //Nombre de cycle complet
    private final int REPETITION=8; // Nombre de repetition lent/rapide
    private final int PAUSE = CYCLE-1;
    private Timer timeFast,timeSlow;
    private ArrayList<Interval> resSeance= new ArrayList<Interval>();
    private int currentTimeInterval=0,delay=0;
    private double distanceParcourue,speed;
    private String typeInterval = "slow";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_seance);

        //On recupere les Texte View
        Ninterval = findViewById(R.id.testSinProInterval);
        duration = findViewById(R.id.testSinProDuration);
        distance= findViewById(R.id.testSinProDistance);
        averageFast=findViewById(R.id.testSinProVFast);
        averageSlow=findViewById(R.id.testSinProVSlow);
        currentDisplayTime = findViewById(R.id.testTimePast);

        Timer priseMesure = new Timer();
        priseMesure.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentTimeInterval++;
                        currentDisplayTime.setText(""+currentTimeInterval);
                    }
                });

            }
        },0,1000);




    }
        Timer[] tabTimer = createTimerSeance();



    private Timer[] createTimerSeance(){
        Timer[] tabTimer = new Timer[CYCLE*REPETITION*2+ PAUSE];
        Log.v("test",""+CYCLE*REPETITION*2+ PAUSE);
        int j=0,k=0;
        for(int i=0;i<CYCLE;i++) {
            while (j < REPETITION * 2) {
                tabTimer[k]= new Timer();
                tabTimer[k].schedule(new TimerTask() {
                    @Override
                    public void run() {
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               currentTimeInterval=0;
                               Interval i;
                               if(typeInterval=="fast"){
                                   Log.d("test","je suis dans le if"+ delay);
                                   distanceParcourue=120+Math.random()*((130-120)+1);
                                   typeInterval="slow";
                                   i = new Interval(1,"Fast",distanceParcourue,distanceParcourue/TIME_FAST_INTERVAL);
                                   delay=delay+TIME_FAST_INTERVAL;
                                   duration.setText("interval fini"+distanceParcourue);
                               }else{
                                   Log.d("test","je suis dans le else");
                                   distanceParcourue=60+Math.random()*((70-60)+1);
                                   typeInterval="fast";
                                   i = new Interval(1,"Slow",distanceParcourue,distanceParcourue/TIME_SLOW_INTERVAL);
                                   delay=delay+TIME_SLOW_INTERVAL;
                                   duration.setText("interval fini"+distanceParcourue);
                               }


                               Log.d("test",i.toString());
                               resSeance.add(i);
                           }
                       });

                    }
                },delay);
                Log.v("test","AAAAAAA "+delay);
                k++;
                j++;
            }
            tabTimer[k]=new Timer();
            tabTimer[k].schedule(new TimerTask() {
                @Override
                public void run() {
                    distanceParcourue=20+(int)Math.random()*((30-20)+1);
                    Interval iRest = new Interval(  1,"pause",distanceParcourue,distanceParcourue/TIME_REST);
                    delay+=TIME_REST;
                }
            },delay);
            k++;

        }


        return tabTimer;
    }


}
