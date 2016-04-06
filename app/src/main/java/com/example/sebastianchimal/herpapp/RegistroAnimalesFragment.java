package com.example.sebastianchimal.herpapp;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroAnimalesFragment extends Fragment {
    EditText nombreAnimal, nombreCientifico, fechaComida, TipoAlimento, intervaloAlimento;
    private SimpleDateFormat simpleDateFormat;
    private DatePickerDialog datePickerDialog;
    Button registrar;

    public RegistroAnimalesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadFindViewById();
    }


    private void loadFindViewById() {
        nombreAnimal = (EditText) getView().findViewById(R.id.nombreAnimal);
        nombreCientifico = (EditText) getView().findViewById(R.id.especieAnimal);
        TipoAlimento = (EditText) getView().findViewById(R.id.tipoComida);
        intervaloAlimento = (EditText) getView().findViewById(R.id.intervaloComida);
        fechaComida = (EditText) getView().findViewById(R.id.fechaComida);


        fechaComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                DialogFragment calendario = new DatePickerFragment();
                calendario.show(getFragmentManager(), "datePicker");
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View v = inflater.inflate(R.layout.fragment_registro_animales, container, false);

        registrar = (Button) v.findViewById(R.id.botonRegistro);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Conexion SQL
                AnimalesSQLiteHelper animalesSQLiteHelper = new AnimalesSQLiteHelper(getActivity(),"DBAnimales",null,1);
                SQLiteDatabase db = animalesSQLiteHelper.getWritableDatabase();

                if(db != null){
                    db.execSQL("INSERT INTO Animales (nombreAnimal,nombreCientifico,tipoAlimento,intervalo,fechaAlimento)"+
                            "VALUES ("+"'"+nombreAnimal.getText()+"'"+",'"+nombreCientifico.getText()+"'"+","+"'"+TipoAlimento.getText()+"'"+","+1+",'"+fechaComida.getText()+"')");
                    db.close();
                }
            }
        });
        return v;
    }
}
