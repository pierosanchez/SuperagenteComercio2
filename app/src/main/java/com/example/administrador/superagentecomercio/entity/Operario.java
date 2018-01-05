package com.example.administrador.superagentecomercio.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abarrera on 05/01/2018.
 */

public class Operario implements Parcelable {
    private String id_ope,dni_ope,nom_ope,pater_ope,mater_ope,celular,fono_fijo;
    private int sexo;
    private String sexoj;
    private String comercio;
    private String comercioj;
    private int pais;
    private String paisj;
    private int departamento;
    private String departamentoj;
    private int distrito;
    private String distritoj;
    private int provincia;
    private String provinciaj;
    private String direccion;
    private String usu_reg;

    //*************************************************************************************

    public Operario() {
    }

    //*************************************************************************************

    public Operario(String id_ope, String dni_ope, String nom_ope, String pater_ope, String mater_ope, String celular, String fono_fijo, int sexo, String sexoj, String comercio, String comercioj, int pais, String paisj, int departamento, String departamentoj, int distrito, String distritoj, int provincia, String provinciaj, String direccion, String usu_reg) {
        this.id_ope = id_ope;
        this.dni_ope = dni_ope;
        this.nom_ope = nom_ope;
        this.pater_ope = pater_ope;
        this.mater_ope = mater_ope;
        this.celular = celular;
        this.fono_fijo = fono_fijo;
        this.sexo = sexo;
        this.sexoj = sexoj;
        this.comercio = comercio;
        this.comercioj = comercioj;
        this.pais = pais;
        this.paisj = paisj;
        this.departamento = departamento;
        this.departamentoj = departamentoj;
        this.distrito = distrito;
        this.distritoj = distritoj;
        this.provincia = provincia;
        this.provinciaj = provinciaj;
        this.direccion = direccion;
        this.usu_reg = usu_reg;
    }

    //*************************************************************************************

    protected Operario(Parcel in) {
        String[] data = new String[1];
        in.readStringArray(data);
        id_ope = data[0];
    }

    //*************************************************************************************

    public String getId_ope() {
        return id_ope;
    }

    public void setId_ope(String id_ope) {
        this.id_ope = id_ope;
    }

    public String getDni_ope() {
        return dni_ope;
    }

    public void setDni_ope(String dni_ope) {
        this.dni_ope = dni_ope;
    }

    public String getNom_ope() {
        return nom_ope;
    }

    public void setNom_ope(String nom_ope) {
        this.nom_ope = nom_ope;
    }

    public String getPater_ope() {
        return pater_ope;
    }

    public void setPater_ope(String pater_ope) {
        this.pater_ope = pater_ope;
    }

    public String getMater_ope() {
        return mater_ope;
    }

    public void setMater_ope(String mater_ope) {
        this.mater_ope = mater_ope;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFono_fijo() {
        return fono_fijo;
    }

    public void setFono_fijo(String fono_fijo) {
        this.fono_fijo = fono_fijo;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getSexoj() {
        return sexoj;
    }

    public void setSexoj(String sexoj) {
        this.sexoj = sexoj;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public String getComercioj() {
        return comercioj;
    }

    public void setComercioj(String comercioj) {
        this.comercioj = comercioj;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public String getPaisj() {
        return paisj;
    }

    public void setPaisj(String paisj) {
        this.paisj = paisj;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getDepartamentoj() {
        return departamentoj;
    }

    public void setDepartamentoj(String departamentoj) {
        this.departamentoj = departamentoj;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getDistritoj() {
        return distritoj;
    }

    public void setDistritoj(String distritoj) {
        this.distritoj = distritoj;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public String getProvinciaj() {
        return provinciaj;
    }

    public void setProvinciaj(String provinciaj) {
        this.provinciaj = provinciaj;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsu_reg() {
        return usu_reg;
    }

    public void setUsu_reg(String usu_reg) {
        this.usu_reg = usu_reg;
    }

    //*************************************************************************************

    public static final Creator<Operario> CREATOR = new Creator<Operario>() {
        @Override
        public Operario createFromParcel(Parcel source) {
            return new Operario(source);
        }

        @Override
        public Operario[] newArray(int size) {
            return new Operario[size];
        }
    };

    //*************************************************************************************

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.id_ope});
    }
}
