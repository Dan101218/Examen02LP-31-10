package com.example.examen02.service;

import com.example.examen02.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public Doctor create(Doctor escuela);
    public Doctor update(Doctor escuela);
    public void delete(Long id);
    public Optional<Doctor> read(Long id);
    public List<Doctor> readAll();
}
