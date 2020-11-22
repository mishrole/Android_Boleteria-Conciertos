package com.app.appentrada.entidad;

import java.io.Serializable;

public class Concierto implements Serializable {

    private int codConcierto;
    private String nombre;
    private String artista;
    private String fecha;
    private String descrip;
    private int codLocal;
    private int foto;

    public int getCodConcierto() {
        return codConcierto;
    }

    public void setCodConcierto(int codConcierto) {
        this.codConcierto = codConcierto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(int codLocal) {
        this.codLocal = codLocal;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
