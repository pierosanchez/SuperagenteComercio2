package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class Provincia {
    private int idProvincia;
    private String descripcionProvincia;

    public Provincia(){

    }

    public Provincia(int idProvincia, String descripcionProvincia) {
        this.idProvincia = idProvincia;
        this.descripcionProvincia = descripcionProvincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDescripcionProvincia() {
        return descripcionProvincia;
    }

    public void setDescripcionProvincia(String descripcionProvincia) {
        this.descripcionProvincia = descripcionProvincia;
    }
}
