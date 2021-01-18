package com.generador.app;

/**
 * Interface del sistema de formularios
 */
public interface SistemaFormulario {
    /**
     * Creacion de un formulario dentro del sistema
     *
     * @param nombre nmbre del formulario
     */
    void crearFormulario(String nombre);

    /**
     * Apertura de un formulario que exista en el sistema, retorna un objeto de calse Formulari para trabajar sobre el
     *
     * @param nombre nombre del formulario
     * @return formulario para editar
     */
    Formulario abrirFormulario(String nombre);

    /**
     * Insercion de una pregunta de tipo respuesta corta al formulario que se este editando
     *
     * @param form     formulario a editar
     * @param pregunta pregunta a agregar
     * @return un boolean, dependiendo si se agrego correctamente true, de lo contrario false
     */
    boolean insertarPreguntaCorta(Formulario form, RespuestaCorta pregunta);

    /**
     * Insercion de una pregunta de tipo respuesta unica al formulario que se este editando
     *
     * @param form     formulario a editar
     * @param pregunta pregunta a agregar
     * @return un boolean, dependiendo si se agrego correctamente true, de lo contrario false
     */
    boolean insertarPreguntaUnica(Formulario form, RespuestaUnica pregunta);

    /**
     * Insercion de una pregunta de tipo respuesta verdadero o falso al formulario que se este editando
     *
     * @param form     formulario a editar
     * @param pregunta pregunta a agregar
     * @return un boolean, dependiendo si se agrego correctamente true, de lo contrario false
     */
    boolean insertarPreguntaVF(Formulario form, RespuestaVF pregunta);

    /**
     * Eliminacion de una pregunta dentro de un formulario dada su posicion
     *
     * @param form     formulario a editar
     * @param pos      posicion de la pregunta a eliminar
     * @return un boolean, dependiendo si se elimino correctamente true, de lo contrario false
     */
    boolean eliminarPregunta(Formulario form, int pos);

    /**
     * Modificacion de las opciones de una pregunta dado un formulario, y la opcion a modificar
     *
     * @param form        fomrulario a editar
     * @param posPregunta posicion de la pregunta a modificar
     * @param opcionVieja texto a buscar dentro de las opciones
     * @param opcionNueva texto para reemplazar
     * @return un boolean, dependiendo si se modifico correctamente true, de lo contrario false
     */
    boolean modificarOpcion(Formulario form, int posPregunta, String opcionVieja, String opcionNueva);

    /**
     * Modificacion del enunciado de las preguntas dado un formulario y la posicion de la pregunta a editar
     *
     * @param form           formulario a editar
     * @param posPregunta    posicion de la pregunta a modificar
     * @param nuevoEnunciado nuevo enunciado
     * @return un boolean, dependiendo si se modifico correctamente true, de lo contrario false
     */
    boolean modificarEnunciado(Formulario form, int posPregunta, String nuevoEnunciado);

    /**
     * Insercion de una nueva opcion para una pregunta de tipo respuesta unica
     *
     * @param form        formulario a editar
     * @param posPregunta posicion de la pregunta a modiicar
     * @param opcionNueva texto de la nueva opcion
     * @return un boolean, dependiendo si se agrego correctamente true, de lo contrario false
     */
    boolean agregarOpcion(Formulario form, int posPregunta, String opcionNueva);

    /**
     * Eliminacion de una opcion de la lista de opciones de una pregunta dado un texto para comparar respecto a la lista
     *
     * @param form           formulario a editar
     * @param posPregunta    posicion de la pregunta a modificar
     * @param textoAEliminar texto de la opcion a buscar para eliminar
     * @return un boolean, dependiendo si se elimino correctamente true, de lo contrario false
     */
    boolean eliminarOpcion(Formulario form, int posPregunta, String textoAEliminar);

    /**
     * Asignacion de una respuesta para cualquier tio de pregunta dentro de el formulario
     *
     * @param form        formulario a editar
     * @param posPregunta posicion de la pregunta a modificar
     * @return un boolean, dependiendo si se asigno correctamente la respuesta true, de lo contrario false
     */
    boolean asignarRespuesta(Formulario form, int posPregunta);

    /**
     * Guardar y salir los cambios ejecutados mientras estaba trabajando con el formulario
     *
     * @param form formulario a guardar
     * @return un boolean, dependiendo si se escribio correctamente el archivo true, de lo contrario false
     */
    boolean guardarYSalir(Formulario form);

}
