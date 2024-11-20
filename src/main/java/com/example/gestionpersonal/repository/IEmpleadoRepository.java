package com.example.gestionpersonal.repository;

import com.example.gestionpersonal.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
}
