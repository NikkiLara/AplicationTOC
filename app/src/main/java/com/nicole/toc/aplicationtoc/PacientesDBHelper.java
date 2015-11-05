package com.nicole.toc.aplicationtoc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PacientesDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "pacientes";
    private static final int DB_SCHEME_VERSION = 1;

    public PacientesDBHelper(Context context){
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
