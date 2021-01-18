package com.generador.app;

/**
 * Se crea la clase Pregunta, la cual sera abstracta y sera la super-clase de diferentes tipos de preguntas
 */
public abstract class Pregunta {
    private final char id;
    private String enunciado;

    /**
     * Se instancia una nueva pregunta
     *
     * @param id        identificador del tipo de prregunta
     * @param enunciado enunciado de la pregunta
     */
    public Pregunta(char id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    /**
     * Metodo get que nos retorna el identificador de la pregunta
     *
     * @return id, identificador
     */
    public char getId() {
        return id;
    }

    /**
     * Metodo get que nos retorna el enunciado de la pregunta
     *
     * @return enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Metodo set que nos permite setear un nuevo enunciado para la pregunta
     *
     * @param enunciado texto de la pregunta
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Metodo abstracto para la escritura de los cambios
     *
     * @return String
     */
    public abstract String cambios();

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", enunciado='" + enunciado + '\'' + '}';
    }
}
