package com.practica.api.model;

import java.util.List;

public class Tarea {
    private String titulo;
    private String descripcion;
    private String prioridad;
    private List<String> etiquetas;
    private List<Subtarea> subtareas;
    private Responsable responsable;

    public Tarea() {}

    public Tarea(String titulo, String descripcion, String prioridad, 
                 List<String> etiquetas, List<Subtarea> subtareas, Responsable responsable) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.etiquetas = etiquetas;
        this.subtareas = subtareas;
        this.responsable = responsable;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Subtarea> getSubtareas() {
        return subtareas;
    }

    public void setSubtareas(List<Subtarea> subtareas) {
        this.subtareas = subtareas;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", etiquetas=" + etiquetas +
                ", subtareas=" + subtareas +
                ", responsable=" + responsable +
                '}';
    }
}
