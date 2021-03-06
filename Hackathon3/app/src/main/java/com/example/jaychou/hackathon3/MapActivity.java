package com.example.jaychou.hackathon3;

/**
 * Created by jaychou on 4/21/17.
 */

import android.app.ActionBar;
import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.location.Geocoder;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import android.content.Intent;
import java.util.ArrayList;
import java.util.*;
import android.util.Log;


public class MapActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap map;
    private LatLng myLocation;
    private LatLng latLng;

    private ArrayList<String> namelist;
    private ArrayList<String> schedulelist;
    private ArrayList<String> locationlist;
    private TextView tv1;
    private String bding;


    double lat , lng;
    Geocoder geocoder = null;
    List<Address> addressList = null;

    ArrayList<String> location;


    private List<List<Event>> biglist;
    //will contain all the locations
//    ArrayList<Painting> receivedArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);


//        final Intent i = getIntent();
//
//        bding=i.getStringExtra("Bdname");


        tv1 = (TextView) findViewById(R.id.tv1);


        namelist=new ArrayList<String>();
        schedulelist=new ArrayList<String>();
        locationlist=new ArrayList<String>();

        lat=0;
        lng=0;






        readFromFile("courseNameTemp2.txt",namelist);
        readFromFile("courseScheduleTemp2.txt",schedulelist);
        readFromFile("courseLocationTemp2.txt",locationlist);

//        String s=namelist.get(1);
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//



//
//        for (int i=0;i<namelist.size(); i++){
//            s=s.concat(namelist.get(i));
//        }

//        tv2.setText(namelist.get(0));


        geocoder = new Geocoder(this);





        //gets the maps to load
        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
        mf.getMapAsync(this);


//        Toast.makeText(this, Integer.toString(namelist.size()), Toast.LENGTH_SHORT).show();



        ArrayList<Course> courselist = new ArrayList<Course>();
        for (int i = 0; i < namelist.size(); i++){
            Course c = new Course(namelist.get(i), schedulelist.get(i), BuildingUpLocations.getAcademicBuilding(locationlist.get(i)));
            courselist.add(c);
        }


        Week week = new Week(courselist);

        biglist = week.listView();




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Calendar c = Calendar.getInstance();
        int current = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);
        int day = c.get(Calendar.DAY_OF_WEEK);
        boolean isCurrentDay = false;

        switch (item.getItemId()) {
            case R.id.menu_0:
                // do stuff here
                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();

                map.clear();



                getPlace(namelist,schedulelist,locationlist);

                tv1.setText("Weekly Schedule");


                return true;

            case R.id.menu_1:
                // do stuff here
                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();

                map.clear();


                isCurrentDay = (day == 2);

                getPlace2(biglist.get(0), isCurrentDay);

                tv1.setText("Monday Schedule");

                Toast.makeText(this, "Monday Selected", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.menu_2:
                // do stuff here

                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();

                map.clear();

                isCurrentDay = (day == 3);

                getPlace2(biglist.get(1), true);

                tv1.setText("Tuesday Schedule");


                Toast.makeText(this, "Tuesday Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_3:
//                // do stuff here
                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();

                map.clear();

                isCurrentDay = (day == 4);

                getPlace2(biglist.get(2), isCurrentDay);

                tv1.setText("Wednesday Schedule");

                Toast.makeText(this, "Wednesday Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_4:
                // do stuff here
                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();

                map.clear();

                isCurrentDay = (day == 5);

                getPlace2(biglist.get(3), isCurrentDay);
                tv1.setText("Thursday Schedule");

                Toast.makeText(this, "Thursday Selected", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.menu_5:
                // do stuff here

                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();

                map.clear();

                isCurrentDay = (day == 6);

                getPlace2(biglist.get(4), isCurrentDay);

                tv1.setText("Friday Schedule");
                Toast.makeText(this, "Friday Selected", Toast.LENGTH_SHORT).show();
                return true;



            case R.id.menu_6:
                // do stuff here

                Intent back=new Intent(MapActivity.this, MainActivity.class);
                startActivity(back);

                return true;




            default:
                return super.onOptionsItemSelected(item);
        }
    }




    @Override
    public void onMapReady(GoogleMap map) {    // map is loaded but not laid out yet
        this.map = map;
        map.setOnMapLoadedCallback(this);      // calls onMapLoaded when layout done
        UiSettings mapSettings;
        mapSettings = map.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);
        map.setMyLocationEnabled(true);
    }


    // maps are loaded and this is where I should perform the findArt() function to find my art
    //note use of geocoder.getFromLocationName() to find LonLat from address

    @Override
    public void onMapLoaded() {
        // code to run when the map has loaded
//        findPlace(); // call this --> use a geoCoder to find the location of the art

        //getPlace(namelist,schedulelist,locationlist);

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);


        // do stuff here
        if ((day >= 2) && (day <= 6)) {
            map = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.the_map)).getMap();

            map.clear();

            getPlace2(biglist.get(day - 2), true);

            tv1.setText("Schedule");

        }

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String title = marker.getSnippet();
//                Painting toSend;
//                //String url = "";
//                for (int i = 0; i < receivedArt.size(); i++) {
//                    if (title.equals(receivedArt.get(i).getTitle())) {
//                        toSend = receivedArt.get(i);
//                        Intent image = new Intent(getApplicationContext(), ImageActivity.class);
//                        image.putExtra("paintObject", toSend);
//                        startActivity(image);
//                        break;
//                    }
//                }
                return false;
            }
        });
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String course = marker.getTitle();

                Intent email=new Intent(MapActivity.this,EmailActivity.class);
                email.putExtra("course",course);
                startActivity(email);
                //Toast.makeText(getApplicationContext(), "Info window clicked", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "title: " + title, Toast.LENGTH_LONG).show();
