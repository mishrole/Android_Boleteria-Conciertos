package com.app.appentrada.entidad;

import java.io.Serializable;

public class Entrada implements Serializable {

    private int codEntrada;
    private double precio;
    private int estado;
    private int codZona;
    private int codConcierto;

    public int getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(int codEntrada) {
        this.codEntrada = codEntrada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCodZona() {
        return codZona;
    }

    public void setCodZona(int codZona) {
        this.codZona = codZona;
    }

    public int getCodConcierto() {
        return codConcierto;
    }

    public void setCodConcierto(int codConcierto) {
        this.codConcierto = codConcierto;
    }
}
