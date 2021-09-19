package com.example.springData_G2.dao;

import com.example.springData_G2.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno, Long> {

    @Query("select a from Alumno a where a.nombre=?1")
    Optional<Alumno> buscarAlumno(String nombre);
}
