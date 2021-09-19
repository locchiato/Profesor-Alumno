package com.example.springData_G2.dao;

import com.example.springData_G2.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {


    @Query("select p from Profesor p where p.titulo=?1")
    Optional<Profesor> buscarProfesor(String titulo);
}
