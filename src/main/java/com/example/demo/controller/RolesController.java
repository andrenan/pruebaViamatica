package com.example.demo.controller;

import com.example.demo.services.RolesService;
import com.example.demo.services.UsuariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService service;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/listar")
    public ResponseEntity<?> listarActivos() {
        return new ResponseEntity<>(service.listarTodosLosRoles(), HttpStatus.OK);
    }
}
