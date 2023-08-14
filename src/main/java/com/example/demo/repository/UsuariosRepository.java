package com.example.demo.repository;

import com.example.demo.model.Persona;
import com.example.demo.model.RolUsuarios;
import com.example.demo.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    @Query(value = "select p from  Usuarios  p where p.email = :ident")
    Usuarios buscarPorIdent(String ident);


    Usuarios findByUserName(String userName);

    Usuarios findByUserNameOrEmailAndPassword(String userName,String email,String password);

    List<Usuarios> findByUserNameAndStatus(String userName, Character status);

    List<Usuarios> findByPersona(Persona persona);

    @Query(nativeQuery = true, value = "select rr.rol_name from rol_usuarios r \n" +
            "inner join usuarios u on u.id = r.usuarios\n" +
            "inner join rol rr on rr.id = r.rol where r.usuarios=:usuarioss")
    String findRolByUsert(Long usuarioss);

    Optional<Usuarios> findOneByEmail(String email);



}
