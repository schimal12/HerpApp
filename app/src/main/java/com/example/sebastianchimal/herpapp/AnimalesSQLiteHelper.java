package com.example.sebastianchimal.herpapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sebastianchimal on 21/02/16.
 */
public class AnimalesSQLiteHelper extends SQLiteOpenHelper {

    public static final String NOMBRE_ANIMAL = "nombre_animal";
    public static final String NOMBRE_CIENTIFICO = "nombre_cientifico";
    public static final String TIPO_ALIMENTO = "tipo_alimento";
    public static final String INTERVALO_ALIMENTO = "intervalo_alimento";
    public static final String FECHA_ALIMENTO = "fecha_alimento";
    public static final String[] columnas = {NOMBRE_ANIMAL, NOMBRE_CIENTIFICO,TIPO_ALIMENTO,INTERVALO_ALIMENTO,FECHA_ALIMENTO};

    private static final int VERSION = 1;

    private static final String creacion = "CREATE TABLE Animales (nombreAnimal TEXT, nombreCientifico TEXT,tipoAlimento TEXT,intervalo INTEGER, fechaAlimento  TEXT)";

    public AnimalesSQLiteHelper(Context context,String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,nombre,factory,version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(creacion);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table IF Exists " + "animales");
        db.execSQL(creacion);
    }
}
