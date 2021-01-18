package com.generador.app;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SistemaFormularioImpl implements SistemaFormulario {
    private final ArrayList<Formulario> listaFormularios;
    private Iterator<Formulario> iteradorFormularios;
    private Scanner scanner;

    public SistemaFormularioImpl() {
        this.listaFormularios = new ArrayList<>();
    }

    @Override
    public void crearFormulario(String nombre) {
        Formulario formulario = new Formulario(nombre);
        listaFormularios.add(formulario);
    }

    @Override
    public Formulario abrirFormulario(String nombre) {
        iteradorFormularios = this.listaFormularios.iterator();
        while (iteradorFormularios.hasNext()) {
            Formulario formulario = iteradorFormularios.next();
            if (nombre.equals(formulario.getNombre())) {
                return formulario;
            }
        }
        System.out.println("No se ha encontrado ese nombre de formulario");
        return null;
    }

    @Override
    public boolean insertarPreguntaCorta(Formulario form, RespuestaCorta pregunta) {
        if (form != null) {
            return form.agregarPregunta(pregunta);
        } else {
            System.out.println("El formulario no es valido, no se pudo agregar");
            return false;
        }
    }

    @Override
    public boolean insertarPreguntaUnica(Formulario form, RespuestaUnica pregunta) {

        if (form != null) {
            return form.agregarPregunta(pregunta);
        } else {
            System.out.println("El formulario no es valido, no se pudo agregar");
            return false;
        }
    }

    @Override
    public boolean insertarPreguntaVF(Formulario form, RespuestaVF pregunta) {

        if (form != null) {
            return form.agregarPregunta(pregunta);
        } else {
            System.out.println("El formulario no es valido, no se pudo agregar");
            return false;
        }
    }

    @Override
    public boolean eliminarPregunta(Formulario form, int pos) {
        if (form != null) {
            int cantPreguntas = form.getListaPreguntas().size();
            if ((pos - 1) < cantPreguntas && (pos - 1) >= 0) {
                return form.eliminarPregunta(pos - 1);
            }
        }
        return false;
    }

    @Override
    public boolean modificarOpcion(Formulario form, int posPregunta, String opcionVieja, String opcionNueva) {
        if (form != null) {
            int cantPreguntas = form.getListaPreguntas().size();
            if ((posPregunta - 1) < cantPreguntas && (posPregunta - 1) >= 0) {
                if (form.getListaPreguntas().get(posPregunta - 1).getId() == 'u') {
                    RespuestaUnica pregunta = (RespuestaUnica) form.getListaPreguntas().get(posPregunta - 1);
                    if (pregunta != null) {
                        Opcion opcionAEditar = pregunta.buscarOpcion(opcionVieja);
                        if (opcionAEditar != null) {
                            opcionAEditar.setTexto(opcionNueva);
                            return true;
                        }
                    } else {
                        System.out.println("La posicion que indica no existe");
                        return false;
                    }
                } else {
                    System.out.println("No es posible modificar la opcion de esta pregunta");
                }
            }
        }
        return false;
    }

    @Override
    public boolean modificarEnunciado(Formulario form, int posPregunta, String nuevoEnunciado) {
        if (form != null) {
            int cantPreguntas = form.getListaPreguntas().size();
            if ((posPregunta - 1) < cantPreguntas && (posPregunta - 1) >= 0) {
                Pregunta pregunta = form.getListaPreguntas().get((posPregunta - 1));
                if (pregunta != null) {
                    pregunta.setEnunciado(nuevoEnunciado);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean agregarOpcion(Formulario form, int posPregunta, String opcionNueva) {
        if (form != null) {
            int cantPreguntas = form.getListaPreguntas().size();
            if ((posPregunta - 1) < cantPreguntas && (posPregunta - 1) >= 0) {
                if (form.getListaPreguntas().get(posPregunta - 1).getId() == 'u') {
                    RespuestaUnica pregunta = (RespuestaUnica) form.getListaPreguntas().get(posPregunta - 1);
                    if (pregunta != null && pregunta.getId() == 'u') {
                        System.out.println(pregunta.getEnunciado());
                        Opcion opcion = new Opcion(opcionNueva);
                        if (pregunta.agregarOpcion(opcion))
                            return true;
                    } else {
                        System.out.println("No se puede agregar opciones a esta pregunta");
                    }
                } else {
                    System.out.println("Esta pregunta no permite agregar opciones");
                }
            } else {
                System.out.println("Esta posicion no esta en el rango de preguntas");
            }
        }
        return false;
    }

    @Override
    public boolean eliminarOpcion(Formulario form, int posPregunta, String textoAEliminar) {
        if (form != null) {
            int cantPreguntas = form.getListaPreguntas().size();
            if ((posPregunta - 1) < cantPreguntas && (posPregunta - 1) >= 0) {
                if (form.getListaPreguntas().get(posPregunta - 1).getId() == 'u') {
                    RespuestaUnica pregunta = (RespuestaUnica) form.getListaPreguntas().get(posPregunta - 1);
                    if (pregunta != null) {
                        if (pregunta.getListaOpciones().size() >= 1) {
                            if (pregunta.eliminarOpcion(textoAEliminar))
                                return true;
                        }
                    } else {
                        System.out.println("No se pueden eliminar opciones de esta pregunta");
                    }
                } else {
                    System.out.println("Esta pregunta no es de tipo unico");
                }
            } else {
                System.out.println("Esta posicion no esta en el rango de preguntas");
            }
        }
        return false;
    }

    @Override
    public boolean asignarRespuesta(Formulario form, int posPregunta) {
        scanner = new Scanner(System.in);
        int opcion;
        String respuestaCorta;
        String respuestaVF;

        if (form != null) {
            int cantPreguntas = form.getListaPreguntas().size();
            if ((posPregunta - 1) < cantPreguntas && (posPregunta - 1) >= 0) {
                if (form.getListaPreguntas().get(posPregunta - 1).getId() == 'u') {
                    RespuestaUnica pregunta = (RespuestaUnica) form.getListaPreguntas().get(posPregunta - 1);
                    pregunta.mostrarPregunta();
                    System.out.println("Que opcion desea setear como respuesta?: ");
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= pregunta.getListaOpciones().size()) {
                        if (pregunta.getListaOpciones().size() >= 1) {
                            Iterator<Opcion> iterador = pregunta.iteradorOpciones;
                            while (iterador.hasNext()) {
                                Opcion op0 = iterador.next();
                                op0.setCorrecta(false);
                            }
                            Opcion op = pregunta.getListaOpciones().get(opcion - 1);
                            op.setCorrecta(true);
                        } else {
                            System.out.println("Esta pregunta solo tiene una opcion");
                            Opcion op = pregunta.getListaOpciones().get(0);
                            op.setCorrecta(true);
                        }
                        System.out.println("Respuesta seteada correctamente");
                        return true;

                    } else {
                        System.out.println("Esta posicion de opcion no existe");
                    }
                } else if (form.getListaPreguntas().get(posPregunta - 1).getId() == 'c') {
                    RespuestaCorta pregunta = (RespuestaCorta) form.getListaPreguntas().get(posPregunta - 1);
                    System.out.println("\nInserte la respuesta para la pregunta seleccionada: ");
                    respuestaCorta = scanner.nextLine();
                    pregunta.setRespuesta(respuestaCorta);
                    System.out.println("Respuesta seteada correctamente");
                    return true;
                } else if (form.getListaPreguntas().get(posPregunta - 1).getId() == 'v') {
                    RespuestaVF pregunta = (RespuestaVF) form.getListaPreguntas().get(posPregunta - 1);
                    System.out.println("\nInserte la respuesta (v / f): ");
                    respuestaVF = scanner.nextLine();
                    if (respuestaVF.charAt(0) == 'v' || respuestaVF.charAt(0) == 'f') {
                        pregunta.setRespuesta(respuestaVF.charAt(0));
                        System.out.println("Respuesta seteada correctamente");
                        return true;
                    }
                }
            } else {
                System.out.println("Esta posicion no esta en el rango de preguntas");
            }
        }
        return false;
    }

    @Override
    public boolean guardarYSalir(Formulario form) {
        Iterator<Pregunta> iterador = form.getListaPreguntas().iterator();
        try {
            FileWriter fw = new FileWriter(form.getNombre() + ".txt");
            while (iterador.hasNext()) {
                Pregunta pregunta = iterador.next();
                fw.write(pregunta.cambios());
            }
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al escribir");
            return false;
        }
    }

    public ArrayList<Formulario> getListaFormularios() {
        return listaFormularios;
    }
}
