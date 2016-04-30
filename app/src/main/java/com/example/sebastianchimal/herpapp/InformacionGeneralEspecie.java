package com.example.sebastianchimal.herpapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InformacionGeneralEspecie extends AppCompatActivity  implements OnMapReadyCallback{

    public String nombreComun;
    public String  nombreCientifico;
    public String habitat;
    public String  alimentacion;


    public TextView nombreComunT,nombreCientificoT,habitatT, alimentacionT;
    private GoogleMap googleMap;

    private double Lat;
    private double Long;
    private String youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general_especie);
        Bundle extras = getIntent().getExtras();
        nombreComun = extras.getString("NombreComun");
        nombreCientifico = extras.getString("NombreCientifico");
        habitat = extras.getString("habitat");
        alimentacion = extras.getString("alimentacion");
        Lat = extras.getDouble("Lat");
        Long = extras.getDouble("Long");
        youtube = extras.getString("youtube");

        nombreComunT = (TextView)findViewById(R.id.nombreComun);
        nombreCientificoT = (TextView)findViewById(R.id.nombreCientifico);
        habitatT = (TextView)findViewById(R.id.Habitat);
        alimentacionT = (TextView)findViewById(R.id.Alimentacion);

        System.out.println("Nombre Comun: "+nombreComun);
        System.out.println("Nombre Cientifico: "+nombreCientifico);
        System.out.println("Habitat: " + habitat);
        System.out.println("Alimentacion: " + alimentacion);
        System.out.println("Lat: " + Lat);
        System.out.println("Long " + Long);

        nombreComunT.setText(nombreComun);
        nombreCientificoT.setText(nombreCientifico);
        habitatT.setText(habitat);
        alimentacionT.setText(alimentacion);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.MapaAnimales);
        mapFragment.getMapAsync(this);
    }


    private int VALOR_SUBACTIVIDAD = 5007;
    public void onYoutube(View view){
        Intent Youtube = new Intent(this,YoutubeGaleria.class);
        Youtube.putExtra("VIDEO_ID",youtube);
        startActivityForResult(Youtube, VALOR_SUBACTIVIDAD);
    }
    public void onGraficas(View view){
        Intent Graficas = new Intent(this,Graficas.class);
        startActivity(Graficas);
    }

    public void onTemperatura(View view){
        Intent Temperatur = new Intent(this,SensorTemperatura.class);
        startActivity(Temperatur);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LatLng latLng = new LatLng(Lat, Long);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        this.googleMap.addMarker(new MarkerOptions().position(latLng).title("Ubicacion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
    }
}
