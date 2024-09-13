package com.upn.contactsapp.activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upn.contactsapp.R;
import com.upn.contactsapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LocationManager mLocationManager;
    private Location lastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        lastLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // si quisiera solicitar la ubicacion cada x segundos, o cada x metros recorridos
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 300, 1, new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                if (mMap == null) return;

                LatLng ubicacion = new LatLng(location.getLatitude(), location.getLongitude());

                mMap.addMarker(new MarkerOptions().position(ubicacion).title("Ubicacion actual"));
                mMap.clear();
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 14));
            }
        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng currentLatLng = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());

        mMap.addMarker(new MarkerOptions().position(currentLatLng).title("Ubicacion Atual"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 14));
    }

//    @Override
//    public void onLocationChanged(@NonNull Location location) {
//        if (mMap == null) return;
//
//        LatLng ubicacion = new LatLng(location.getLatitude(), location.getLongitude());
//
//        mMap.addMarker(new MarkerOptions().position(ubicacion).title("Ubicacion actual"));
//        mMap.clear();
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 14));
//    }
}