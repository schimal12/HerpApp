package com.example.sebastianchimal.herpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Animales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);
    }
    private int VALOR_SUBACTIVIDAD = 5007;
    public void enciclopedia(View v){
        Intent enciclopedia = new Intent(this,EnciclopediaAnimales.class);
        startActivityForResult(enciclopedia,VALOR_SUBACTIVIDAD);
    }

    public void consulta(View v){
        Intent consulta = new Intent(this,AnimalesRegistroConsulta.class);
        startActivityForResult(consulta,VALOR_SUBACTIVIDAD);
    }
}
