package com.example.springData_G2.service;

import com.example.springData_G2.dao.AlumnoRepository;
import com.example.springData_G2.dao.ProfesorRepository;
import com.example.springData_G2.model.Alumno;
import com.example.springData_G2.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServicioImpl {

    @Autowired
    private ProfesorRepository profesorRepository;

    /*public ProfesorServicioImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }*/

    public Profesor registrarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor buscarProfesor(Long id){
        return profesorRepository.getById(id);
    }

    public Profesor actualizarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(Profesor profesor){
        profesorRepository.delete(profesor);
    }

    public Profesor buscarPorTitulo (String titulo){
        return profesorRepository.buscarProfesor(titulo).get();
    }

    public List<Profesor> buscarTodos(){
        return profesorRepository.findAll();
    }

}
