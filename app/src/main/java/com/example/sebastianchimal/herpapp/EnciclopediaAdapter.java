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
 * Created by sebastianchimal on 20/02/16.
 */
public class EnciclopediaAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> itemsArrayList;

    public EnciclopediaAdapter(Context context,ArrayList<String> listaAnimales){
        super(context,R.layout.renglonenciclopedia,listaAnimales);
        this.context = context;
        this.itemsArrayList = listaAnimales;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        //Crear inflador
        LayoutInflater inflate = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //El renglo del view
        View rowView = inflate.inflate(R.layout.renglonenciclopedia,parent,false);
        //Obtener la Iamge View y el TextView
        TextView textView = (TextView)rowView.findViewById(R.id.informacionAnimales);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.imagenCategoria);

        textView.setText(itemsArrayList.get(position).toString());
        if(textView.getText().toString().equals("Tortugas")){
            imageView.setImageResource(R.drawable.tortugasacuaticas);

        }else {
            if(textView.getText().toString().equals("Abronias")) {
                imageView.setImageResource(R.drawable.abronia);
            }else{
                if(textView.getText().toString().equals("Ranas")) {
                    imageView.setImageResource(R.drawable.rana);
                }
            }
        }
        return  rowView;
    }

    public ArrayList<String> getItemsArrayList() {
        return itemsArrayList;
    }
}
