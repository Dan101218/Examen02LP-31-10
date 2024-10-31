package com.example.examen02.controller;

import com.example.examen02.entity.Doctor;
import com.example.examen02.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "http://localhost:8080")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> readAll(){
        try {
            List<Doctor> doctors = doctorService.readAll();
            if(doctors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Doctor> crear(@Valid @RequestBody Doctor doctor) {
        try {
            Doctor c = doctorService.create(doctor);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorId(@PathVariable("id") Long id){
        try {
            Doctor c = doctorService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delDoctor(@PathVariable("id") Long id){
        try {
            doctorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable("id") Long id, @Valid @RequestBody Doctor doctor){

        Optional<Doctor> c = doctorService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(doctorService.update(doctor), HttpStatus.OK);
        }

    }
}
