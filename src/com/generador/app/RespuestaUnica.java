package com.generador.app;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Se crea la clase RespuestaUnica, que atiende directamente a las preguntas de tipo respuesta unica, de seleccion multiple,
 * hereda de la clase pregunta
 */
public class RespuestaUnica extends Pregunta {
    private final ArrayList<Opcion> listaOpciones;
    /**
     * Iterador de la lista de opciones de la pregunta
     */
    Iterator<Opcion> iteradorOpciones;

    /**
     * Se instancia una nueva pregunta de tipo respuesta unica
     *
     * @param id        identificador de la pregunta
     * @param enunciado texto de la pregimta
     */
    public RespuestaUnica(char id, String enunciado) {
        super(id, enunciado);
        this.listaOpciones = new ArrayList<>();
    }

    /**
     * Metodo que permite la eliminacion de una opcion para una pregunta
     *
     * @param textoOpcion , texto opcion para buscar y comparar con las diferentes opciones existentes
     * @return un boolean, dependiendo si se elimino correctamente true, de lo contrario false
     */
    public boolean eliminarOpcion(String textoOpcion) {
        iteradorOpciones = this.listaOpciones.iterator();
        while (iteradorOpciones.hasNext()) {
            Opcion opcion = iteradorOpciones.next();
            if (textoOpcion.equals(opcion.getTexto())) {
                iteradorOpciones.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que agrega una opcion a la lista de opciones de la pregunta
     *
     * @param opcion , recibe una instancia de opcion previamente creada
     * @return un boolean, dependiendo si se agrego correctamente true, de lo contrario false
     */
    public boolean agregarOpcion(Opcion opcion) {
        return this.listaOpciones.add(opcion);
    }

    /**
     * Metodo que itera sobre la lista de opciones para devolver la opcion que comparada con el texto ingresado y la lista
     * de opciones sea la misma.
     *
     * @param textoOpcion texto de la opcion a buscar dentro de la lista
     * @return objeto opcion
     */
    public Opcion buscarOpcion(String textoOpcion) {
        iteradorOpciones = this.listaOpciones.iterator();
        while (iteradorOpciones.hasNext()) {
            Opcion opcion = iteradorOpciones.next();
            if (textoOpcion.equalsIgnoreCase(opcion.getTexto())) {
                return opcion;
            }
        }
        return null;
    }

    /**
     * Metodo get que devuelve la lista de opciones de la pregunta actual
     *
     * @return lista opciones
     */
    public ArrayList<Opcion> getListaOpciones() {
        return listaOpciones;
    }

    /**
     * Metodo que muestra la pregunta junto sus opciones de una forma mas legible por pantalla
     */
    public void mostrarPregunta() {
        System.out.println(this.getEnunciado());
        int i = 0;
        while (i < listaOpciones.size()) {
            System.out.println("\t" + (i + 1) + ". " + listaOpciones.get(i));
            i++;
        }
    }

    @Override
    public String cambios() {
        iteradorOpciones = this.listaOpciones.iterator();
        int pos = 0;
        while (iteradorOpciones.hasNext()) {
            Opcion o = iteradorOpciones.next();
            if (o.isCorrecta()) {
                pos = listaOpciones.indexOf(o);
            }
        }
        String resultado = this.getId() + "," + this.listaOpciones.size() + "," + (pos + 1) + "\n" + this.getEnunciado()
                + "\n";
        for (Opcion o : listaOpciones) {
            resultado += o.toString();
        }
        return resultado;
    }

    @Override
    public String toString() {
        iteradorOpciones = this.listaOpciones.iterator();
        int pos = 0;
        while (iteradorOpciones.hasNext()) {
            Opcion o = iteradorOpciones.next();
            if (o.isCorrecta()) {
                pos = listaOpciones.indexOf(o);
            }
        }
        String resultado = "Pregunta tipo Unica, " + this.getEnunciado() + ", con " + this.listaOpciones.size()
                + " opciones, la " + (pos + 1) + " es la verdadera\n";
        for (Opcion o : listaOpciones) {
            resultado += "- " + o.toString();
        }
        if (this.listaOpciones.size() == 0) {
            return "Pregunta tipo Unica, " + this.getEnunciado() + ", con " + this.listaOpciones.size() + " opciones,"
                    + " no tiene opcion verdadera\n" + listaOpciones;
        } else {
            return resultado;
        }
    }
}
