package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.Zona;

import java.util.ArrayList;

public class MySqlZona {

    private SqlOpenHelper admin;

    public MySqlZona(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public ArrayList<Zona> listarZona(){
        ArrayList<Zona> lista=new ArrayList<>();
        String sql="select * from TB_ZONA";
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        Zona bean=null;
        while(cursor.moveToNext()){
            bean=new Zona();
            bean.setCodZona(cursor.getInt(0));
            bean.setNombre(cursor.getString(1));
            bean.setPrecio(cursor.getDouble(2));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarZona(Zona bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("nom_zona",bean.getNombre());
        registro.put("precio",bean.getPrecio());
        salida=(int)base.insert("TB_ZONA","id_zona",registro);
        return salida;
    }

    public int actualizarZona(Zona bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_zona",bean.getCodZona());
        registro.put("nom_zona",bean.getNombre());
        registro.put("precio",bean.getPrecio());
        salida=base.update("TB_ZONA",registro,"id_zona="+bean.getCodZona(),null);
        return salida;
    }

    public int eliminarZona(int cod){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_ZONA","id_zona="+cod,null);
        return salida;
    }
}
