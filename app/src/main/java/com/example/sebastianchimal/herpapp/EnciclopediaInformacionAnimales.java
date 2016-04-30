package com.example.sebastianchimal.herpapp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class EnciclopediaInformacionAnimales extends ListActivity {

    public String categoria;
    public String nombreComun;
    public String  nombreCientifico;
    public String habitat;
    public String  alimentacion;
    public double Lat;
    public double Long;
    public String youtube;
    public ArrayList<String> nombreCientificoL = new ArrayList<>();
    public ArrayList<String> nombreComunL = new ArrayList<>();
    public ArrayList<String> alimentoL = new ArrayList<>();
    public ArrayList<String> habitatL = new ArrayList<>();
    public ArrayList<Double> LatL  = new ArrayList<>();
    public ArrayList<Double> LongL = new ArrayList<>();
    public ArrayList<String> youtubeL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        categoria = extras.getString("NombreCategoria");
        System.out.println("Categoria: "+categoria);
        EnciclopediaAnimalesInformacionAdapter enciclopediaAnimalesInformacionAdapter = new EnciclopediaAnimalesInformacionAdapter(this, generarCategorias());
        setListAdapter(enciclopediaAnimalesInformacionAdapter);
        setContentView(R.layout.activity_enciclopedia_informacion_animales);
        
    }

    private ArrayList<String> generarCategorias() {
        ArrayList<String> items = new ArrayList<String>();


        AssetManager assetManager = getApplicationContext().getAssets();
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open("enciclopediaanimales.json"));
            bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                stringBuffer.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            bufferedReader = null;
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONObject jsonObject1 = jsonObject.getJSONObject("animales");
            JSONArray animales = jsonObject1.getJSONArray(categoria);
            for(int i = 0;i<animales.length();i++){
                JSONObject jsonObejctDos = animales.getJSONObject(i);
                nombreCientifico = jsonObejctDos.getString("NombreCientifico");
                nombreComun = jsonObejctDos.getString("NombreComun");
                habitat = jsonObejctDos.getString("Habitat");
                alimentacion = jsonObejctDos.getString("Alimentacion");
                Lat = jsonObejctDos.getDouble("Lat");
                Long = jsonObejctDos.getDouble("Long");
                youtube = jsonObejctDos.getString("youtube");
                String general = nombreCientifico;
                nombreCientificoL.add(nombreCientifico);
                nombreComunL.add(nombreComun);
                alimentoL.add(alimentacion);
                habitatL.add(habitat);
                LatL.add(Lat);
                LongL.add(Long);
                youtubeL.add(youtube);
                items.add(general);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent InformacionGeneralEspecie = new Intent(this,InformacionGeneralEspecie.class);
        InformacionGeneralEspecie.putExtra("NombreComun", nombreComunL.get(position).toString());
        InformacionGeneralEspecie.putExtra("NombreCientifico",nombreCientificoL.get(position).toString());
        InformacionGeneralEspecie.putExtra("habitat",habitatL.get(position).toString());
        InformacionGeneralEspecie.putExtra("alimentacion",alimentoL.get(position).toString());
        InformacionGeneralEspecie.putExtra("Lat", LatL.get(position));
        InformacionGeneralEspecie.putExtra("Long",LongL.get(position));
        InformacionGeneralEspecie.putExtra("youtube",youtubeL.get(position).toString());
        startActivity(InformacionGeneralEspecie);
    }

}
