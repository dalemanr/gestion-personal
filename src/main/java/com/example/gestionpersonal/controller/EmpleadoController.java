package com.example.gestionpersonal.controller;

import com.example.gestionpersonal.exception.ResourceNotFoundException;
import com.example.gestionpersonal.model.Empleado;
import com.example.gestionpersonal.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoController {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @GetMapping("/empleados")
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> findById(@PathVariable Long id) {
        Empleado empleado = empleadoRepository.findById(id).
                orElseThrow(()->
                        new ResourceNotFoundException("No existe el empleado con el id: " + id));
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("/empleados")
    public Empleado save(@RequestBody Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado empleadoEncontrado = empleadoRepository.findById(id).
                orElseThrow(()->
                        new ResourceNotFoundException("No existe el empleado con el id: " + id));

        empleadoEncontrado.setNombre(empleado.getNombre());
        empleadoEncontrado.setApellido(empleado.getApellido());
        empleadoEncontrado.setEmail(empleado.getEmail());

        Empleado empleadoActualizado = empleadoRepository.save(empleadoEncontrado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public void delete(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
    }

}
