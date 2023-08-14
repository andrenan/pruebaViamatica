package com.example.demo.services;

import com.example.demo.model.RolUsuarios;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.RolUsuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RolUsuariosService {


    @Autowired
    private RolUsuariosRepository repo;

    public List<RolUsuarios> listarUsuariosRoles() {
        List<RolUsuarios> rw = new ArrayList<>();
        try {
            rw = repo.findAll();
        } catch (Exception e) {
            log.error("ERROR AL LISTAR USUARIOS-ROLES: {}", e.getLocalizedMessage());
            rw = new ArrayList<>();
        }
        return rw;
    }

    public RolUsuarios buscarPorId(Usuarios idd) {
        RolUsuarios rw = null;
        rw = new RolUsuarios();
        try {
            rw = repo.findByUsuarios(idd);
        } catch (Exception e) {
            log.error("ERROR AL BUSCAR POR ID USUARIOS-ROLES: {}", e.getLocalizedMessage());
            rw = new RolUsuarios();
        }
        return rw;
    }



}
