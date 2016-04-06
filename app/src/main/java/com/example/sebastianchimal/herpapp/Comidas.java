package com.example.sebastianchimal.herpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Comidas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas);
    }

    private int VALOR_SUBACTIVIDAD = 5007;
    public void enciclopediaComidas(View v){
        Intent enciclopedia = new Intent(this,ComidasEnciclopedia.class);
        startActivityForResult(enciclopedia, VALOR_SUBACTIVIDAD);
    }
    public void alimentoVivo(View v){
        Intent alimentoVivo = new Intent(this,ComidasRegistroConsulta.class);
        startActivityForResult(alimentoVivo,VALOR_SUBACTIVIDAD);
    }
}
