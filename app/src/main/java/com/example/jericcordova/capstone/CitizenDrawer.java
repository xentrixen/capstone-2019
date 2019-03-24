package com.example.jericcordova.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jericcordova.capstone.Activity.SendReportActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CitizenDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private  GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.citizen_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker in Sydney and move the camera
        LatLng cebuCity = new LatLng(10.3157, 123.8854);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cebuCity,10.2f));

        LatLng maboloFirestation = new LatLng(10.312321, 123.915915);
        mMap.addMarker(new MarkerOptions().position(maboloFirestation).title("Mabolo Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(maboloFirestation));

        LatLng parianFirestation = new LatLng(10.299204, 123.903502);
        mMap.addMarker(new MarkerOptions().position(parianFirestation).title("Parian Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(parianFirestation));

        LatLng pahenaFirestation = new LatLng(10.297949, 123.892188);
        mMap.addMarker(new MarkerOptions().position(pahenaFirestation).title("Pahena Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pahenaFirestation));

        LatLng sannicolasFirestation = new LatLng(10.292299, 123.891351);
        mMap.addMarker(new MarkerOptions().position(sannicolasFirestation).title("San Nicolas Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sannicolasFirestation));

        LatLng hipodromoFirestation = new LatLng(10.313945, 123.906560);
        mMap.addMarker(new MarkerOptions().position(hipodromoFirestation).title("Hipodromo Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hipodromoFirestation));

        LatLng lahugFirestation = new LatLng(10.324282, 123.898454);
        mMap.addMarker(new MarkerOptions().position(lahugFirestation).title("Lahug Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lahugFirestation));

        LatLng labangonFirestation = new LatLng(10.299095, 123.881065);
        mMap.addMarker(new MarkerOptions().position(labangonFirestation).title("Labangon Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(labangonFirestation));

        LatLng pardoFirestation = new LatLng(10.278953, 123.854886);
        mMap.addMarker(new MarkerOptions().position(pardoFirestation).title("Pardo Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pardoFirestation));

        LatLng guadalupeFirestation = new LatLng(10.322570, 123.883932);
        mMap.addMarker(new MarkerOptions().position(guadalupeFirestation).title("Guadalupe Fire Station"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(guadalupeFirestation));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(this,SendReportActivity.class);
        startActivity(intent);
    }
}
