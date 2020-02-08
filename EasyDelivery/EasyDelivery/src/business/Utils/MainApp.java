package business.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renu
 */
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.smartystreets.api.us_street.Lookup;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application implements MapComponentInitializedListener {

    GoogleMapView mapView;
    GoogleMap map;

    @Override
    public void start(Stage stage) throws Exception {

        //Create the JavaFX component and set this as a listener so we know when 
        //the map has been initialized, at which point we can then begin manipulating it.
        mapView = new GoogleMapView();
        mapView.addMapInializedListener(this);

        Scene scene = new Scene(mapView);

        stage.setTitle("Google Maps");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void mapInitialized() {
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(40.5, -74.3))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = mapView.createMap(mapOptions);

        //Add a marker to the map 
        MarkerOptions markerOptions = new MarkerOptions();
        Lookup lookup = new Lookup();

        markerOptions.position(new LatLong(47.6, -122.3))
                .visible(Boolean.TRUE)
                .title("Seattle");

        Marker marker = new Marker(markerOptions);

        map.addMarker(marker);

        //Adding one more marker Boston
        MarkerOptions markerOptions1 = new MarkerOptions();

        markerOptions1.position(new LatLong(42.3, -71.0))
                .visible(Boolean.TRUE)
                .title("Boston");

        Marker marker1 = new Marker(markerOptions1);

        map.addMarker(marker1);

        //Adding one more marker New york
        MarkerOptions markerOptions2 = new MarkerOptions();

        markerOptions2.position(new LatLong(40.7, -74.0))
                .visible(Boolean.TRUE)
                .title("New York");

        Marker marker2 = new Marker(markerOptions2);

        map.addMarker(marker2);

        //Adding one more marker san francisco
        MarkerOptions markerOptions3 = new MarkerOptions();

        markerOptions3.position(new LatLong(37.7, -122.4))
                .visible(Boolean.TRUE)
                .title("San Francisco");

        Marker marker3 = new Marker(markerOptions2);

        map.addMarker(marker3);

        //Adding one more marker New York
        MarkerOptions markerOptions4 = new MarkerOptions();

        markerOptions4.position(new LatLong(40.5, -74.3))
                .visible(Boolean.TRUE)
                .title("New York.");

        Marker marker4 = new Marker(markerOptions2);

        map.addMarker(marker4);

        //Adding one more marker New York
        MarkerOptions markerOptions5 = new MarkerOptions();

        markerOptions5.position(new LatLong(40.5, -74.3))
                .visible(Boolean.TRUE)
                .title("New York..");

        Marker marker5 = new Marker(markerOptions5);

        map.addMarker(marker5);

        //Adding one more marker san francisco
        MarkerOptions markerOptions6 = new MarkerOptions();

        markerOptions6.position(new LatLong(37.0, -122.4))
                .visible(Boolean.TRUE)
                .title("San Fransisco.");

        Marker marker6 = new Marker(markerOptions6);

        map.addMarker(marker6);

        //Adding one more marker san francisco
        MarkerOptions markerOptions7 = new MarkerOptions();

        markerOptions7.position(new LatLong(37.0, -122.0))
                .visible(Boolean.TRUE)
                .title("San Fransisco..");

        Marker marker7 = new Marker(markerOptions7);

        map.addMarker(marker7);

        //Adding one more marker New york
        MarkerOptions markerOptions8 = new MarkerOptions();

        markerOptions8.position(new LatLong(42.7, -74.0))
                .visible(Boolean.TRUE)
                .title("Albany");

        Marker marker8 = new Marker(markerOptions8);

        map.addMarker(marker8);

        //Adding one more marker New york
        MarkerOptions markerOptions9 = new MarkerOptions();

        markerOptions9.position(new LatLong(40.7, -74.2))
                .visible(Boolean.TRUE)
                .title("New York....");

        Marker marker9 = new Marker(markerOptions9);

        map.addMarker(marker9);

        //Adding one more marker New york
        MarkerOptions markerOptions10 = new MarkerOptions();

        markerOptions10.position(new LatLong(40.0, -74.2))
                .visible(Boolean.TRUE)
                .title("New York......");

        Marker marker10 = new Marker(markerOptions10);

        map.addMarker(marker10);

        //Adding one more marker Boston
        MarkerOptions markerOptions11 = new MarkerOptions();

        markerOptions11.position(new LatLong(42.0, -71.0))
                .visible(Boolean.TRUE)
                .title("Boston");

        Marker marker11 = new Marker(markerOptions11);

        map.addMarker(marker11);

        //Adding one more marker Boston
        MarkerOptions markerOptions12 = new MarkerOptions();

        markerOptions12.position(new LatLong(42.1, -71.1))
                .visible(Boolean.TRUE)
                .title("Boston");

        Marker marker12 = new Marker(markerOptions12);

        map.addMarker(marker12);

        //Adding one more marker Boston
        MarkerOptions markerOptions13 = new MarkerOptions();

        markerOptions13.position(new LatLong(42.5, -71.4))
                .visible(Boolean.TRUE)
                .title("Boston");

        Marker marker13 = new Marker(markerOptions13);

        map.addMarker(marker13);

        //Adding one more marker Boston
        MarkerOptions markerOptions14 = new MarkerOptions();

        markerOptions14.position(new LatLong(42.5, -72.4))
                .visible(Boolean.TRUE)
                .title("Boston");

        Marker marker14 = new Marker(markerOptions14);

        map.addMarker(marker14);
    }

    
    public static void StartApp() {
        String a[] = new String[0];
        launch(a);
    }
}
