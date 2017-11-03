package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class PasswordComercio {
    private String idPassword, idComercio, claveAcceso, pregunta, respuesta, correo, celular;

    public PasswordComercio(){

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
}
