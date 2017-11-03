package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class Comercio {
    private String idComercio, ruc, razSocial, direccion, representanteLegal, dniRepresentante;
    private int departamentoComercio, provinciaComercio, distritoComercio;

    public Comercio(String idComercio, String ruc, String razSocial, String direccion, String representanteLegal, String dniRepresentante, int departamentoComercio, int provinciaComercio, int distritoComercio) {
        this.idComercio = idComercio;
        this.ruc = ruc;
        this.razSocial = razSocial;
        this.direccion = direccion;
        this.representanteLegal = representanteLegal;
        this.dniRepresentante = dniRepresentante;
        this.departamentoComercio = departamentoComercio;
        this.provinciaComercio = provinciaComercio;
        this.distritoComercio = distritoComercio;
    }

    public Comercio() {
    }

    public String getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(String idComercio) {
        this.idComercio = idComercio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazSocial() {
        return razSocial;
    }

    public void setRazSocial(String razSocial) {
        this.razSocial = razSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getDniRepresentante() {
        return dniRepresentante;
    }

    public void setDniRepresentante(String dniRepresentante) {
        this.dniRepresentante = dniRepresentante;
    }

    public int getDepartamentoComercio() {
        return departamentoComercio;
    }

    public void setDepartamentoComercio(int departamentoComercio) {
        this.departamentoComercio = departamentoComercio;
    }

    public int getProvinciaComercio() {
        return provinciaComercio;
    }

    public void setProvinciaComercio(int provinciaComercio) {
        this.provinciaComercio = provinciaComercio;
    }

    public int getDistritoComercio() {
        return distritoComercio;
    }

    public void setDistritoComercio(int distritoComercio) {
        this.distritoComercio = distritoComercio;
    }
}
