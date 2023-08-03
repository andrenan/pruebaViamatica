package com.example.demo.controller;

import com.example.demo.model.Usuarios;
import com.example.demo.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Slf4j
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios loginRequest) {
        log.info("Usuario Loggueado: {}",loginRequest.getUserName());
        return (service.login(loginRequest));
    }
}
