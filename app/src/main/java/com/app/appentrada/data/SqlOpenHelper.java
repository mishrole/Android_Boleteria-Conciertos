package com.app.appentrada.data;

import android.content.ContentValues;
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
        db.execSQL(Utilidades.crearTablaEntrada);
        db.execSQL(Utilidades.crearTablaFavoritos);

        ContentValues valuesTipoUsuario1 = new ContentValues();
        valuesTipoUsuario1.put("usuario", "Cliente");
        db.insert(Utilidades.tablaTipoUsuario, null, valuesTipoUsuario1);

        ContentValues valuesTipoUsuario2 = new ContentValues();
        valuesTipoUsuario2.put("usuario", "Administrador");
        db.insert(Utilidades.tablaTipoUsuario, null, valuesTipoUsuario2);

        ContentValues valuesUsuarios1 = new ContentValues();
        valuesUsuarios1.put("usuario", "arturo");
        valuesUsuarios1.put("contraseña", "123456");
        valuesUsuarios1.put("nom_usu", "Arturo");
        valuesUsuarios1.put("ape_usu", "Carbajal");
        valuesUsuarios1.put("correo", "arturo@gmail.com");
        valuesUsuarios1.put("dni_usu", "12345678");
        valuesUsuarios1.put("id_tipo", 2);
        db.insert(Utilidades.tablaUsuario, null, valuesUsuarios1);

        ContentValues valuesUsuarios2 = new ContentValues();
        valuesUsuarios2.put("usuario", "gustavo");
        valuesUsuarios2.put("contraseña", "123456");
        valuesUsuarios2.put("nom_usu", "Gustavo");
        valuesUsuarios2.put("ape_usu", "Teropa");
        valuesUsuarios2.put("correo", "gustavo@gmail.com");
        valuesUsuarios2.put("dni_usu", "12345678");
        valuesUsuarios2.put("id_tipo", 1);
        db.insert(Utilidades.tablaUsuario, null, valuesUsuarios2);

        ContentValues valuesUsuarios3 = new ContentValues();
        valuesUsuarios3.put("usuario", "enrique");
        valuesUsuarios3.put("contraseña", "123456");
        valuesUsuarios3.put("nom_usu", "Enrique");
        valuesUsuarios3.put("ape_usu", "Soto");
        valuesUsuarios3.put("correo", "enrique@gmail.com");
        valuesUsuarios3.put("dni_usu", "12345678");
        valuesUsuarios3.put("id_tipo", 1);
        db.insert(Utilidades.tablaUsuario, null, valuesUsuarios3);

        ContentValues valuesUsuarios4 = new ContentValues();
        valuesUsuarios4.put("usuario", "mishrole");
        valuesUsuarios4.put("contraseña", "123456");
        valuesUsuarios4.put("nom_usu", "Mitchell");
        valuesUsuarios4.put("ape_usu", "Rodriguez");
        valuesUsuarios4.put("correo", "mishrole@gmail.com");
        valuesUsuarios4.put("dni_usu", "12345678");
        valuesUsuarios4.put("id_tipo", 1);
        db.insert(Utilidades.tablaUsuario, null, valuesUsuarios4);

        ContentValues valuesUsuarios5 = new ContentValues();
        valuesUsuarios5.put("usuario", "angelo");
        valuesUsuarios5.put("contraseña", "123456");
        valuesUsuarios5.put("nom_usu", "Angelo");
        valuesUsuarios5.put("ape_usu", "Abregu");
        valuesUsuarios5.put("correo", "angelo@gmail.com");
        valuesUsuarios5.put("dni_usu", "12345678");
        valuesUsuarios5.put("id_tipo", 1);
        db.insert(Utilidades.tablaUsuario, null, valuesUsuarios5);

        ContentValues valuesZona1 = new ContentValues();
        valuesZona1.put("nom_zona", "VIP");
        valuesZona1.put("precio", 500.0);
        db.insert(Utilidades.tablaZona, null, valuesZona1);

        ContentValues valuesZona2 = new ContentValues();
        valuesZona2.put("nom_zona", "General");
        valuesZona2.put("precio", 350.0);
        db.insert(Utilidades.tablaZona, null, valuesZona2);

        ContentValues valuesZona3 = new ContentValues();
        valuesZona3.put("nom_zona", "VIP");
        valuesZona3.put("precio", 120.0);
        db.insert(Utilidades.tablaZona, null, valuesZona3);

        ContentValues valuesLocal1 = new ContentValues();
        valuesLocal1.put("nom_local", "Estadio Nacional");
        valuesLocal1.put("direccion", "Calle Jose Diaz, Cercado de Lima");
        db.insert(Utilidades.tablaLocal, null, valuesLocal1);

        ContentValues valuesLocal2 = new ContentValues();
        valuesLocal2.put("nom_local", "Estadio Monumental");
        valuesLocal2.put("direccion", "Avenida Javier Prado Este 7700, Ate");
        db.insert(Utilidades.tablaLocal, null, valuesLocal2);

        ContentValues valuesLocal3 = new ContentValues();
        valuesLocal3.put("nom_local", "Jockey Club");
        valuesLocal3.put("direccion", "El Derby, Santiago de Surco");
        db.insert(Utilidades.tablaLocal, null, valuesLocal3);

        ContentValues valuesLocal4 = new ContentValues();
        valuesLocal4.put("nom_local", "Estadio San Marcos");
        valuesLocal4.put("direccion", "UNMSM, Cercado de Lima");
        db.insert(Utilidades.tablaLocal, null, valuesLocal4);

        ContentValues valuesConcierto1 = new ContentValues();
        valuesConcierto1.put("nom_con", "Guns n roses en Lima");
        valuesConcierto1.put("artista", "Guns n roses");
        valuesConcierto1.put("fec_con", "2021-10-10");
        valuesConcierto1.put("desc_con", "Guns n Roses vuelve a Lima con lo que promete ser el evento del año.");
        valuesConcierto1.put("id_local", 1);
        valuesConcierto1.put("foto", 1);
        db.insert(Utilidades.tablaConcierto, null, valuesConcierto1);

        ContentValues valuesConcierto2 = new ContentValues();
        valuesConcierto2.put("nom_con", "Rolling Stones en Lima");
        valuesConcierto2.put("artista", "Rolling Stones");
        valuesConcierto2.put("fec_con", "2021-10-09");
        valuesConcierto2.put("desc_con", "Rolling Stones vuelve a Lima con lo que promete ser el evento del año.");
        valuesConcierto2.put("id_local", 2);
        valuesConcierto2.put("foto", 2);
        db.insert(Utilidades.tablaConcierto, null, valuesConcierto2);

        ContentValues valuesConcierto3 = new ContentValues();
        valuesConcierto3.put("nom_con", "Iron Maiden en Concierto");
        valuesConcierto3.put("artista", "Iron Maiden");
        valuesConcierto3.put("fec_con", "2021-02-12");
        valuesConcierto3.put("desc_con", "Despues de tanto tiempo vuelven con fuerza a tocar sus más grandes exitos.");
        valuesConcierto3.put("id_local", 3);
        valuesConcierto3.put("foto", 3);
        db.insert(Utilidades.tablaConcierto, null, valuesConcierto3);

        ContentValues valuesConcierto4 = new ContentValues();
        valuesConcierto4.put("nom_con", "Jbalvin en Concierto");
        valuesConcierto4.put("artista", "Jbalvin");
        valuesConcierto4.put("fec_con", "2021-10-20");
        valuesConcierto4.put("desc_con", "Concierto especial para todos sus fans despues de una larga gira por Europa.");
        valuesConcierto4.put("id_local", 4);
        valuesConcierto4.put("foto", 4);
        db.insert(Utilidades.tablaConcierto, null, valuesConcierto4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
}