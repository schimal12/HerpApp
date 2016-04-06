package com.example.sebastianchimal.herpapp;


import android.app.DialogFragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class registroComidaFragment extends Fragment {
    private EditText nombreComida,fechaCambioComida, cantidadComida;
    private Button registrar;
    public registroComidaFragment() {
        // Required empty public constructor
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadFindViewById();
    }

    private void loadFindViewById() {
        nombreComida = (EditText)getView().findViewById(R.id.nombreComida);
        fechaCambioComida = (EditText)getView().findViewById(R.id.cambioComida);
        cantidadComida = (EditText)getView().findViewById(R.id.cantidadComida);


        fechaCambioComida.setOnClickListener(new View.OnClickListener() {
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
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_registro_comida, container, false);
        registrar = (Button)v.findViewById(R.id.registroComidaID);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComidasSQLiteHelper animalesSQLiteHelper = new ComidasSQLiteHelper(getActivity(),"DBComida",null,1);
                SQLiteDatabase db = animalesSQLiteHelper.getWritableDatabase();

                if(db != null){
                    db.execSQL("INSERT INTO comida (nombreComida,cambioComida,cantidadComida)"+
                            "VALUES ("+"'"+nombreComida.getText()+"'"+",'"+fechaCambioComida.getText()+"'"+","+1021+")");
                    db.close();
                }
            }
        });
        return v;
    }

}
