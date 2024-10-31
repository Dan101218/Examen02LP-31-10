package com.example.examen02.serviceImpl;

import com.example.examen02.entity.Doctor;
import com.example.examen02.repository.DoctorRepository;
import com.example.examen02.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> read(Long id) {
        return doctorRepository.findById(id) ;
    }

    @Override
    public List<Doctor> readAll() {
        return doctorRepository.findAll();
    }
}
