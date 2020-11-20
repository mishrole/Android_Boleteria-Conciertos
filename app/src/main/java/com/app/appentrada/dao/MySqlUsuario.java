package com.app.appentrada.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.appentrada.data.SqlOpenHelper;
import com.app.appentrada.entidad.Usuario;

import java.util.ArrayList;

public class MySqlUsuario {

    private SqlOpenHelper admin;

    public MySqlUsuario(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public ArrayList<Usuario> listarUsuario(){
        ArrayList<Usuario> lista=new ArrayList<>();
        String sql="select * from TB_USUARIO";
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery(sql,null);
        Usuario bean=null;
        while(cursor.moveToNext()){
            bean=new Usuario();
            bean.setCodUsuario(cursor.getInt(0));
            bean.setNickname(cursor.getString(1));
            bean.setContrasena(cursor.getString(2));
            bean.setNombre(cursor.getString(3));
            bean.setApellidos(cursor.getString(4));
            bean.setCorreo(cursor.getString(5));
            bean.setDni(cursor.getString(6));
            bean.setTipo(cursor.getInt(7));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarUsuario(Usuario bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("usuario",bean.getNickname());
        registro.put("contraseña",bean.getContrasena());
        registro.put("nom_usu",bean.getNombre());
        registro.put("ape_usu",bean.getApellidos());
        registro.put("correo",bean.getCorreo());
        registro.put("dni_usu",bean.getDni());
        registro.put("id_tipo",bean.getTipo());
        salida=(int)base.insert("TB_USUARIO","id_usuario",registro);
        return salida;
    }

    public int actualizarUsuario(Usuario bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues registro=new ContentValues();
        registro.put("id_usuario",bean.getCodUsuario());
        registro.put("usuario",bean.getNickname());
        registro.put("contraseña",bean.getContrasena());
        registro.put("nom_usu",bean.getNombre());
        registro.put("ape_usu",bean.getApellidos());
        registro.put("correo",bean.getCorreo());
        registro.put("dni_usu",bean.getDni());
        registro.put("id_tipo",bean.getTipo());
        salida=base.update("TB_USUARIO",registro,"id_usuario="+bean.getCodUsuario(),null);
        return salida;
    }

    public int eliminarUsuario(int cod){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        salida=base.delete("TB_USUARIO","id_usuario="+cod,null);
        return salida;
    }
}
