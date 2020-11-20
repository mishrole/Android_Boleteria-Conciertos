package com.app.appentrada.entidad;

import java.io.Serializable;
import java.util.Date;

public class Tarjeta implements Serializable {

    private int codTarjeta;
    private String numTarjeta;
    private Date fechaVenc;
    private String cvc;
    private int estado;
    private String codUSuario;

}
