package com.example.springData_G2.model;

import com.example.springData_G2.model.dto.AlumnoDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Integer edad;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="profesor_id")
    private Profesor profesor;


    public Alumno() {
    }

    public Alumno(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    public static Alumno from(AlumnoDto alumnoDto){
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setEdad(alumnoDto.getEdad());
        alumno.setProfesor(Profesor.from(alumnoDto.getProfesorDto()));
        return alumno;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
