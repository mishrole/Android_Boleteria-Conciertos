package com.app.appentrada.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.appentrada.utilidades.Utilidades;

public class SqlOpenHelper extends SQLiteOpenHelper {


    public SqlOpenHelper(Context context){
        super(context,"ventaEntrada.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.crearTablaTipoUsuario);
        db.execSQL(Utilidades.crearTablaUsuario);
        db.execSQL(Utilidades.crearTablaZona);
        db.execSQL(Utilidades.crearTablaLocal);
        db.execSQL(Utilidades.crearTablaConcierto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.tablaTipoUsuario);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.tablaUsuario);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.tablaZona);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.tablaLocal);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.tablaConcierto);
        onCreate(db);
    }
}
