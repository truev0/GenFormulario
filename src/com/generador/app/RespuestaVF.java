package com.generador.app;

public class RespuestaVF extends Pregunta {
    private char respuesta;

    public RespuestaVF(char id, String enunciado, char respuesta) {
        super(id, enunciado);
        this.respuesta = respuesta;
    }

    public char getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(char respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String cambios() {
        return this.getId() + "," + this.getRespuesta() + "\n" + this.getEnunciado() + "\n";
    }

    @Override
    public String toString() {
        return "Pregunta tipo Verdadero/Falso" + "\n" + super.getEnunciado() + "\n" + this.getRespuesta();
    }
}
