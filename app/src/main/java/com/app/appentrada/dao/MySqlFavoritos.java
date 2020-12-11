package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.Favoritos;

import java.util.ArrayList;

public class MySqlFavoritos {

    private SqlOpenHelper admin;

    public MySqlFavoritos(Context contexto){ admin=new SqlOpenHelper(contexto); }

    public ArrayList<Favoritos> listarFavoritos(int codC, int codU){
        ArrayList<Favoritos> lista=new ArrayList<>();
        String sql="select * from TB_FAVORITOS where id_favoritos="+codC+" and id_usuario="+codU;
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        Favoritos bean=null;
        while(cursor.moveToNext()){
            bean=new Favoritos();
            bean.setIdFavoritos(cursor.getInt(0));
            bean.setIdUsuario(cursor.getInt(1));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarFavoritos(Favoritos bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_favoritos",bean.getIdFavoritos());
        registro.put("id_usuario",bean.getIdUsuario());
        salida=(int)base.insert("TB_FAVORITOS",null,registro);
        return salida;
    }

    public int actualizarFavoritos(Favoritos bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_favoritos",bean.getIdFavoritos());
        registro.put("id_usuario",bean.getIdUsuario());
        salida=base.update("TB_FAVORITOS",registro,"id_favoritos="+bean.getIdFavoritos(),null);
        return salida;
    }

    public int eliminarFavoritos(int codf, int codu){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_FAVORITOS","id_favoritos="+codf+" and "+"id_usuario="+codu ,null);
        return salida;
    }
}
