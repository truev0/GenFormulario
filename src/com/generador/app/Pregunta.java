package com.generador.app;

public abstract class Pregunta {
    private final char id;
    private String enunciado;

    public Pregunta(char id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    public char getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public abstract String cambios();

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", enunciado='" + enunciado + '\'' + '}';
    }
}
