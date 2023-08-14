package com.example.demo.services;

import com.example.demo.model.Rol;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.RolesRepository;
import com.example.demo.repository.UsuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RolesService {
    @Autowired
    private RolesRepository repo;

    public List<Rol> listarTodosLosRoles() {
        List<Rol> listRoles;
        try {
            listRoles = repo.findAll();

        } catch (Exception e) {
            listRoles = new ArrayList<>();
            log.error("");
        }
        return listRoles;
    }
}
