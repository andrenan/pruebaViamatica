package com.example.demo.repository;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "select count(*) from  Persona  p where p.identificacion = :ident",nativeQuery = true)
    Long buscarPorIdent(String ident);

    Persona findByIdentificacion(String identificacion);
}
