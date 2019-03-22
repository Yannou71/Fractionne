package com.example.yannis.fractionne;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activity_TestLocalisation extends AppCompatActivity {

    private TextView tLocalisationX, tLocalisationY, tDistance, tTime;
    private final int updateTimeFrequency = 1000 * 3;
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
        LocationManager locationManager = (LocationManager) this.getSystemService(this.getBaseContext().LOCATION_SERVICE);

        //On crée le Listener
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                tLocalisationX.setText(""+location.getLatitude());
                tLocalisationY.setText(""+location.getLongitude());
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
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

    }




}