//                Painting toSend;
//                for (int i = 0; i < receivedArt.size(); i++) {
//                    if (title.equals("Title: " + receivedArt.get(i).getTitle())) {
//                        toSend = receivedArt.get(i);
//                        //Toast.makeText(getApplicationContext(), "Was the same" + title, Toast.LENGTH_LONG).show();
//                        Intent image = new Intent(getApplicationContext(), ImageActivity.class);
//                        image.putExtra("paintObject", toSend);
//                        startActivity(image);
//                        break;
//                    }
//                }
            }
        });

        // read user's current location, if possible
        myLocation = getMyLocation();
        if (myLocation == null) {
            //Toast.makeText(this, "Unable to access your location. Consider enabling Location in your device's Settings.", Toast.LENGTH_LONG).show();
        } else {
            map.addMarker(new MarkerOptions()
                    .position(myLocation)
                    .title("ME!")
            );
        }
    }

    // might need to pass the View arg0 as an argument but maybe not
    //note use of geocoder.getFromLocationName() to find LonLat from address
    //geocoder.getFromLocationName(locations.get(i),1); returns only 1 possbile
    //matched lonlat from the address




    public void getPlace(List<String> list1,List<String> list2,List<String> list3){
        // loop through the ArrayList of locations and create a geocoder location for each
        for (int i = 0; i < list3.size(); i++) {

            if (map == null) {
                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();
            }

            lat = BuildingUpLocations.getAcademicBuilding(list3.get(i).toString()).getLocation().lat;
            lng = BuildingUpLocations.getAcademicBuilding(list3.get(i).toString()).getLocation().lng;
            latLng = new LatLng(lat, lng);


            map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(list1.get(i).toString())
                    .snippet(list3.get(i).toString()+"  " + list2.get(i).toString())
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));


        }

    }



    public void getPlace2(List<Event> levent, boolean isCurrentDay){
        // loop through the ArrayList of locations and create a geocoder location for each
        for (int i = 0; i < levent.size(); i++) {

            Calendar c = Calendar.getInstance();
            int current = c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE);

            if (map == null) {
                map = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.the_map)).getMap();
            }

            lat = levent.get(i).getEventLat();
            lng = levent.get(i).getEventLng();
            latLng = new LatLng(lat, lng);

            //Log.v("xxd", Integer.toString(levent.get(i).startMinSince12));
            //Log.v("xd", Integer.toString(current));


            if (isCurrentDay && (current > levent.get(i).startMinSince12)) {                                        // Past Event
                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(levent.get(i).getEventName())
                        .snippet(levent.get(i).getBuildingName()+"  "+levent.get(i).getTime())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                        .alpha(0.2f));
            } else if (isCurrentDay && (current < levent.get(i).startMinSince12) && (levent.get(i).previousEvent.startMinSince12 < current)){                      // Next Event
                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(levent.get(i).getEventName())
                        .snippet(levent.get(i).getBuildingName()+"   " + levent.get(i).getTime())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            } else if (isCurrentDay && (current < levent.get(i).startMinSince12)) {                      // Future Event
                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(levent.get(i).getEventName())
                        .snippet(levent.get(i).getBuildingName()+"  "+levent.get(i).getTime())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        .alpha(0.5f));
            }   else {
                map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(levent.get(i).getEventName())
                        .snippet(levent.get(i).getBuildingName()+"  "+levent.get(i).getTime())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            }


        }

    }


    /*
         * Returns the user's current location as a LatLng object.
         * Returns null if location could not be found (such as in an AVD emulated virtual device).
         */

    private LatLng getMyLocation() {
        // try to get location three ways: GPS, cell/wifi network, and 'passive' mode
//        requestPermissions();

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (loc == null) {
            // fall back to network if GPS is not available
            loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        if (loc == null) {
            // fall back to "passive" location if GPS and network are not available
            loc = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
        }

        if (loc == null) {
            //Toast.makeText(this, "Unable to access your location. Consider enabling Location in your device's Settings.", Toast.LENGTH_LONG).show();
            return null;   // could not get user's location
        } else {
            double myLat = loc.getLatitude();
            double myLng = loc.getLongitude();
            return new LatLng(myLat, myLng);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (myLocation != null) {
            LatLng markerLatLng = marker.getPosition();
            map.addPolyline(new PolylineOptions()
                    .add(myLocation)
                    .add(markerLatLng)
            );
            return true;
        } else {
            return false;
        }
    }

    private void saveStringToFile(String fileName, String stringToBeSaved) {
        FileOutputStream fos;
        try {
            fos = openFileOutput(fileName, Context.MODE_PRIVATE | Context.MODE_APPEND);
            fos.write(stringToBeSaved.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void readFromFile(String taskname,List<String> list) { //reads from a file and uses StringBuilder to create a large string


        try {


            Scanner scan = new Scanner(openFileInput(taskname));

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                list.add(line);
//                adapter.notifyDataSetChanged();

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void removeFromFile(String taskname,List<String> filelist, String StoRemove){
        filelist.remove(StoRemove);
        try {
            PrintStream file = new PrintStream(openFileOutput(taskname, MODE_PRIVATE));
            for (int i = 0; i < filelist.size(); i++) {
                file.println(filelist.get(i));

            }


            file.close();
        } catch (Exception e) {

        }


    }
}