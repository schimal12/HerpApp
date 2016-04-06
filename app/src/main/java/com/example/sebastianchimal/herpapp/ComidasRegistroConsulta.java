package com.example.sebastianchimal.herpapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ComidasRegistroConsulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas_registro_consulta);
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.contendor, new ImagenAnimalesConsultaFragment()).commit();
    }
    public  void registroComida(View v){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                replace(R.id.contendor, new registroComidaFragment()).
                commit();
    }
    public void consultaComida(View v){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                replace(R.id.contendor, new consultaComidaFragment()).
                commit();
    }
}
