package com.practica.api.model;

public class Subtarea {
    private String nombre;
    private boolean completada;

    public Subtarea() {}

    public Subtarea(String nombre, boolean completada) {
        this.nombre = nombre;
        this.completada = completada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Subtarea{" +
                "nombre='" + nombre + '\'' +
                ", completada=" + completada +
                '}';
    }
}
