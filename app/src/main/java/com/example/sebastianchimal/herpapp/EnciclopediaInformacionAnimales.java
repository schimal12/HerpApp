package com.example.sebastianchimal.herpapp;

import android.app.ListActivity;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class EnciclopediaInformacionAnimales extends ListActivity {

    public String categoria;

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
                String nombreCientifico = jsonObejctDos.getString("NombreCientifico");
                String nombreComun = jsonObejctDos.getString("NombreComun");
                String habitat = jsonObejctDos.getString("Habitat");
                String alimentacion = jsonObejctDos.getString("Alimentacion");
                String general = nombreCientifico+"\n"+nombreComun+"\n"+habitat+"\n"+alimentacion;
                items.add(general);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }


}
