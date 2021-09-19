package com.example.springData_G2.controller;

import com.example.springData_G2.model.Profesor;
import com.example.springData_G2.service.ProfesorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profesores", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfesorController {

    @Autowired
    private ProfesorServicioImpl profesorServicio;

    @PostMapping("/reg")
    public ResponseEntity<Profesor> registrarProfesor(@RequestBody Profesor profesor) {

        return ResponseEntity.ok(profesorServicio.registrarProfesor(profesor));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Profesor> buscar(@PathVariable Long id) {
        Profesor profesor = profesorServicio.buscarProfesor(id);
        return ResponseEntity.ok(profesor);

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        ResponseEntity<Profesor> response = null;
        if (profesorServicio.buscarProfesor(id) != null) {
            profesor.setId(id);
            response = ResponseEntity.ok(profesorServicio.actualizarProfesor(profesor));
        } else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (profesorServicio.buscarProfesor(id) != null) {
            profesorServicio.eliminarProfesor(profesorServicio.buscarProfesor(id));
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Profesor>> buscarTodos(){
        return ResponseEntity.ok(profesorServicio.buscarTodos());
    }




}
