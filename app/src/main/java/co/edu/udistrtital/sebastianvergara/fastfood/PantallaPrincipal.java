package co.edu.udistrtital.sebastianvergara.fastfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PantallaPrincipal extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap miMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        SupportMapFragment mapFragment = (SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.MapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        miMapa = googleMap;

        LatLng Bogota = new LatLng(4.6097100, -74.0817500);
        miMapa.addMarker(new MarkerOptions().position(Bogota).title("Bogota"));
        miMapa.moveCamera(CameraUpdateFactory.newLatLng(Bogota));


    }


}