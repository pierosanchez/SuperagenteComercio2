package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class Cuentas {
    private String idCuenta, idComercio, numCuenta, cci;
    private int tipoCuenta, banco, moneda;

    public Cuentas(){

    }

    public Cuentas(String idCuenta, String idComercio, String numCuenta, String cci, int tipoCuenta, int banco, int moneda) {
        this.idCuenta = idCuenta;
        this.idComercio = idComercio;
        this.numCuenta = numCuenta;
        this.cci = cci;
        this.tipoCuenta = tipoCuenta;
        this.banco = banco;
        this.moneda = moneda;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(String idComercio) {
        this.idComercio = idComercio;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getCci() {
        return cci;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }
}
