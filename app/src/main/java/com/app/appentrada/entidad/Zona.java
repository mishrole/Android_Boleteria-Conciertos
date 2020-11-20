package com.app.appentrada.entidad;

import java.io.Serializable;

public class Zona implements Serializable {

    private String codZona;
    private String nombre;

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
