package com.example.examen02.serviceImpl;

import com.example.examen02.entity.Especialidad;
import com.example.examen02.repository.DoctorRepository;
import com.example.examen02.repository.EspecialidadRepository;
import com.example.examen02.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Especialidad create(Especialidad Especialidad) {
        return especialidadRepository.save(Especialidad);
    }

    @Override
    public Especialidad update(Especialidad Especialidad) {
        return especialidadRepository.save(Especialidad);
    }

    @Override
    public void delete(Long id) {
        especialidadRepository.deleteById(id);
    }

    @Override
    public Optional<Especialidad> read(Long id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public List<Especialidad> readAll() {
        return especialidadRepository.findAll();
    }
}
