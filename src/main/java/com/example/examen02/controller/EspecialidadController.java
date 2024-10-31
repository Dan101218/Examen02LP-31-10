package com.example.examen02.controller;


import com.example.examen02.entity.Especialidad;
import com.example.examen02.service.EspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
@CrossOrigin(origins = "http://localhost:8080")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> readAll(){
        try {
            List<Especialidad> especialidades = especialidadService.readAll();
            if(especialidades.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(especialidades, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Especialidad> crear(@Valid @RequestBody Especialidad especialidad) {
        try {
            Especialidad c = especialidadService.create(especialidad);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadId(@PathVariable("id") Long id){
        try {
            Especialidad c = especialidadService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Especialidad> delEspecialidad(@PathVariable("id") Long id){
        try {
            especialidadService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEspecialidad(@PathVariable("id") Long id, @Valid @RequestBody Especialidad especialidad){

        Optional<Especialidad> c = especialidadService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(especialidadService.update(especialidad), HttpStatus.OK);
        }

    }
}
