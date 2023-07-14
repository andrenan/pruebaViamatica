package com.example.demo.services;

import com.example.demo.model.RolUsuarios;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.RolUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RolUsuariosService {
    private static final Logger LOG = Logger.getLogger(RolUsuariosService.class.getName());

    @Autowired
    private RolUsuariosRepository repo;

    public List<RolUsuarios> listarUsuariosRoles( ) {
        List<RolUsuarios> rw = null;
        rw = new ArrayList<>();
        try {
            rw = repo.findAll();

        } catch (Exception e) {
            rw = new ArrayList<>();
        }
        return rw;
    }

    public RolUsuarios buscarPorId(Long idd ) {
        RolUsuarios rw = null;
        rw = new RolUsuarios();
        try {
            rw = repo.getByUsuarios(idd);

        } catch (Exception e) {
            rw = new RolUsuarios();
        }
        return rw;
    }
}
