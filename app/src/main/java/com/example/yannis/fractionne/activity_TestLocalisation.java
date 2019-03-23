package com.example.yannis.fractionne;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

import static android.location.Location.FORMAT_DEGREES;
import static android.location.Location.FORMAT_MINUTES;
import static android.location.Location.convert;


public class activity_TestLocalisation extends AppCompatActivity {



    private TextView tLocalisationX, tLocalisationY, tDistance, tTime;
    private final long updateTimeFrequency = 1000;
    private final float updateDistanceFrequency = 1/100;
    private final int MY_PERMISSIONS_REQUEST_LOCALISATION=314;
    Timer timer,timerFast;
    private int fastInterval,slowInterval,restInterval;
    Location lastLocalisation=null;
    private int timePassed=0;
    float currentDistance=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__test_localisation);
        timerFast = new Timer();
        timer=new Timer();
        fastInterval=10*1000;
        timerFast.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        timePassed=0;
                        float speed = (currentDistance/1000)/fastInterval;
                        //tDistance.setText("speed "+speed+"distance " + currentDistance);
                        tTime.setText("0");
                        //currentDistance=0;
                    }
                });
            }
        },0,fastInterval);



        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        timePassed++;
                        tTime.setText(""+timePassed);
                    }
                });
            }
        },0,1000);

        //On recupere les Texte Views
        tLocalisationX = findViewById(R.id.TestX);
        tLocalisationY = findViewById(R.id.TestY);
        tDistance = findViewById(R.id.TestDistance);
        tTime = findViewById(R.id.TestTime);


        //Création du Localisation Manager
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);


        //On crée le Listener
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                if(lastLocalisation!=null){
                    tLocalisationX.setText(""+location.getLongitude());
                    tLocalisationY.setText(lastLocalisation.getLongitude()+"");

                    currentDistance=location.distanceTo(lastLocalisation)+currentDistance;
                    Log.d("testDistance",""+location.distanceTo(lastLocalisation)*100);
                    Log.d("testACCURACY",""+location.getAccuracy()*100);
                    tDistance.setText(""+currentDistance);
                }
                lastLocalisation=location;





            }

            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };


        //On recupere la localistion contenue dans le Manager
        //Le if sert juste à ce que ça compile, pas besoin de comprendre







        if (ContextCompat.checkSelfPermission(activity_TestLocalisation.this, Manifest.permission.ACCESS_FINE_LOCATION )!= PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted

        }

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity_TestLocalisation.this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity_TestLocalisation.this,Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(activity_TestLocalisation.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSIONS_REQUEST_LOCALISATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, updateTimeFrequency, updateDistanceFrequency, locationListener);








    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCALISATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }















}
