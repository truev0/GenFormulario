package com.generador.app;

public interface SistemaFormulario {
    void crearFormulario(String nombre);

    Formulario abrirFormulario(String nombre);

    boolean insertarPreguntaCorta(Formulario form, RespuestaCorta pregunta);

    boolean insertarPreguntaUnica(Formulario form, RespuestaUnica pregunta);

    boolean insertarPreguntaVF(Formulario form, RespuestaVF pregunta);

    boolean eliminarPregunta(Formulario form, int pos);

    boolean modificarOpcion(Formulario form, int posPregunta, String opcionVieja, String opcionNueva);

    boolean modificarEnunciado(Formulario form, int posPregunta, String nuevoEnunciado);

    boolean agregarOpcion(Formulario form, int posPregunta, String opcionNueva);

    boolean eliminarOpcion(Formulario form, int posPregunta, String textoAEliminar);

    boolean asignarRespuesta(Formulario form, int posPregunta);

    boolean guardarYSalir(Formulario form);

}
