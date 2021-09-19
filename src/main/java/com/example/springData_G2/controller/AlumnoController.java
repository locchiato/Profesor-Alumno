package com.example.springData_G2.controller;

import com.example.springData_G2.model.Alumno;
import com.example.springData_G2.model.dto.AlumnoDto;
import com.example.springData_G2.service.AlumnoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/alumnos", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AlumnoController {

    @Autowired
    private AlumnoServicioImpl alumnoServicio;

    @PostMapping("/reg")
    public ResponseEntity<AlumnoDto> registrarAlumno(@RequestBody AlumnoDto alumno) {

        return ResponseEntity.ok(alumnoServicio.registrarAlumno(Alumno.from(alumno)));
    }

    @GetMapping(value ="{id}")
    public ResponseEntity<AlumnoDto> buscar(@PathVariable Long id) {
        AlumnoDto alumno = alumnoServicio.buscarAlumno(id);
        return ResponseEntity.ok(alumno);
    }

    @GetMapping(value = "{name}")
    public ResponseEntity<AlumnoDto> buscarPorTitulo(@PathVariable String name) {
        AlumnoDto alumno = alumnoServicio.buscarPorNombre(name);
        return ResponseEntity.ok(alumno);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AlumnoDto> actualizar(@PathVariable Long id, @RequestBody AlumnoDto alumno) {
        ResponseEntity<AlumnoDto> response = null;

        if (alumnoServicio.buscarAlumno(id) != null) {
            alumno.setId(id);
            response = ResponseEntity.ok(alumnoServicio.actualizarAlumno(Alumno.from(alumno)));
        } else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (alumnoServicio.buscarAlumno(id) != null) {
            alumnoServicio.eliminarAlumno(Alumno.from(alumnoServicio.buscarAlumno(id)));
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<AlumnoDto>> buscarTodos(){
        return ResponseEntity.ok(alumnoServicio.buscarTodos());
    }




}
