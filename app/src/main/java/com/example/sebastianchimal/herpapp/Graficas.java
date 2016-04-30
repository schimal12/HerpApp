package com.example.sebastianchimal.herpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Graficas extends AppCompatActivity {

    private BarChart barchart;
    private BarDataSet barDataSet;

    //Colecciones de datos y de etiquetas
    private ArrayList<BarEntry> entries;
    private ArrayList<String> labels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.grafica);
        barchart = new BarChart(this);
        frameLayout.addView(barchart);
        loadEmptyDataSet();
    }

    private void loadEmptyDataSet() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));
        BarDataSet dataset = new BarDataSet(entries, "Poblacion en un año");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
        BarData barData = new BarData(labels,dataset);
        barchart.setData(barData);
        barchart.getAxisLeft().setAxisMaxValue(10);
        barchart.getAxisLeft().setAxisMinValue(0f);
    }
}
