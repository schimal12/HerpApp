package com.example.sebastianchimal.herpapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
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

public class ComidasEnciclopedia extends ListActivity {

    private  ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComidasAdapter comidasAdapter = new ComidasAdapter(this, generarCategorias());
        setListAdapter(comidasAdapter);
        setContentView(R.layout.activity_comidas_enciclopedia);
    }

    private ArrayList<String> generarCategorias() {
        SharedPreferences compartidas = getApplicationContext().getSharedPreferences("nombreComidaID", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = compartidas.edit();

        items = new ArrayList<String>();

        AssetManager assetManager = getApplicationContext().getAssets();
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open("enciclopediaComida.json"));
            bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                stringBuffer.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            bufferedReader = null;
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("Comida");
            for(int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObejctDos = jsonArray.getJSONObject(i);
                String nombreID = jsonObejctDos.getString("NombreCientifico");
                String nombreCientifico = nombreID;
                String nombreComun = jsonObejctDos.getString("NombreComun");
                String caracteristicas = jsonObejctDos.getString("Caracteristicas");
                editor.putString("IDComida",nombreID);
                String general = nombreCientifico+"\n"+nombreComun+"\n"+caracteristicas;
                items.add(nombreID);
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
