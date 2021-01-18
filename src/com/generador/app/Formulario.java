package com.generador.app;

import java.util.ArrayList;

/**
 * Se crea la clase Formulario, el cual contiene una lista de preguntas.
 */
public class Formulario {
    private final String nombre;
    private final ArrayList<Pregunta> listaPreguntas;

    /**
     * Se instnacia un nuevo formulario.
     *
     * @param nombre , definido como el nombre del formulario
     */
    public Formulario(String nombre) {
        this.nombre = nombre;
        this.listaPreguntas = new ArrayList<>();
    }

    /**
     * Metodo que agrega una pregunta a la lista de preguntas del formulario,
     *
     * @param pregunta , recibe una instancia de pregunta previamente creada
     * @return un boolean, dependiendo si se agrego correctamente true, de lo contrario false
     */
    public boolean agregarPregunta(Pregunta pregunta) {
        return this.listaPreguntas.add(pregunta);
    }

    /**
     * Metodo que elimina una pregunta a la lista de preguntas del formulario,
     *
     * @param pos , recibe por parametro la posicion de la pregunta que desea eliminar
     * @return un boolean, dependiendo si se elimino correctamente true, de lo contrario false
     */
    public boolean eliminarPregunta(int pos) {
        Pregunta pregunta = this.listaPreguntas.get(pos);
        return this.listaPreguntas.remove(pregunta);
    }

    /**
     * Metodo get utilizado para recibir el ArrayList con la lista de preguntas.
     *
     * @return listaPreguntas, de tipo ArrayList
     */
    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    /**
     * Metodo get utilizado para recibir el nombre.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Formulario{" + "nombre='" + nombre + '\'' + ", listaPreguntas=" + listaPreguntas + '}';
    }
}
