package com.example.sebastianchimal.herpapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnimalesRegistroConsulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_registro_consulta);
        getFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.contendor, new ImagenAnimalesConsultaFragment()).commit();
        }
    public void crud(View v){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                replace(R.id.contendor, new RegistroAnimalesFragment()).
                commit();
    }
    public void consulta(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).
                replace(R.id.contendor, new consultaAnimalesFragment()).
                commit();
    }


}
