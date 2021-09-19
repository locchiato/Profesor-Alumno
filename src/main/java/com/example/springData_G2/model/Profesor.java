package com.example.springData_G2.model;

import com.example.springData_G2.model.dto.AlumnoDto;
import com.example.springData_G2.model.dto.ProfesorDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


@Entity
@Table
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String titulo;

    @JsonManagedReference
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Alumno> alumnos = new ArrayList<>();

    public Profesor() {
    }

    public Profesor(String nombre, String titulo) {
        this.nombre = nombre;
        this.titulo = titulo;
    }


    public static Profesor from(ProfesorDto profesorDto){
        Profesor profesor = new Profesor();
        profesor.setNombre(profesorDto.getNombre());
        profesor.setTitulo(profesorDto.getTitulo());

        profesor.setAlumnos(profesorDto.getAlumnos().stream().map(Alumno::from).collect(Collectors.toList()));

        return profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
