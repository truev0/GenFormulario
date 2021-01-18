package com.generador.app;

/**
 * Se crea la clase Respuesta Verdadero Falso, que atiende directamente a las preguntas de tipo respuesta verdadero y falso,
 * hereda de la clase Pregunta
 */
public class RespuestaVF extends Pregunta {
    private char respuesta;

    /**
     * Se instancia una nueva pregunta de tipo respuesta verdeadero o falso
     *
     * @param id        identificador de la pregunta
     * @param enunciado texto de la pregunta
     * @param respuesta respuesta de la pregunta
     */
    public RespuestaVF(char id, String enunciado, char respuesta) {
        super(id, enunciado);
        this.respuesta = respuesta;
    }

    /**
     * Metodo get que nos devuelve la respuesta de la pregunta
     *
     * @return respuesta, respuesta de la pregunta
     */
    public char getRespuesta() {
        return respuesta;
    }

    /**
     *  Metodo set que nos permite setear una nueva respuesta para la pregunta
     *
     * @param respuesta , respuesta de la pregunta
     */
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
