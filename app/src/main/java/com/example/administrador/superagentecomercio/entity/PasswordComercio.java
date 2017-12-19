package com.example.administrador.superagentecomercio.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrador on 03/11/2017.
 */

public class PasswordComercio implements Parcelable{
    private String idPassword, idComercio, claveAcceso, pregunta, respuesta, correo, celular,
        reptaCambioCalve;

    private int validCelUsu;

    public PasswordComercio(){

    }

    protected PasswordComercio(Parcel in) {
        String[] data = new String[2];
        in.readStringArray(data);
        idComercio = data[0];
        idPassword = data[1];
    }

    public PasswordComercio(String idPassword, String idComercio, String claveAcceso, String pregunta, String respuesta, String correo, String celular) {
        this.idPassword = idPassword;
        this.idComercio = idComercio;
        this.claveAcceso = claveAcceso;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.correo = correo;
        this.celular = celular;
    }

    public int getValidCelUsu() {
        return validCelUsu;
    }

    public void setValidCelUsu(int validCelUsu) {
        this.validCelUsu = validCelUsu;
    }

    public String getReptaCambioCalve() {
        return reptaCambioCalve;
    }

    public void setReptaCambioCalve(String reptaCambioCalve) {
        this.reptaCambioCalve = reptaCambioCalve;
    }

    public String getIdPassword() {
        return idPassword;
    }

    public void setIdPassword(String idPassword) {
        this.idPassword = idPassword;
    }

    public String getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(String idComercio) {
        this.idComercio = idComercio;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.idComercio, this.idPassword});
    }

    public static final Parcelable.Creator<PasswordComercio> CREATOR = new Creator<PasswordComercio>() {
        @Override
        public PasswordComercio createFromParcel(Parcel source) {
            return new PasswordComercio(source);
        }

        @Override
        public PasswordComercio[] newArray(int size) {
            return new PasswordComercio[size];
        }
    };
}
