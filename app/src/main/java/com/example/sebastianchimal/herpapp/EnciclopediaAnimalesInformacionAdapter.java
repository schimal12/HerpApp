package com.example.sebastianchimal.herpapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sebastianchimal on 21/02/16.
 */
public class EnciclopediaAnimalesInformacionAdapter  extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> itemsArrayList;

    public EnciclopediaAnimalesInformacionAdapter(Context context,ArrayList<String> listaAnimales){
        super(context,R.layout.rengloninformacionenciclopediaanimales,listaAnimales);
        this.context = context;
        this.itemsArrayList = listaAnimales;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        //Crear inflador
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //El renglo del view
        View rowView = inflate.inflate(R.layout.rengloninformacionenciclopediaanimales, parent, false);
        //Obtener la Iamge View y el TextView
        TextView general = (TextView) rowView.findViewById(R.id.nombreCientifico);

        general.setText(itemsArrayList.get(position).toString());


        return rowView;
    }

    public ArrayList<String> getItemsArrayList() {
        return itemsArrayList;
    }
}
