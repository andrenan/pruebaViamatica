package com.example.demo.repository;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
