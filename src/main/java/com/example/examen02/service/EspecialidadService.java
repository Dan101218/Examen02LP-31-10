package com.example.examen02.service;



import com.example.examen02.entity.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadService {
    public Especialidad create(Especialidad Especialidad);
    public Especialidad update(Especialidad Especialidad);
    public void delete(Long id);
    public Optional<Especialidad> read(Long id);
    public List<Especialidad> readAll();
}
