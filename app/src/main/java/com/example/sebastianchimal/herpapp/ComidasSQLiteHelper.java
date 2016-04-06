package com.example.sebastianchimal.herpapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sebastianchimal on 21/02/16.
 */

public class ComidasSQLiteHelper extends SQLiteOpenHelper {
    public static final String NOMBRE_TABLA ="comida_data";
    public static final String NOMBRE_COMIDA = "nombre_comida";
    public static final String CAMBIO_COMIDA = "cambio_comida";
    public static final String CANTIDAD_COMIDA = "cantidad_comida";
    public static final String[] columnas = {NOMBRE_COMIDA,CAMBIO_COMIDA,CANTIDAD_COMIDA};
    private static final String  NOMBRE_DB = "comida.db";
    private static final int VERSION = 1;

    private static final String creacion = "CREATE TABLE Comida (nombreComida TEXT, cambioComida TEXT,cantidadComida INTEGER)";


    public ComidasSQLiteHelper(Context context,String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,nombre,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creacion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table IF Exists " + "Comida");
        onCreate(db);
    }
}
