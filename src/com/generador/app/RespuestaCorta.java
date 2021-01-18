package com.generador.app;

/**
 * Se crea la clase RespuestaCorta, que atiende directamente a las preguntas de tipo respuesta corta, hereda de la clase
 * Pregunta
 */
public class RespuestaCorta extends Pregunta {
    private String respuesta;

    /**
     * Se instancia una nueva pregunta de tipo respuestacorta
     *
     * @param id        identificador de la pregunta
     * @param enunciado texto de la pregunta
     * @param respuesta respuesta de la pregunta
     */
    public RespuestaCorta(char id, String enunciado, String respuesta) {
        super(id, enunciado);
        this.respuesta = respuesta;
    }

    /**
     * Metodo get que nos devuelve la respuesta de la pregunta
     *
     * @return respuesta, respuesta de la pregunta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     *  Metodo set que nos permite setear una nueva respuesta para la pregunta
     *
     * @param respuesta , respuesta de la pregunta
     */
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
