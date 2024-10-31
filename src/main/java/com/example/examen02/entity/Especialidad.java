package com.example.examen02.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "especialidad")
    @JsonIgnore
    private Set <Doctor> doctores;
}
