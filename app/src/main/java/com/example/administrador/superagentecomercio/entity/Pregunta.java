package com.example.administrador.superagentecomercio.entity;

/**
 * Created by Administrador on 03/11/2017.
 */

public class Pregunta {
    private int idPregunta;
    private String descripcionPregunta;

    public Pregunta(){

    }

    public Pregunta(int idPregunta, String descripcionPregunta) {
        this.idPregunta = idPregunta;
        this.descripcionPregunta = descripcionPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }
}
