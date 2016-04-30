package com.example.sebastianchimal.herpapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sebastianchimal on 21/02/16.
 */
public class AnimalesSQLiteHelper extends SQLiteOpenHelper {


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
        db.execSQL("DROP table IF Exists " + "Animales");
        db.execSQL(creacion);
    }
}
