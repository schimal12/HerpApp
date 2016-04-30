package com.example.sebastianchimal.herpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Comida(){

    }
    private int VALOR_SUBACTIVIDAD = 5007;
    public void Animales(View v) {
        Intent animales = new Intent(this, Animales.class);
        startActivity(animales);
    }

    public void Comida(View v){
        Intent comida = new Intent(this,Comidas.class);
        startActivityForResult(comida,VALOR_SUBACTIVIDAD);
    }
}
