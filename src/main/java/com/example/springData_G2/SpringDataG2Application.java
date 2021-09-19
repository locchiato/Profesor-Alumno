package com.example.springData_G2;

import com.example.springData_G2.dao.ProfesorRepository;
import com.example.springData_G2.model.Alumno;
import com.example.springData_G2.model.Profesor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@SpringBootApplication
public class SpringDataG2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringDataG2Application.class, args);

		JpaRepository repoDeProfes = context.getBean(ProfesorRepository.class);

		Profesor profe = new Profesor("Carlitos", "Analista de sistemas");

		Alumno novato = new Alumno("Leandro", 27);

		novato.setProfesor(profe);
		profe.setAlumnos(Arrays.asList(novato));

		repoDeProfes.save(profe);
	}

}
