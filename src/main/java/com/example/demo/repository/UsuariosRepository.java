package com.example.demo.repository;

import com.example.demo.model.Persona;
import com.example.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query(value = "select p from  Usuarios  p where p.mail = :ident")
    Usuarios buscarPorIdent(String ident);


    Usuarios findByUserName(String userName);

    Usuarios findByUserNameOrMailAndPassword(String userName,String mail,String password);

    List<Usuarios> findByUserNameAndStatus(String userName, Character status);

    List<Usuarios> findByPersona(Persona persona);

}
