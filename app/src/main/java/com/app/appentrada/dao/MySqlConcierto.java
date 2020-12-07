package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.Concierto;

import java.util.ArrayList;

public class MySqlConcierto {

    private SqlOpenHelper admin;

    public MySqlConcierto(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public ArrayList<Concierto> listarConcierto(){
        ArrayList<Concierto> lista=new ArrayList<Concierto>();
        String sql="select * from TB_CONCIERTO";
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        Concierto bean=null;
        while(cursor.moveToNext()){
            bean=new Concierto();
            bean.setCodConcierto(cursor.getInt(0));
            bean.setNombre(cursor.getString(1));
            bean.setArtista(cursor.getString(2));
            bean.setFecha(cursor.getString(3));
            bean.setDescrip(cursor.getString(4));
            bean.setCodLocal(cursor.getInt(5));
            bean.setFoto(cursor.getInt(6));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarConcierto(Concierto bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("nom_con",bean.getNombre());
        registro.put("artista",bean.getArtista());
        registro.put("fec_con",bean.getFecha());
        registro.put("desc_con",bean.getDescrip());
        registro.put("id_local",bean.getCodLocal());
        registro.put("foto",bean.getFoto());
        salida=(int)base.insert("TB_CONCIERTO","id_concierto",registro);
        return salida;
    }

    public int actualizarConcierto(Concierto bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_concierto",bean.getCodConcierto());
        registro.put("nom_con",bean.getNombre());
        registro.put("artista",bean.getArtista());
        registro.put("fec_con",bean.getFecha());
        registro.put("desc_con",bean.getDescrip());
        registro.put("id_local",bean.getCodLocal());
        registro.put("foto",bean.getFoto());
        salida=base.update("TB_CONCIERTO",registro,"id_concierto="+bean.getCodConcierto(),null);
        return salida;
    }

    public int eliminarConcierto(int cod){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_CONCIERTO","id_concierto="+cod,null);
        return salida;
    }


}