package com.example.yannis.fractionne;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class testCalculDistance extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_LOCALISATION = 4242;
    private TextView X1,X2,Y1,Y2,result;
    private Button bDepart,bArrive;
    private LocationManager locationManager;
    private Location locationDepart,locationArrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_calcul_distance);

        X2 = findViewById(R.id.testXArrive);
        X1 = findViewById(R.id.testXDepart);
        Y1 = findViewById(R.id.testYDepart);
        Y2=findViewById(R.id.testYArrive);
        bDepart=findViewById(R.id.testDistanceButton1);
        bArrive=findViewById(R.id.testDistanceButton2);
        result=findViewById(R.id.testResultDistance);


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(testCalculDistance.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(testCalculDistance.this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(testCalculDistance.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCALISATION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.



            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }


        };







        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);





        bDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextCompat.checkSelfPermission(testCalculDistance.this, Manifest.permission.ACCESS_FINE_LOCATION);
                locationDepart  = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                X1.setText(""+locationDepart.getLatitude());
                Y1.setText(""+locationDepart.getLongitude());
            }
        });

        bArrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContextCompat.checkSelfPermission(testCalculDistance.this, Manifest.permission.ACCESS_FINE_LOCATION);
                locationArrive  = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                X2.setText(""+locationArrive.getLatitude());
                Y2.setText(""+locationArrive.getLongitude());

                result.setText(""+locationArrive.distanceTo(locationArrive)*100);
            }
        });









    }




}
