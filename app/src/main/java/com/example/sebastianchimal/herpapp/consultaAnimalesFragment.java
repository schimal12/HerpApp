package com.example.sebastianchimal.herpapp;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class consultaAnimalesFragment extends Fragment {


    private String nombreAnimal, nombreCientifico,tipoAlimento,intervalo,fechaAlimento;
    public TextView consultaNombre, consultaCientifico,consultaAlimento,consultaComida;
    public consultaAnimalesFragment() {
        // Required empty public constructor
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        consultaNombre = (TextView)getView().findViewById(R.id.consultaAnimales);
        consultaCientifico = (TextView)getView().findViewById(R.id.consultaCientifico);
        consultaAlimento = (TextView)getView().findViewById(R.id.consultaAlimento);
        consultaComida = (TextView)getView().findViewById(R.id.consultaComida);

        consultaNombre.setText(nombreAnimal);
        consultaCientifico.setText(nombreCientifico);
        consultaAlimento.setText(tipoAlimento);
        consultaComida.setText(fechaAlimento);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AnimalesSQLiteHelper animalesSQLiteHelper = new AnimalesSQLiteHelper(getActivity(),"DBAnimales",null,1);
        SQLiteDatabase db = animalesSQLiteHelper.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT nombreAnimal,nombreCientifico,tipoAlimento,intervalo,fechaAlimento FROM Animales", null);
        if(c.moveToFirst()){
            nombreAnimal = c.getString(0);
            nombreCientifico = c.getString(1);
            tipoAlimento = c.getString(2);
            intervalo = c.getString(3);
            fechaAlimento = c.getString(4);
        }
        return inflater.inflate(R.layout.fragment_consulta_animales, container, false);
    }

}
