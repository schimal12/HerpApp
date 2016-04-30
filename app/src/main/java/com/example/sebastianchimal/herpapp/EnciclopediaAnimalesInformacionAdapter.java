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
        TextView general = (TextView) rowView.findViewById(R.id.nombreAnimalCientifico);
        ImageView imagen = (ImageView)rowView.findViewById(R.id.imagenAnimalCientifico);

        imagen.setImageResource(R.drawable.mauremysrevesii);
        general.setText(itemsArrayList.get(position).toString());
        if(general.getText().toString().equals("Mauremys reevesii")){
            imagen.setImageResource(R.drawable.mauremysrevesii);
        }else{
            if(general.getText().toString().equals("Sternotherus  odoratus")){
                imagen.setImageResource(R.drawable.sternotherusodoratus);
            }else{
                if(general.getText().toString().equals("Malaclemys terrapin")){
                    imagen.setImageResource(R.drawable.malaclemysterrapin);
                }else{
                    if(general.getText().toString().equals("Emydura subglobosa")){
                        imagen.setImageResource(R.drawable.emydurasubglobosa);
                    }else{
                        if(general.getText().toString().equals("Pseudemys concinna hyeroglyphica")){
                            imagen.setImageResource(R.drawable.pseudemysconcinna);
                        }else{
                            if(general.getText().toString().equals("Trachemys scripta elegans")){
                                imagen.setImageResource(R.drawable.trachemysscriptaelegans);
                            }else{
                                if(general.getText().toString().equals("Ranitomeya variabilis southern")){
                                    imagen.setImageResource(R.drawable.ranitomeyavariabilis);
                                }else{
                                    if(general.getText().toString().equals("Dendrobate auratus Panama")){
                                        imagen.setImageResource(R.drawable.dendrobatesauratus);
                                    }else{
                                        if(general.getText().toString().equals("Agalachnys callidras")){
                                            imagen.setImageResource(R.drawable.ranaojosrojos);
                                        }else{
                                            if(general.getText().toString().equals("Hyalinobatrachium fleischmanni")){
                                                imagen.setImageResource(R.drawable.ranacristal);
                                            }else{
                                                if(general.getText().toString().equals("Anotheca spinosa")){
                                                    imagen.setImageResource(R.drawable.anothecaspinosa);
                                                }else{
                                                    if(general.getText().toString().equals("Ambystoma tigrinum")){
                                                        imagen.setImageResource(R.drawable.salamandratigre);
                                                    }else{
                                                        if(general.getText().toString().equals("Abronia graminea")){
                                                            imagen.setImageResource(R.drawable.abroniagraminea);
                                                        }else{
                                                            if(general.getText().toString().equals("Abronia deppeii")){
                                                                imagen.setImageResource(R.drawable.abroniadeppei);
                                                            }else{
                                                                if(general.getText().toString().equals("Abronia taeniata")){
                                                                    imagen.setImageResource(R.drawable.abronaitaeniata);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        return rowView;
    }

    public ArrayList<String> getItemsArrayList() {
        return itemsArrayList;
    }
}
