package com.example.sebastianchimal.herpapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class EnciclopediaAnimales extends ListActivity {

    private  ArrayList<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EnciclopediaAdapter enciclopediaAdapter = new EnciclopediaAdapter(this, generarCategorias());
        setListAdapter(enciclopediaAdapter);
        setContentView(R.layout.activity_enciclopedia_animales);
    }

    private ArrayList<String> generarCategorias() {
       items = new ArrayList<String>();

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
            Iterator iterador = jsonObject1.keys();
            while (iterador.hasNext()) {
                String key = (String) iterador.next();
                items.add(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    private int VALOR_SUBACTIVIDAD = 5007;

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent enciclopediaInformacionAnimales = new Intent(this,EnciclopediaInformacionAnimales.class);
        enciclopediaInformacionAnimales.putExtra("NombreCategoria", items.get(position).toString());
        startActivityForResult(enciclopediaInformacionAnimales, VALOR_SUBACTIVIDAD);
    }
}