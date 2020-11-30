package com.app.appentrada.utilidades;

public class Utilidades {

    /*Creacion de tabla tipo Usuario*/
    public static final String tablaTipoUsuario = "TB_TIPO_USUARIO";
    public static final String crearTablaTipoUsuario = "CREATE TABLE "+tablaTipoUsuario+" ("+
            "id_tipo integer primary key autoincrement,"+
            "usuario varchar(15) )";

    /*Creacion de tabla Usuario*/
    public static final String tablaUsuario = "TB_USUARIO";
    public static final String crearTablaUsuario = "CREATE TABLE "+tablaUsuario+" ("+
            "id_usuario integer primary key autoincrement,"+
            "usuario varchar(20),"+
            "contraseña varchar(30),"+
            "nom_usu varchar(30),"+
            "ape_usu varchar(30),"+
            "correo varchar(45),"+
            "dni_usu char(8),"+
            "id_tipo int,"+
            "foreign key (id_tipo) references TB_TIPO_USUARIO(id_tipo) )";

    /*Creacion de tabla zona*/
    public static final String tablaZona = "TB_ZONA";
    public static final String crearTablaZona = "CREATE TABLE "+tablaZona+" ("+
            "id_zona integer primary key autoincrement,"+
            "nom_zona varchar(20),"+
            "precio double)";

    /*Creacion de tabla local*/
    public static final String tablaLocal = "TB_LOCAL";
    public static final String crearTablaLocal = "CREATE TABLE "+tablaLocal+" ("+
            "id_local integer primary key autoincrement,"+
            "nom_local varchar(30),"+
            "direccion varchar(100) )";

    /*Creacion de tabla Usuario*/
    public static final String tablaConcierto = "TB_CONCIERTO";
    public static final String crearTablaConcierto = "CREATE TABLE "+tablaConcierto+" ("+
            "id_concierto integer primary key autoincrement,"+
            "nom_con varchar(30),"+
            "artista varchar(40),"+
            "fec_con text,"+
            "desc_con varchar(255),"+
            "id_local int,"+
            "foto int,"+
            "foreign key (id_local) references TB_LOCAL(id_local) )";

    /*Creacion de tabla Entrada*/
    public static final String tablaEntrada = "TB_ENTRADA";
    public static final String crearTablaEntrada = "CREATE TABLE "+tablaEntrada+" ("+
            "id_entrada integer primary key autoincrement,"+
            "id_concierto int,"+
            "id_zona int,"+
            "estado int,"+
            "precio double,"+
            "foreign key (id_concierto) references TB_CONCIERTO(id_concierto),"+
            "foreign key (id_zona) references TB_ZONA(id_zona) )";

}
