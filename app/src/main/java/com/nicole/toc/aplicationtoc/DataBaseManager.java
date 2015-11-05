package com.nicole.toc.aplicationtoc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
    public static final String TABLE_NAME = "Pacientes";

    public static final String CN_ID = "_id";
    public static final String CN_NAME = "nombre";
    public static final String CN_LNAME = "apellido";
    public static final String CN_AGE = "edad";

    //public static final String CN_POINT = "puntaje";
    //public static final String CN_GRADE = "grado";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement, "
            + CN_NAME + " text not null, "
            + CN_LNAME + "text not null, "
            + CN_AGE + " text not null);";

    private PacientesDBHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        PacientesDBHelper helper = new PacientesDBHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String nombre, String edad){
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME,nombre);
        valores.put(CN_AGE,edad);

        return valores;
    }

    public void insertar(String nombre, String edad) {
        db.insert(TABLE_NAME, null, generarContentValues(nombre, edad));
    }

    public void eliminar(String nombre){
        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{nombre});
    }

    //public void modificar

    public Cursor cargarPacientes(){
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_AGE};
        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }
}
