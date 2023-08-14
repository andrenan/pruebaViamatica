package com.example.demo.controller;

import com.example.demo.model.ResponseService;
import com.example.demo.model.Usuarios;
import com.example.demo.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@Slf4j
//@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {

    @Autowired
    private LoginService service;



    //@PostMapping("/login")
    public ResponseService login(@RequestBody Usuarios loginRequest) {

       return (service.login(loginRequest));
    }
}
