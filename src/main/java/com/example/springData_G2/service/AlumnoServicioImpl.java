package com.example.springData_G2.service;

import com.example.springData_G2.dao.AlumnoRepository;
import com.example.springData_G2.dao.AlumnoRepository;
import com.example.springData_G2.model.Alumno;
import com.example.springData_G2.model.Alumno;
import com.example.springData_G2.model.dto.AlumnoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServicioImpl {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public AlumnoDto registrarAlumno(Alumno alumno) {
        return saveAlumno(alumno);
    }

    private AlumnoDto saveAlumno(Alumno alumno) {
        return AlumnoDto.from(alumnoRepository.save(alumno));
    }

    public AlumnoDto buscarAlumno(Long id){
        return AlumnoDto.from(alumnoRepository.getById(id));
    }

    public AlumnoDto actualizarAlumno(Alumno alumno){
        return saveAlumno(alumno);
    }

    public void eliminarAlumno(Alumno alumno){
        alumnoRepository.delete(alumno);
    }

    public List<AlumnoDto> buscarTodos(){
        return alumnoRepository.findAll().stream().map(AlumnoDto::from).collect(Collectors.toList());
    }

    public AlumnoDto buscarPorNombre(String nombre){
        return AlumnoDto.from(alumnoRepository.buscarAlumno(nombre).get());
    }


}
