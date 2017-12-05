package io.github.alexlondon07.finalproject.view.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.model.cinemas.Cinema;
import io.github.alexlondon07.finalproject.model.cinemas.Location;
import io.github.alexlondon07.finalproject.model.cinemas.LocationsList;
import io.github.alexlondon07.finalproject.presenter.DetailRecordPresenter;
import io.github.alexlondon07.finalproject.view.BaseFragment;

public class MapsActivity extends BaseFragment<DetailRecordPresenter> implements IRecordDetail,OnMapReadyCallback {

    private GoogleMap mMap;
    private String TAG = "MapsActivity.class";
    private ArrayList<Cinema> cinemaArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setPresenter(new DetailRecordPresenter());
        getPresenter().inject(this,getValidateInternet());
        createProgresDialog();
        getPresenter().getCinemaPresenter();

        if(checkPlayServices()) {
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }
    }

    //Validate google services
    private boolean checkPlayServices() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int result = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if(result != ConnectionResult.SUCCESS){
            if(googleApiAvailability.isUserResolvableError(result)){
                googleApiAvailability.getErrorDialog(this, result, 9000).show();
            }
            return false;
        }
        return true;
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
    }

    private void changeStateControls() {
        UiSettings uisettings = mMap.getUiSettings();
        uisettings.setZoomControlsEnabled(true);
        uisettings.setCompassEnabled(true);//Brujula
        uisettings.setMyLocationButtonEnabled(true);//Ubicación
    }

    /**
     * Función para marcar los puntos de los cinemas de la pelicula seleccionada
     * @param cinemaArrayList
     */
    private void createMarkers(ArrayList<Cinema> cinemaArrayList) {

        if(cinemaArrayList !=null){
            ArrayList<LatLng> points = new ArrayList<>();
            List<LocationsList> locationsLists = cinemaArrayList.get(0).getLocationList();

            for (LocationsList location :locationsLists){

                Location newLocation = location.getLocation();

                LatLng point = new LatLng(newLocation.getCoordinates()[1], newLocation.getCoordinates()[0]);

                //Se agrega cada punto obtenido del servicio
                MarkerOptions markerOptions =
                        new MarkerOptions()
                                .position(point)
                                .title(location.getName())
                                .icon(bitmapDescriptorFromVector(this, R.drawable.ic_location_on_black_24dp));

                mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(point));

                points.add(point);
            }
            centerRoutes(points);

        }else{
            Toast.makeText(this, R.string.location_error, Toast.LENGTH_SHORT).show();
        }
    }

    RoutingListener routingListener = new RoutingListener() {
        @Override
        public void onRoutingFailure(RouteException e) {
            Log.e(TAG, e.getMessage());
        }

        @Override
        public void onRoutingStart() {
            Log.i(TAG, "onRoutingStart");
        }

        @Override
        public void onRoutingSuccess(ArrayList<Route> routes, int shortestRouteIndex) {

            String [] colorsAll = getResources().getStringArray(R.array.array_colors);
            ArrayList polyLines = new ArrayList<>();

            for(int i = 0; i < routes.size(); i++){
                PolylineOptions polyLineOptions = new PolylineOptions();
                int valor = new Random().nextInt(colorsAll.length);
                polyLineOptions.color(Color.parseColor(colorsAll[valor]));
                polyLineOptions.width(8);
                polyLineOptions.addAll(routes.get(i).getPoints());
                Polyline polyLine = mMap.addPolyline(polyLineOptions);
                polyLines.add(polyLine);
            }
        }

        @Override
        public void onRoutingCancelled() {
            Log.e(TAG, "onRoutingCancelled");
        }
    };


    private void calculateRouteCinemas(ArrayList<LatLng> points) {
        Routing routing = new Routing.Builder()
                .travelMode(AbstractRouting.TravelMode.DRIVING)
                .waypoints(points)
                .key(getString(R.string.google_maps_key))
                .optimize(true)
                .alternativeRoutes(true)
                .withListener(routingListener)
                .build();
        routing.execute();
        centerRoutes(points);
    }


    /**
     * Función para centras todos los puntos marcados en el Mapa
     * @param points
     */
    private void centerRoutes(ArrayList<LatLng> points){
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < points.size(); i++){
            builder.include(points.get(i));
        }
        LatLngBounds bounds = builder.build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 18);
        mMap.animateCamera(cameraUpdate);

        changeStateControls();
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorId) {

        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorId);
        vectorDrawable.setBounds(0,0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public void showCinemas(final ArrayList<Cinema> cinemaArrayList) {

        this.cinemaArrayList = cinemaArrayList;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                createMarkers(cinemaArrayList);
            }
        });
    }

    @Override
    public void showAlertDialog(int title, int message) {
        showAlert(title, message);
    }

    /**
     * Función para mostrar un Dialog en caso que ocurra un error en la App
     * @param title
     * @param message
     */
    public void showAlert(final int title, final int message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().getCinemaPresenter();
                    }
                }, R.string.option_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        });
    }

}
