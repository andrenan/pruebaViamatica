package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuariosRepository;
import com.example.demo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuariosRepository service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios loginRequest) {
        System.out.println(loginRequest);
        Usuarios usuario = service.findByUsername(loginRequest.getUserName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        if (usuario != null && usuario.getPassword().equals(loginRequest.getPassword())) {
            usuario.setStatus('A');
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            usuario = new Usuarios();
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }
}