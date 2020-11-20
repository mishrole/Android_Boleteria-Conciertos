package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.Local;

import java.util.ArrayList;

public class MySqlLocal {

    private SqlOpenHelper admin;

    public MySqlLocal(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public ArrayList<Local> listarLocal(){
        ArrayList<Local> lista=new ArrayList<>();
        String sql="select * from TB_LOCAL";
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        Local bean=null;
        while(cursor.moveToNext()){
            bean=new Local();
            bean.setCodLocal(cursor.getInt(0));
            bean.setNombre(cursor.getString(1));
            bean.setDireccion(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarLocal(Local bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("nom_local",bean.getNombre());
        registro.put("direccion",bean.getDireccion());
        salida=(int)base.insert("TB_LOCAL","id_local",registro);
        return salida;
    }

    public int actualizarLocal(Local bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_zona",bean.getCodLocal());
        registro.put("nom_zona",bean.getNombre());
        registro.put("precio",bean.getDireccion());
        salida=base.update("TB_LOCAL",registro,"id_local="+bean.getCodLocal(),null);
        return salida;
    }

    public int eliminarLocal(int cod){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_LOCAL","id_local="+cod,null);
        return salida;
    }
}
