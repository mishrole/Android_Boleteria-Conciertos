package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.TipoUsuario;

import java.util.ArrayList;

public class MySqlTipoUsuario {

    private SqlOpenHelper admin;

    public MySqlTipoUsuario(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public ArrayList<TipoUsuario> listarTipoUsuario(){
        ArrayList<TipoUsuario> lista=new ArrayList<>();
        String sql="select * from TB_TIPO_USUARIO";
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        TipoUsuario bean=null;
        while(cursor.moveToNext()){
            bean=new TipoUsuario();
            bean.setCodTipo(cursor.getInt(0));
            bean.setUsuario(cursor.getString(1));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarTipoUsuario(TipoUsuario bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("usuario",bean.getUsuario());
        salida=(int)base.insert("TB_TIPO_USUARIO","id_tipo",registro);
        return salida;
    }

    public int actualizarTipoUsuario(TipoUsuario bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_tipo",bean.getCodTipo());
        registro.put("usuario",bean.getUsuario());
        salida=base.update("TB_TIPO_USUARIO",registro,"id_concierto="+bean.getCodTipo(),null);
        return salida;
    }

    public int eliminarTipoUsuario(int cod){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_TIPO_USUARIO","id_tipo="+cod,null);
        return salida;
    }
}
