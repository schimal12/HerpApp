package com.example.sebastianchimal.herpapp;

import android.content.Context;

import android.content.SharedPreferences;
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
public class ComidasAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final ArrayList<String> itemsArrayList;


    public ComidasAdapter(Context context, ArrayList<String> listaAnimales) {
        super(context, R.layout.renglonenciclopediacomidas, listaAnimales);
        this.context = context;
        this.itemsArrayList = listaAnimales;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SharedPreferences compartidas = getContext().getSharedPreferences("nombreComidaID", Context.MODE_PRIVATE);

        //Crear inflador
        LayoutInflater inflate = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //El renglo del view
        View rowView = inflate.inflate(R.layout.renglonenciclopediacomidas,parent,false);
        //Obtener la Iamge View y el TextView
        TextView informacionComida = (TextView)rowView.findViewById(R.id.informacionComida);
        ImageView imagenComida = (ImageView)rowView.findViewById(R.id.imagenComida);

        String textoComida = compartidas.getString("IDComida","");
        System.out.println("textoComida: "+textoComida);
        String id = itemsArrayList.get(position).toString();
        informacionComida.setText(itemsArrayList.get(position).toString());

        if(id.equals("Acheta domesticus")){
            imagenComida.setImageResource(R.drawable.grillogeneral);
        }else{
            if(id.equals("Blaptica dubia")){
                imagenComida.setImageResource(R.drawable.grillogeneral);
            }else{
                if(id.equals("Blaptica haywardi")){
                    imagenComida.setImageResource(R.drawable.grillogeneral);
                }else{
                    if(id.equals("Tenerbrio  molitor")){
                        imagenComida.setImageResource(R.drawable.grillogeneral);
                    }else {
                        if(id.equals("Bombyx mori")){
                            imagenComida.setImageResource(R.drawable.grillogeneral);
                        }else{
                            if(id.equals("Brachylpema  vagans")){
                                imagenComida.setImageResource(R.drawable.grillogeneral);
                            }
                        }
                    }
                }
            }
        }
        return  rowView;
    }
}