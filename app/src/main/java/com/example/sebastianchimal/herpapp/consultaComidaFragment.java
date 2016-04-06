package com.example.sebastianchimal.herpapp;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class consultaComidaFragment extends Fragment {

    public TextView nombreAlimento, cantidadAlimento;
    public String nombreAl, cantidadAl;
    public consultaComidaFragment() {
        // Required empty public constructor
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nombreAlimento = (TextView) getView().findViewById(R.id.textView10);
        cantidadAlimento = (TextView) getView().findViewById(R.id.textView12);

        nombreAlimento.setText(nombreAl);
        cantidadAlimento.setText(cantidadAl);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AnimalesSQLiteHelper animalesSQLiteHelper = new AnimalesSQLiteHelper(getActivity(),"DBAnimales",null,1);
        SQLiteDatabase db = animalesSQLiteHelper.getWritableDatabase();
        Cursor c = db.rawQuery(" SELECT nombreComida,cantidadComida FROM Comida", null);
        if(c.moveToFirst()){
            nombreAl = c.getString(0);
            cantidadAl = c.getString(1);

        }



        return inflater.inflate(R.layout.fragment_consulta_comida, container, false);
    }

}
