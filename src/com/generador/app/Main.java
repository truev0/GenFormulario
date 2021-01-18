package com.generador.app;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scOpciones = new Scanner(System.in);
    static Scanner scTexto = new Scanner(System.in);

    public static void main(String[] args) {
        SistemaFormularioImpl sistemaFormularios = new SistemaFormularioImpl();

        leerArchivo(sistemaFormularios);
        int opcion = 0; // Se guarda la opcion a elegir

        do {
            System.out.println("===== SISTEMA DE FORMULARIOS =====");
            System.out.println("1. Abrir un formulario");
            System.out.println("2. Salir");

            try {
                System.out.println("\nSeleccione una opcion: ");
                opcion = scOpciones.nextInt();

                switch (opcion) {
                    case 1 -> {

                        for (int i = 0; i < sistemaFormularios.getListaFormularios().size(); i++) {
                            System.out.println(
                                    ((i + 1) + ". " + sistemaFormularios.getListaFormularios().get(i).getNombre()));
                        }
                        System.out.println("Ingrese el nombre del formulario a abrir: ");
                        String nombre = scTexto.nextLine();
                        Formulario formularioCookie = sistemaFormularios.abrirFormulario(nombre);
                        if (formularioCookie == null) {
                            sistemaFormularios.crearFormulario(nombre);
                            formularioCookie = sistemaFormularios.abrirFormulario(nombre);
                        }
                        int indexF = sistemaFormularios.getListaFormularios().lastIndexOf(formularioCookie);
                        int opcion1 = 0;
                        do {
                            System.out.println("1. Insertar pregunta");
                            System.out.println("2. Eliminar pregunta.");
                            System.out.println("3. Modificar pregunta.");
                            System.out.println("4. Guardar y salir.");
                            System.out.println("5. Salir sin guardar.");

                            try {

                                System.out.println("\n Seleccione una opcion: ");
                                opcion1 = scOpciones.nextInt();
                                scOpciones.nextLine();

                                switch (opcion1) {

                                    case 1:

                                        System.out.println("Ingrese que tipo de pregunta desea insertar");
                                        System.out.println("Corta (c) - Unica (u) - Verdadero/Falso (v)");
                                        String tipoPregunta = scTexto.nextLine();

                                        if (tipoPregunta.charAt(0) == 'c') {

                                            System.out.println("Ingrese el enunciado de la pregunta corta: \n");
                                            String enunciado = scTexto.nextLine();
                                            System.out.println("Ingrese la respuesta de la pregunta corta: \n");
                                            String respuesta = scTexto.nextLine();
                                            RespuestaCorta nuevaPregunta = new RespuestaCorta(tipoPregunta.charAt(0),
                                                    enunciado, respuesta);
                                            if (sistemaFormularios.insertarPreguntaCorta(formularioCookie,
                                                    nuevaPregunta))
                                                System.out.println("Pregunta añadida correctamente");

                                        } else if (tipoPregunta.charAt(0) == 'u') {

                                            System.out.println("Ingrese el enunciado de la pregunta unica: \n");
                                            String enunciado = scTexto.nextLine();
                                            RespuestaUnica nuevaPregunta = new RespuestaUnica(tipoPregunta.charAt(0),
                                                    enunciado);
                                            if (sistemaFormularios.insertarPreguntaUnica(formularioCookie,
                                                    nuevaPregunta))
                                                System.out.println("Pregunta añadida correctamente, debe agregar las "
                                                        + "opciones desde el menu de agregar opciones.");

                                        } else if (tipoPregunta.charAt(0) == 'v') {

                                            System.out.println("Ingrese el enunciado de la pregunta : \n");
                                            String enunciado = scTexto.nextLine();
                                            System.out.println("Ingrese la respuesta, solo se acepta ( v / f ): ");
                                            String respuesta = scTexto.nextLine();
                                            RespuestaVF nuevaPregunta = new RespuestaVF(tipoPregunta.charAt(0),
                                                    enunciado, respuesta.charAt(0));
                                            if (sistemaFormularios.insertarPreguntaVF(formularioCookie, nuevaPregunta))
                                                System.out.println("Pregunta añadida correctamente");

                                        }
                                        break;

                                    case 2:
                                        if (formularioCookie.getListaPreguntas().size() >= 1) {
                                            System.out.println("... Desplegando lista de preguntas ... ");
                                            for (int i = 0; i < formularioCookie.getListaPreguntas().size(); i++) {
                                                System.out.println(
                                                        (i + 1) + ". " + formularioCookie.getListaPreguntas().get(i));
                                            }

                                            System.out.println(
                                                    "\n Ingrese la posicion de la pregunta a eliminar (0 para salir): ");
                                            int pos = scTexto.nextInt();
                                            scTexto.nextLine();
                                            if (sistemaFormularios.eliminarPregunta(formularioCookie, pos)) {
                                                System.out.println("Pregunta eliminada correctamente");
                                            } else {
                                                System.out.println("La pregunta no se elimino, quizas no exite la "
                                                        + "opcion en la lista.");
                                            }
                                        } else {
                                            System.out.println("No es posible eliminar preguntas en este formulario");
                                        }
                                        break;

                                    case 3:
                                        int opcion2 = 0;
                                        do {
                                            System.out.println("1. Modificar enunciado");
                                            System.out.println("2. Agregar opcion.");
                                            System.out.println("3. Modificar opcion.");
                                            System.out.println("4. Eliminar opcion.");
                                            System.out.println("5. Asignar respuesta.");
                                            System.out.println("6. Volver al menu anterior.");

                                            try {
                                                System.out.println("\n Seleccione una opcion: ");
                                                opcion2 = scOpciones.nextInt();
                                                int pos;

                                                switch (opcion2) {
                                                    case 1 -> {
                                                        for (int i = 0; i < formularioCookie.getListaPreguntas()
                                                                .size(); i++) {
                                                            System.out.println((i + 1) + ". "
                                                                    + formularioCookie.getListaPreguntas().get(i));
                                                        }
                                                        System.out.println("Ingrese la posicion de la pregunta a "
                                                                + "modificar el enunciado: ");
                                                        pos = scTexto.nextInt();
                                                        scTexto.nextLine();
                                                        if (pos > 0 && pos < formularioCookie.getListaPreguntas().size()
                                                                + 1) {
                                                            System.out.println("Ingrese el nuevo enunciado: ");
                                                            String enunciadoNuevo = scTexto.nextLine();
                                                            if (sistemaFormularios.modificarEnunciado(formularioCookie,
                                                                    pos, enunciadoNuevo)) {
                                                                System.out.println("Enunciado cambiado correctamente");
                                                            } else {
                                                                System.out.println("El enunciado no se pudo modificar");
                                                            }
                                                        } else {
                                                            System.out.println("\nValor no valido");
                                                        }
                                                    }
                                                    case 2 -> {
                                                        for (int i = 0; i < formularioCookie.getListaPreguntas()
                                                                .size(); i++) {
                                                            System.out.println((i + 1) + ". "
                                                                    + formularioCookie.getListaPreguntas().get(i));
                                                        }
                                                        System.out.println("\nIngrese la posicion de la pregunta a "
                                                                + "añadirle opcion, (recuerde que si no es del tipo "
                                                                + "(Respuesta unica) no podra agregar la opcion): ");
                                                        pos = scTexto.nextInt();
                                                        scTexto.nextLine();
                                                        if (pos > 0 && pos < formularioCookie.getListaPreguntas().size()
                                                                + 1) {
                                                            System.out.println(sistemaFormularios.getListaFormularios()
                                                                    .get(indexF).getListaPreguntas().get(pos - 1));

                                                            System.out.println("\nIngrese el texto que debe incluir la "
                                                                    + "opcion: ");
                                                            String opTexto = scTexto.nextLine();
                                                            if (sistemaFormularios.agregarOpcion(formularioCookie, pos,
                                                                    opTexto)) {
                                                                System.out.println("Opcion agregada correctamente.");
                                                            } else {
                                                                System.out.println("La opcion no se ha podido agregar");
                                                            }
                                                        } else {
                                                            System.out.println("Este valor no es valido.");
                                                        }
                                                    }
                                                    case 3 -> {
                                                        for (int i = 0; i < formularioCookie.getListaPreguntas()
                                                                .size(); i++) {
                                                            System.out.println((i + 1) + ". "
                                                                    + formularioCookie.getListaPreguntas().get(i));
                                                        }
                                                        System.out.println("\nIngrese la posicion de la pregunta a "
                                                                + "modificarle opcion, (recuerde que si no es del tipo "
                                                                + "(Respuesta unica) no podra agregar la opcion): ");
                                                        pos = scTexto.nextInt();
                                                        scTexto.nextLine();
                                                        if (pos > 0 && pos < formularioCookie.getListaPreguntas().size()
                                                                + 1) {
                                                            System.out.println(sistemaFormularios.getListaFormularios()
                                                                    .get(indexF).getListaPreguntas().get(pos - 1));
                                                            System.out.println("\nIngrese el texto de la opcion vieja"
                                                                    + "(si no se encuentra no se podra cambiar): ");
                                                            String opcionVieja = scTexto.nextLine();
                                                            System.out
                                                                    .println("\nIngrese el texto de la opcion nueva: ");
                                                            String opcionNueva = scTexto.nextLine();
                                                            if (sistemaFormularios.modificarOpcion(formularioCookie,
                                                                    pos, opcionVieja, opcionNueva)) {
                                                                System.out.println("Opcion modificada correctamente");
                                                            } else {
                                                                System.out.println("La opcion no se pudo modificar");
                                                            }
                                                        } else {
                                                            System.out.println("\nValor no valido");
                                                        }
                                                    }
                                                    case 4 -> {
                                                        for (int i = 0; i < formularioCookie.getListaPreguntas()
                                                                .size(); i++) {
                                                            System.out.println((i + 1) + ". "
                                                                    + formularioCookie.getListaPreguntas().get(i));
                                                        }
                                                        System.out.println("\nIngrese la posicion de la pregunta a "
                                                                + "eliminar opcion, (recuerde que si no es del tipo "
                                                                + "(Respuesta unica) no podra agregar la opcion): ");
                                                        pos = scTexto.nextInt();
                                                        scTexto.nextLine();
                                                        if (pos > 0 && pos < formularioCookie.getListaPreguntas().size()
                                                                + 1) {
                                                            System.out.println(sistemaFormularios.getListaFormularios()
                                                                    .get(indexF).getListaPreguntas().get(pos - 1));
                                                            System.out.println(
                                                                    "\nIngrese el texto de la opcion a eliminar ("
                                                                            + "si este no existe no se puede eliminar): ");
                                                            String texto = scTexto.nextLine();
                                                            if (sistemaFormularios.eliminarOpcion(formularioCookie, pos,
                                                                    texto)) {
                                                                System.out.println("Opcion eliminada correctamente");
                                                            } else {
                                                                System.out.println("La opcion no se pudo eliminar");
                                                            }
                                                        } else {
                                                            System.out.println("\nValor no valido");
                                                        }
                                                    }
                                                    case 5 -> {
                                                        for (int i = 0; i < formularioCookie.getListaPreguntas()
                                                                .size(); i++) {
                                                            System.out.println((i + 1) + ". "
                                                                    + formularioCookie.getListaPreguntas().get(i));
                                                        }
                                                        System.out.println(
                                                                "\nIngrese la posicion de la pregunta a asignar respuesta: ");
                                                        pos = scTexto.nextInt();
                                                        scTexto.nextLine();
                                                        if (pos > 0 && pos < formularioCookie.getListaPreguntas().size()
                                                                + 1) {
                                                            System.out.println(sistemaFormularios.getListaFormularios()
                                                                    .get(indexF).getListaPreguntas().get(pos - 1));
                                                            if (sistemaFormularios.asignarRespuesta(formularioCookie,
                                                                    pos)) {
                                                                System.out.println("Ejecutado correctamente");
                                                            } else {
                                                                System.out.println("No se pudo ejecutar la accion");
                                                            }
                                                        } else {
                                                            System.out.println("\nValor no valido");
                                                        }
                                                    }
                                                    case 6 -> System.out.println("\n...Saliendo del menu...");
                                                    default -> System.out.println("Ingrese solo del 1 al 6");
                                                }

                                            } catch (InputMismatchException e) {
                                                System.out.println("Debe insertar un numero");
                                                scOpciones.next();
                                            }
                                        } while (opcion2 != 6);
                                        break;

                                    case 4:
                                        System.out.println("Saliendo y guardando...");
                                        if (sistemaFormularios.guardarYSalir(formularioCookie)) {
                                            System.out.println("Salida exitosa");
                                        } else {
                                            System.out.println("Hubo un error");
                                        }
                                        break;

                                    case 5:
                                        System.out.println("\n... Saliendo al menu principal ... ");
                                        break;

                                    default:
                                        System.out.println("Ingrese solo del 1 al 5");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Debe insertar un numero");
                                scOpciones.next();
                            }

                        } while (opcion1 != 5 && opcion1 != 4);
                    }
                    case 2 -> System.out.println("Ha elegido salir");
                    default -> System.out.println("Ingrese solo 1 o 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe insertar un numero");
                scOpciones.next();
            }
        } while (opcion != 2);

    }

    public static void leerArchivo(SistemaFormularioImpl sistema) {
        String ruta = new File("").getAbsolutePath();
        ruta = ruta + "\\";
        File carpeta = new File(ruta);
        File[] listaArchivos = carpeta.listFiles();

        Scanner scanner = null;
        Formulario formulario = null;
        String enunciado;
        String respuesta;

        if (listaArchivos != null) {
            for (File arch : listaArchivos) {
                String file = arch.getName();
                if (file.endsWith(".txt") || file.endsWith(".TXT")) {
                    if (arch.isFile()) {
                        File archivo = new File(ruta + file);
                        try {
                            System.out.println("Leyendo el fichero");
                            String nombre = archivo.getName();
                            int posPunto = nombre.lastIndexOf(".");
                            if (posPunto > 0 && posPunto < (nombre.length() - 1)) {
                                nombre = nombre.substring(0, posPunto);
                            }
                            sistema.crearFormulario(nombre);
                            formulario = sistema.abrirFormulario(nombre);
                            scanner = new Scanner(archivo);
                            while (scanner.hasNextLine()) {
                                String linea = scanner.nextLine();
                                if (linea.charAt(0) == 'c') {
                                    enunciado = scanner.nextLine();
                                    respuesta = scanner.nextLine();
                                    RespuestaCorta nuevaC = new RespuestaCorta('c', enunciado, respuesta);
                                    sistema.insertarPreguntaCorta(formulario, nuevaC);
                                } else if (linea.charAt(0) == 'u') {
                                    String[] cortarLinea = linea.split(",");
                                    int cantOpciones = Integer.parseInt(cortarLinea[1]);
                                    int opCorrecta = Integer.parseInt(cortarLinea[2]);
                                    enunciado = scanner.nextLine();
                                    RespuestaUnica nuevaU = new RespuestaUnica('u', enunciado);
                                    for (int i = 0; i < cantOpciones; i++) {
                                        String stringOpcion = scanner.nextLine();
                                        Opcion opcion = new Opcion(stringOpcion);
                                        if ((i + 1) == opCorrecta) {
                                            opcion.setCorrecta(true);
                                        }
                                        nuevaU.agregarOpcion(opcion);
                                    }
                                    sistema.insertarPreguntaUnica(formulario, nuevaU);
                                } else if (linea.charAt(0) == 'v') {
                                    String[] cortarLinea = linea.split(",");
                                    respuesta = cortarLinea[1];
                                    enunciado = scanner.nextLine();
                                    RespuestaVF nuevaV = new RespuestaVF('v', enunciado, respuesta.charAt(0));
                                    sistema.insertarPreguntaVF(formulario, nuevaV);
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (scanner != null) {
                                    scanner.close();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (formulario != null) {
                            System.out.println("... Guardadas " + formulario.getListaPreguntas().size()
                                    + " preguntas en el formulario " + formulario.getNombre());
                        } else {
                            System.out.println("No se han guardado preguntas.");
                        }
                    }
                }
            }
        }

        System.out.println();
    }

    //
}
