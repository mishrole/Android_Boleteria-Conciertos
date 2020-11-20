package com.app.appentrada.entidad;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {

    private String codPedido;
    private Date fecha;
    private String codUsuario;

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
}
