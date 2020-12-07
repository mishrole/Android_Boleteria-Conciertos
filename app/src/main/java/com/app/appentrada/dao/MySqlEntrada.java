package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.Entrada;

import java.util.ArrayList;

public class MySqlEntrada {

    private SqlOpenHelper admin;

    public MySqlEntrada(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public ArrayList<Entrada> listarEntrada(){
        ArrayList<Entrada> lista=new ArrayList<Entrada>();
        String sql="select * from TB_ENTRADA";
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        Entrada bean=null;
        while(cursor.moveToNext()){
            bean=new Entrada();
            bean.setCodEntrada(cursor.getInt(0));
            bean.setCodConcierto(cursor.getInt(1));
            bean.setCodZona(cursor.getInt(2));
            bean.setEstado(cursor.getInt(3));
            bean.setPrecio(cursor.getDouble(4));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarEntrada(Entrada bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_concierto",bean.getCodConcierto());
        registro.put("id_zona",bean.getCodZona());
        registro.put("estado",bean.getEstado());
        registro.put("precio",bean.getPrecio());
        salida=(int)base.insert("TB_ENTRADA","id_entrada",registro);
        return salida;
    }

    public int actualizarEntrada(Entrada bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_entrada",bean.getCodEntrada());
        registro.put("id_concierto",bean.getCodConcierto());
        registro.put("id_zona",bean.getCodZona());
        registro.put("estado",bean.getEstado());
        registro.put("precio",bean.getPrecio());
        salida=base.update("TB_ENTRADA",registro,"id_entrada="+bean.getCodEntrada(),null);
        return salida;
    }

    public int eliminarEntrada(int cod){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_ENTRADA","id_entrada="+cod,null);
        return salida;
    }
}
