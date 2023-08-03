package com.example.demo.controller;

import com.example.demo.model.RolUsuarios;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.RolUsuariosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/rolUsuariosApi")
public class RolUsuariosController {
    @Autowired
    private RolUsuariosRepository service;
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        System.out.println(id);
        RolUsuarios usuario = service.getByUsuarios(id);

        if(usuario != null){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        else{
            usuario = new RolUsuarios();
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }
}
