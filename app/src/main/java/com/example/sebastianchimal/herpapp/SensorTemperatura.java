package com.example.sebastianchimal.herpapp;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SensorTemperatura extends AppCompatActivity implements SensorEventListener {

    private TextView textview, textView1;
    private Sensor ambiente;
    private SensorManager manager;
    private ImageView imageView;
    private double temperaturaAmbiental;
    private int luzActual;
    private int luzActualizada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_temperatura);



        imageView = (ImageView)findViewById(R.id.Riesgoview);
        textview = (TextView)findViewById(R.id.riesgoTexto);
        textView1 = (TextView)findViewById(R.id.temperaturaView);
        manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        ambiente = manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        manager.registerListener(this, ambiente, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        System.out.println("SISISISIS");
        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            luzActual = (int)event.values[0];
            luzActualizada = luzActual;
            double tmp = (((luzActual-23.0)/(23.5-22.0))/10);
            textView1.setText("La temperatura actual es de:  "+((int)tmp));
            textview.setText("Buena temperatura");
            if(tmp<10){
                textview.setText("Frío");
                imageView.setBackgroundColor(Color.BLUE);
            }else{
                if(tmp>10 && tmp<30){
                    textview.setText("Normal");
                    imageView.setBackgroundColor(Color.GREEN);
                }else{
                    if(tmp>30){
                        textview.setText("Pelirgoso");
                        imageView.setBackgroundColor(Color.RED);
                    }
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        System.out.println("SISISISIS");
    }


    @Override
    public void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        manager.registerListener(this,ambiente,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
