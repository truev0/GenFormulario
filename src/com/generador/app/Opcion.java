package com.generador.app;

public class Opcion {
    private boolean correcta;
    private String texto;

    public Opcion(String texto) {
        this.texto = texto;
        this.correcta = Boolean.parseBoolean(null);
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {

        return texto + "\n";
    }
}
