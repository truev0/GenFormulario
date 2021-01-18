package com.generador.app;

import java.util.ArrayList;
import java.util.Iterator;

public class RespuestaUnica extends Pregunta {
    private final ArrayList<Opcion> listaOpciones;
    Iterator<Opcion> iteradorOpciones;

    public RespuestaUnica(char id, String enunciado) {
        super(id, enunciado);
        this.listaOpciones = new ArrayList<>();
    }

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

    public boolean agregarOpcion(Opcion opcion) {
        return this.listaOpciones.add(opcion);
    }

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

    public ArrayList<Opcion> getListaOpciones() {
        return listaOpciones;
    }

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
