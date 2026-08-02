package com.practica.api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // La "base de datos" simulada en una simple lista de textos
    private final List<String> tareas = new ArrayList<>();

    public TaskController() {
        // Tareas iniciales de prueba
        tareas.add("Aprender Spring Boot");
        tareas.add("Crear un controlador simple");
    }

    // 1. Ver todas las tareas (GET http://localhost:8080/api/tasks)
    @GetMapping
    public List<String> obtenerTodas() {
        return tareas;
    }
    // se puede hacer un filtrado y solo devolver las tareas que coincidan con la
    // palabra enviada en el req

    // 2. Agregar una tarea (POST http://localhost:8080/api/tasks?nombre=Estudiar)
    @PostMapping
    public String crearTarea(@RequestParam String nombre) {
        tareas.add(nombre);
        return "Tarea '" + nombre + "' agregada con éxito.";
    }

    // 3. Borrar una tarea por su posición (DELETE http://localhost:8080/api/tasks/0)
    @DeleteMapping("/{posicion}")
    public String eliminarTarea(@PathVariable int posicion) {
        if (posicion >= 0 && posicion < tareas.size()) {
            String eliminada = tareas.remove(posicion);
            return "Eliminada la tarea: " + eliminada;
        }
        return "Error: Posición no válida.";
    }
}
