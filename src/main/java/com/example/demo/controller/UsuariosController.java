package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.services.UsuariosService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@Slf4j
@AllArgsConstructor
@RequestMapping("/usuariosApi")
public class UsuariosController {
    @Autowired
    private UsuariosService service;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Usuarios items) {
        log.info("Usuario a guardar: {}",items);
        return new ResponseEntity<>(service.guardar(items), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/listarActivos")
    public ResponseEntity<?> listarActivos() {
        return new ResponseEntity<>(service.listarClientesActivos(), HttpStatus.OK);
    }
}
