package com.example.demo.repository;

import com.example.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query(value = "select p from  Usuarios  p where p.mail = :ident")
    Usuarios buscarPorIdent(String ident);
    @Query(value = "select * from  Usuarios  p where p.user_name = :userName limit 1",nativeQuery = true)
    Usuarios findByUsername(String userName);

}
