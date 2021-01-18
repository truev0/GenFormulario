package com.generador.app;

import java.util.ArrayList;

public class Formulario {
    private final String nombre;
    private final ArrayList<Pregunta> listaPreguntas;

    public Formulario(String nombre) {
        this.nombre = nombre;
        this.listaPreguntas = new ArrayList<>();
    }

    public boolean agregarPregunta(Pregunta pregunta) {
        return this.listaPreguntas.add(pregunta);
    }

    public boolean eliminarPregunta(int pos) {
        Pregunta pregunta = this.listaPreguntas.get(pos);
        return this.listaPreguntas.remove(pregunta);
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Formulario{" + "nombre='" + nombre + '\'' + ", listaPreguntas=" + listaPreguntas + '}';
    }
}
