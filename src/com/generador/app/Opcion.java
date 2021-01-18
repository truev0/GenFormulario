package com.generador.app;

/**
 * Se crea la clase Opcion, el cual almacena los valores usados como opciones para las preguntas de respuesta unica
 */
public class Opcion {
    private boolean correcta;
    private String texto;

    /**
     * Se instancia una nueva opcion.
     *
     * @param texto , almacena el valor de la opcion, es decir su informacion
     */
    public Opcion(String texto) {
        this.texto = texto;
        this.correcta = Boolean.parseBoolean(null);
    }

    /**
     * Metodo que retorna un valor booleano para comprobar si la opcion es correcta
     *
     * @return un boolean, dependiendo si es correcto true, de lo contrario false
     */
    public boolean isCorrecta() {
        return correcta;
    }

    /**
     * Metodo que permite setear si la opcion es correcta
     *
     * @param correcta , boolean
     */
    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    /**
     * Metodo get que nos devuelve el valor o informacion de la opcion
     *
     * @return texto, informacion de la opcion
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Metodo set que permite setear un nuevo valor para una opcion
     *
     * @param texto, informacion de la opcion
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {

        return texto + "\n";
    }
}
