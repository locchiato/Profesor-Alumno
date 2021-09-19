package com.example.springData_G2.model.dto;

import com.example.springData_G2.model.Alumno;

import java.util.Objects;

public class AlumnoDto {
    
    private Long id;
    private String nombre;
    private Integer edad;

    private ProfesorDto profesorDto;

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


    public ProfesorDto getProfesorDto() {
        return profesorDto;
    }
    public void setProfesorDto(ProfesorDto profesorDto){
        this.profesorDto = profesorDto;
    }

    public static AlumnoDto from(Alumno alumno){
        AlumnoDto alumnoDto = new AlumnoDto();
        alumnoDto.setId(alumno.getId());
        alumnoDto.setNombre(alumno.getNombre());
        alumnoDto.setEdad(alumno.getEdad());
        if(Objects.nonNull(alumno.getProfesor())){
            alumnoDto.setProfesorDto(ProfesorDto.from(alumno.getProfesor()));
        }
        return alumnoDto;
    }
}