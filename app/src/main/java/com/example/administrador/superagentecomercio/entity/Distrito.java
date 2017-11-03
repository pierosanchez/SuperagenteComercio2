package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class Distrito {
    private int idDistrito;
    private String descripcionDistrito;

    public Distrito(){

    }

    public Distrito(int idDistrito, String descripcionDistrito) {
        this.idDistrito = idDistrito;
        this.descripcionDistrito = descripcionDistrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDescripcionDistrito() {
        return descripcionDistrito;
    }

    public void setDescripcionDistrito(String descripcionDistrito) {
        this.descripcionDistrito = descripcionDistrito;
    }
}
