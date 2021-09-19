package com.example.springData_G2.model.dto;

import com.example.springData_G2.model.Profesor;

import java.util.*;
import java.util.stream.Collectors;

public class ProfesorDto {
    
    private Long id;
    private String nombre;
    private String titulo;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AlumnoDto> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoDto> alumnos) {
        this.alumnos = alumnos;
    }

    private List<AlumnoDto> alumnos = new ArrayList<>();


    public static ProfesorDto from(Profesor profesor){
        ProfesorDto profesorDto = new ProfesorDto();
        profesorDto.setId(profesor.getId());
        profesorDto.setNombre(profesor.getNombre());
        profesorDto.setTitulo(profesor.getTitulo());

        profesorDto.setAlumnos(profesor.getAlumnos().stream().map(AlumnoDto::from).collect(Collectors.toList()));
        return profesorDto;
    }
}