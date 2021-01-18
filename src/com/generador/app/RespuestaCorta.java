package com.generador.app;

public class RespuestaCorta extends Pregunta {
    private String respuesta;

    public RespuestaCorta(char id, String enunciado, String respuesta) {
        super(id, enunciado);
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String cambios() {
        return this.getId() + "\n" + super.getEnunciado() + "\n" + this.getRespuesta() + "\n";
    }

    @Override
    public String toString() {
        return "Pregunta tipo corta" + "\n" + super.getEnunciado() + "\n" + this.getRespuesta();
    }
}
