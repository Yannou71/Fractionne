package com.example.yannis.fractionne;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class activity_TestLocalisation extends AppCompatActivity {

    private TextView tLocalisationX, tLocalisationY, tDistance, tTime;
    private final int updateTimeFrequency = 0;
    private final int updateDistanceFrequency = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__test_localisation);


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
                tLocalisationX.setText(""+location.getLatitude());
                tLocalisationY.setText(""+location.getLongitude());
                tTime.setText("I'm update");
                Log.v("localisation","je change");
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.v("localisation","je change");
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };


        //On recupere la localistion contenue dans le Manager
        //Le if sert juste à ce que ça compile, pas besoin de comprendre
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Log.v("localisation","je suis la1");
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        Log.v("localisation","je suis la2");
        Location l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        Log.v("localisation",""+l);
        Log.v("localisation","je suis ici");

    }




}
