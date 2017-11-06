package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class Moneda {
    private int cod_tipo_moneda;
    private String tipo_moneda, signo_moneda;

    public Moneda(){

    }

    public Moneda(int cod_tipo_moneda, String tipo_moneda, String signo_moneda) {
        this.cod_tipo_moneda = cod_tipo_moneda;
        this.tipo_moneda = tipo_moneda;
        this.signo_moneda = signo_moneda;
    }

    public int getCod_tipo_moneda() {
        return cod_tipo_moneda;
    }

    public void setCod_tipo_moneda(int cod_tipo_moneda) {
        this.cod_tipo_moneda = cod_tipo_moneda;
    }

    public String getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(String tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public String getSigno_moneda() {
        return signo_moneda;
    }

    public void setSigno_moneda(String signo_moneda) {
        this.signo_moneda = signo_moneda;
    }
}
